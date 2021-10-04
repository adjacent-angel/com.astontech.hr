<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <legend>Vehicle Management List</legend>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Type</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                    <th>Edit</th>
                    <th>Delete</th>
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
                        <td>
                            <c:forEach var="vmo" items="${vehicleModelList}">
                                <c:if test="${vmo.vehicleMake.vehicleType.vehicleTypeName == vt.vehicleTypeName}">
                                    ${vmo.vehicleModelName}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td><a href="/admin/vehicle/edit/">Edit</a></td>
                        <td><a href="/admin/vehicle/delete/${vt.vehicleTypeId}">Delete</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>