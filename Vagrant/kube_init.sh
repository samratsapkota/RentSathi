######## ALL NODES #############
yum install -y ntp && systemctl start ntpd
ntpdate -bv pool.ntp.org

#Temporary Swap memory removal
swapoff -a

#Permanent Swap memory removal
sed -i 's|^/swapfile.*|#/swapfile none swap defaults 0 0|g' /etc/fstab

systemctl stop firewalld && systemctl disable firewalld
lsmod | grep br_netfilter

cat <<EOF | tee /etc/modules-load.d/k8s.conf
br_netfilter
EOF

cat <<EOF | tee /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF

sysctl --system

yum install -y epel-release wget
yum install -y yum-utils
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

yum install -y docker-ce docker-ce-cli containerd.io --disableplugin=fastestmirror

mkdir -p /etc/docker

cat <<EOF | tee /etc/docker/daemon.json
{
  "exec-opts": ["native.cgroupdriver-systemd"],
  "log-driver": "json-file",
  "log-opts": {
    "max-size": "100m"
  },
  "storage-driver": "overlay2"
}
EOF

systemctl daemon-reload
systemctl restart docker
systemctl enable docker
systemctl status docker
 

cat <<EOF | sudo tee /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://pkgs.k8s.io/core:/stable:/v1.30/rpm/
enabled=1
gpgcheck=1
gpgkey=https://pkgs.k8s.io/core:/stable:/v1.30/rpm/repodata/repomd.xml.key
exclude=kubelet kubeadm kubectl cri-tools kubernetes-cni
EOF


setenforce 0
sed -i 's/^SELINUX=enforcing$/SELINUX=permissive/' /etc/selinux/config

yum install -y kubelet kubeadm kubectl --disableexcludes=kubernetes --disableplugin=fastestmirror
systemctl enable --now kubelet

## CONFIGURING CONTAINERD
sed -i '/^disabled_plugins.*/a \ \ endpoint = "unix:///var/run/containerd/containerd.sock"' /etc/containerd/config.toml
sed -i '/^disabled_plugins.*/a [plugins."io.containerd.grpc.v1.cri".containerd]' /etc/containerd/config.toml
sed -i '/^disabled_plugins.*/a enabled_plugins = ["cri"]' /etc/containerd/config.toml
sed -i 's/^disabled_plugins.*/#disabled_plugins = ["cri"]/' /etc/containerd/config.toml
systemctl restart containerd

# CONFIGURING KUBELET
NODE_IP=$(ip a | grep 192 | tr -s ' ' | cut -d' ' -f3 | cut -d'/' -f1)
sed -i 's/$/--node-ip='"$NODE_IP"'/' /etc/sysconfig/kubelet