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
                    <c:forEach var="vm" items="${vehicleMakeList}">
                        <tr>
                            <td>${vt.vehicleTypeId}</td>
                            <td>${vt.vehicleTypeName}</td>
                            <td>${vm.vehicleMakeName}</td>
                        </tr>
                    </c:forEach>
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
                    <c:forEach var="vm" items="${vehicleMakeList}">
                        <c:forEach var="vmo" items="${vehicleModelList}">
                            <tr>
                                <td>${vt.vehicleTypeId}</td>
                                <td>${vm.vehicleMakeName}</td>
                                <td>${vmo.vehicleModelName}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
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

<%--        <div class="col-sm-8">--%>
<%--            <c:set var="idx" value="0" scope="page" />--%>
<%--            <form:form class="form-horizontal" modelAttribute="vehicleType" action="/admin/vehicle/update" method="post">--%>
<%--                <form:hidden path="vehicleTypeId" />--%>
<%--                <form:hidden path="version" />--%>
<%--                <div class="row">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="inputVehicleType" class="col-sm-2 control-label">Vehicle Type</label>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <form:input path="vehicleType" type="text" id="inputVehicleType" cssClass="form-control"></form:input>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row">--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <hr>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <c:forEach items="${vehicleMake.vehicleMakeList}" var="vehicle">--%>
<%--                    <form:hidden path="vehicleMakeList[${idx}].vehicleMakeId" />--%>
<%--                    <form:hidden path="vehicleMakeList[${idx}].version" />--%>
<%--                    <div class="row">--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="${idx}" class="col-sm-3 control-label">Vehicle Make</label>--%>
<%--                            <div class="sol-sm-7">--%>
<%--                                <div class="input-group">--%>
<%--                                    <form:input path="vehicleMakeList[${idx}].vehicleMake" id="${idx}" cssClass="form-control" />--%>
<%--                                    <span class="input-group-btn">--%>
<%--                                        <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>--%>
<%--                                    </span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <c:set var="idx" value="${idx + 1}" scope="page" />--%>
<%--                </c:forEach>--%>

<%--                <c:forEach items="${vehicleModel.vehicleModelList}" var="vehicleModel">--%>
<%--                    <form:hidden path="vehicleModelList[${idx}].vehicleModelId" />--%>
<%--                    <form:hidden path="vehicleModelList[${idx}].version" />--%>
<%--                    <div class="row">--%>
<%--                        <div class="form-group">--%>
<%--                            <label for="${idx}" class="col-sm-3 control-label">Vehicle Model</label>--%>
<%--                            <div class="sol-sm-7">--%>
<%--                                <div class="input-group">--%>
<%--                                    <form:input path="vehicleModelList[${idx}].vehicleModel" id="${idx}" cssClass="form-control" />--%>
<%--                                    <span class="input-group-btn">--%>
<%--                                        <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>--%>
<%--                                    </span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <c:set var="idx" value="${idx + 1}" scope="page" />--%>
<%--                </c:forEach>--%>

<%--                <div class="row">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="inputNewVehicleMake" class="col-sm-3 control-label">Add New Vehicle Make</label>--%>
<%--                        <div class="col-sm-7">--%>
<%--                            <input type="text" class="form-control" name="inputNewVehicleMake" id="inputNewVehicleMake" />--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row">--%>
<%--                    <button class="btn btn-primary">Update Type</button>--%>
<%--                </div>--%>
<%--            </form:form>--%>
<%--            <div class="row">--%>
<%--                <button class="btn btn-default"><a href="/admin/vehicle/list">Back to List</a></button>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </div>--%>
</div>

<%@include file="../../includes/footer.jsp"%>