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
                    <c:forEach var="vm" items="${vehicleMakeList}">
                        <tr>
                            <td>${vm.vehicleMakeId}</td>
                            <td>${vm.vehicleMakeName}</td>
                            <td> models here </td>
                            <td> types here </td>
<%--                            <td>--%>
<%--                                <c:forEach var="vml" items="${vehicleMakeList}">--%>
<%--                                    <ul style="list-style: none">--%>
<%--                                    <c:if test="${vm.vehicleType.vehicleTypeName == vt.vehicleTypeName}">--%>
<%--                                        <li>${vm.vehicleMakeName}</li>--%>
<%--                                    </c:if>--%>
<%--                                    </ul>--%>
<%--                                </c:forEach>--%>
<%--                            </td>--%>
<%--                            <td>--%>
<%--                                <c:forEach var="vmo" items="${vehicleModelList}">--%>
<%--                                    <ul style="list-style: none">--%>
<%--                                    <c:if test="${vmo.vehicleMake.vehicleType.vehicleTypeName == vt.vehicleTypeName}">--%>
<%--                                        <li>${vmo.vehicleModelName}</li>--%>
<%--                                    </c:if>--%>
<%--                                    </ul>--%>
<%--                                </c:forEach>--%>
<%--                            </td>--%>
                            <td><a href="/admin/vehicle/edit/${vm.vehicleMakeId}">Edit</a></td>
                            <td><a href="/admin/vehicle/delete/${vm.vehicleMakeId}">Delete Row</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>