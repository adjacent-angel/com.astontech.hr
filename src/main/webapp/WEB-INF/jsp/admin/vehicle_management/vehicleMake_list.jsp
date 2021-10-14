<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <legend>Vehicle Make Management List</legend>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Vehicle Make</th>
                        <th>Model List</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vm" items="${vehicleMakeList}">
                        <tr>
                            <td>${vm.vehicleMakeId}</td>
                            <td>${vm.vehicleMakeName}</td>
                            <td><a href="/admin/vehicle/edit/${vm.vehicleMakeId}"><button class="btn btn-primary">Model List</button></a></td>
                            <td><a href="/admin/vehicle/delete/${vm.vehicleMakeId}"><button class="btn btn-danger">Delete Row</button></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>