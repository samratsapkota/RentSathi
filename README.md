Goto Vagrant folder and Run:
vagrant up 
After installation complete:

vagrant ssh kube_master
#to goto master
vagrant ssh kube_worker
#to goto worker

#as master root user
kubeadm init --pod-network-cidr=10.10.0.0/16 --apiserver-advertise-address=192.168.56.24

#on worker as root user
kubeadm join 192.168.56.20:6443 --token xpu627.t3olnaxlcsk6ndht \
        --discovery-token-ca-cert-hash sha256:fb33ef38fc3c134073aba6a249a5a6fe600a7671aae782c7315b74008b15dc8c

#as kube use in master node
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config



wget https://raw.githubusercontent.com/flannel-io/flannel/master/Documentation/kube-flannel.yml

IFACE=$(ip a | grep 192 | rev | tr -s ' ' | cut -d' ' -f '1' | rev)
sed -i 's/10.244.0.0/10.10.0.0/' kube-flannel.yml
sed -i '/^.*kube-subnet/ a \        - --iface='"$IFACE"'' kube-flannel.yml

kubectl apply -f kube-flannel.yml  

verify nodes are working using:

kubectl get nodes

kubernetes cluster have been created.

after:

clone the repo and run:
docker compose up build 

upload the build repo to docker hub register: 
update your image name in k8s/deployment.yml

to run the java application along with elk stacK:
apply the ymls files in k8s folder:

