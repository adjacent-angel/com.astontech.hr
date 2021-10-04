<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>


<div class="wrapper">

    <%--SIDEBAR--%>
    <%@include file="vehicle_edit_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">
        <div Class = "col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Vehicle Type Id</th>
                        <th>Vehicle Type</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="vt" items="${vehicleTypeList}">
                    <tr>
                        <td>${vt.vehicleTypeId}</td>
                        <td>${vt.vehicleTypeName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr>
            <div class="row">
                <button class="btn btn-default">
                    <a href="/admin/vehicle/type/edit">Edit Vehicle Type List</a>
                </button>
            </div>
            <hr style="height: 10px; background:#2196f3; border-radius: 10px;">
        </div>

        <div Class = "col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Vehicle Type Id</th>
                    <th>Vehicle Type</th>
                    <th>Vehicle Make</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vt" items="${vehicleTypeList}">
                    <tr>
                        <td>${vt.vehicleTypeId}</td>
                        <td>${vt.vehicleTypeName}</td>
                        <td>
                            <c:forEach var="vm" items="${vehicleMakeList}">
                                <c:if test="${vm.vehicleType.vehicleTypeName == vt.vehicleTypeName}">
                                    ${vm.vehicleMakeName}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr>
            <div class="row">
                <button class="btn btn-default">
                    <a href="/admin/vehicle/make/edit">Edit Vehicle Make List</a>
                </button>
            </div>
            <hr style="height: 10px; background:#2196f3; border-radius: 10px;">
        </div>

        <div Class = "col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Vehicle Type Id</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vt" items="${vehicleTypeList}">
                    <tr>
                        <td>${vt.vehicleTypeId}</td>
                        <td>
                            <c:forEach var="vm" items="${vehicleMakeList}">
                                <c:if test="${vm.vehicleType.vehicleTypeName == vt.vehicleTypeName}">
                                    ${vm.vehicleMakeName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="vmo" items="${vehicleModelList}">
                                <c:if test="${vmo.vehicleMake.vehicleType.vehicleTypeName == vt.vehicleTypeName}">
                                    ${vmo.vehicleModelName}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr>
            <div class="row">
                <button class="btn btn-default">
                    <a href="/admin/vehicle/model/edit">Edit Vehicle Model List</a>
                </button>
            </div>
        </div>

</div>

<%@include file="../../includes/footer.jsp"%>