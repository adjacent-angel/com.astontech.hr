<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function() {
        //attach onclick function to remove buttons
        $('.remove_button').click(function() {
            //log name button and contents of associated text box
            console.log(this.name);
            console.log($('#'+this.name).val());
            //clear value of textbox
            $('#'+this.name).val('');
            //submit form
            $('#vehicleMake').submit();
        });
    });
</script>

<div class="wrapper">
    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <c:set var="idx" value="0" scope="page" />
            <form:form class="form-horizontal" modelAttribute="vehicleMake" action="/admin/vehicle/update" method="post">
                <form:hidden path="vehicleMakeId" />
                <form:hidden path="version" />

            <div class="row">
                <div Class="form-group">
                    <label for="inputVehicleMakeName" class="col-sm-2 control-label">Vehicle Make</label>
                    <div class="col-sm-8">
                        <form:input path="vehicleMakeName" type="text" id="inputVehicleMakeName" cssClass="form-control"></form:input>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-10">
                    <hr>
                </div>
            </div>

            <c:forEach items="${vehicleMake.vehicleModelList}" var="vmo">
                <form:hidden path="vehicleModelList[${idx}].vehicleModelId" />
                <form:hidden path="vehicleModelList[${idx}].version" />
                <div class="row">
                    <div class="form-group">
                        <label for="${idx}" class="col-sm-3 control-label">Vehicle Model</label>
                        <div class="col-sm-7">
                            <div class="input-group">
                                <form:input path="vehicleModelList[${idx}].vehicleModelName" id="${idx}" cssClass="form-control" />
                                <span class="input-group-btn">
                                    <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <c:set var="idx" value="${idx + 1}" scope="page" />
            </c:forEach>

            <div class="row">
                <div class="form-group">
                    <label for="inputNewModel" class="col-sm-3 control-label">Add New Model</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="inputNewModel" id="inputNewModel"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <button class="btn btn-primary">Update</button>
            </div>
            </form:form>
        </div>
    </div>
</div>


<%@include file="../../includes/footer.jsp" %>
