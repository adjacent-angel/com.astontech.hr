<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">
    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <c:set var="idx" value="0" scope="page"/>

        <form:form class="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/update" method="post">
            <form:hidden path="vehicleType.vehicleTypeId"/>

            <div class="col-sm-10">
                <table class="table table-striped table-hover">
                    <tbody>
                    <tr>
                        <th>Vehicle Type</th>
                    </tr>
                    <tr>
                        <td><form:input path="vehicleType.vehicleTypeName" type="text" id="VehicleTypeName" cssClass="form-control"></form:input></td>
                        <td>
                            <button class="btn btn-default update_type">Update Vehicle Type</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form:form>
    </div>
</div>

<%@include file="../../includes/footer.jsp" %>
