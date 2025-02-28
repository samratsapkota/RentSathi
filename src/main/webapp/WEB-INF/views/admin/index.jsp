<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath }/resources/admin/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath }/resources/admin/css/sb-admin-2.min.css"
	rel="stylesheet">
<%
session = request.getSession();
int rooms = (Integer) session.getAttribute("rooms");
int house = (Integer) session.getAttribute("house");
int flats = (Integer) session.getAttribute("flats");
%>

<style>
        .piechart {
            width: 200px;
            height: 200px;
            border-radius: 50%;
            /* Adjust the colors and angles based on your data */
            background-image: conic-gradient(
                pink ${rooms}deg,
                lightblue ${house}deg,
                orange ${flats}deg
            );
        }
    </style>

</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fa-regular fa-folder"></i>
				</div>
				<div class="sidebar-brand-text mx-3">RentSathi Admin</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/index"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/users"> <i
					class="fa-solid fa-users"></i> <span>User</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/rentlistings"> <i
					class="fas fa-fw fa-table"></i> <span>Rent Listing</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/bookinglistings">
					<i class="fas fa-fw fa-table"></i> <span>Booking Listing</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/intro"> <i
					class="fas fa-fw fa-table"></i> <span>Go to Home page</span></a></li>
			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>
					<!-- Nav Item - Search Dropdown (Visible Only XS) -->
					<li class="nav-item dropdown no-arrow d-sm-none"><a
						class="nav-link dropdown-toggle" href="#" id="searchDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
					</a></li>

					<div class="topbar-divider d-none d-sm-block"></div>

					<!-- Nav Item - User Information -->
					

					

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
					</div>

					<%
					Integer numberOfRentListings = (Integer) session.getAttribute("numberOfRentListings");
					%>
					<!-- Content Row -->
					<div class="row">

						<!-- Total Listings (Monthly) Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												Total Listings</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=numberOfRentListings%></div>
										</div>
										<div class="col-auto">
											<i class="fa-solid fa-list fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Total Users (Monthly)  Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-success text-uppercase mb-1">
												Total Users</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${sessionScope.numberOfUsers}</div>
										</div>
										<div class="col-auto">
											<i class="fa-solid fa-users fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- No. of bookings (Monthly) Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-success text-uppercase mb-1">
												No. of Bookings</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${sessionScope.numberOfListings}</div>
										</div>
										<div class="col-auto">
											<i class="fa-solid fa-users fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Content Row -->

					<div class="row">
						<!-- Pie Chart -->
						<div>
						Rooms: ${rooms }
						Flats: ${flats }
						House: ${house }
						</div>
						<%-- <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">Availability of Property</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">${sessionScope.numberOfListings}</a>
                                            <a class="dropdown-item" href="#">${sessionScope.numberOfListings}</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">${sessionScope.numberOfListings}</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> Room
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> Flat
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-info"></i> House
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div> --%>
						<div class="piechart"></div>
					</div>


				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; RentSathi 2024</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->

		<script src="<c:url value="/resources/admin/jquery/jquery.min.js"/>"></script>
		<script
			src="<c:url value="/resources/admin/js/bootstrap.bundle.min.js"/>"></script>

		<!-- Core plugin JavaScript-->
		<script
			src="<c:url value="/resources/admin/jquery/jquery.easing.min.js"/>"></script>

		<!-- Custom scripts for all pages-->
		<script src="<c:url value="/resources/admin/js/sb-admin-2.min.js"/>"></script>

		<!-- Page level plugins -->
		<script src="<c:url value="/resources/admin/js/Chart.min.js"/>"></script>

		<!-- Page level custom scripts -->
		<script src="<c:url value="resources/admin/js/chart-area-demo.js"/>" /></script>
		<script src="<c:url value="/resources/admin/js/chart-pie-demo.js"/>"></script>
</body>
</html>