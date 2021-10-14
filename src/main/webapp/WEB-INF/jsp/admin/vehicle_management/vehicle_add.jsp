<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function() {
        $("#successAlert").delay(5000).fadeOut(2000);
        $("#warningAlert2").delay(5000).fadeOut(2000);
    });
</script>

<div class="wrapper">
    <%@include file="vehicle_sidebar.jsp"%>

    <div id="main-wrapper" class="col-md-10">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                    <legend>Add New Vehicle</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleMake" type="text" cssClass="form-control" id="inputNewVehicleMake" placeholder="Vehicle Make Name"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleModel" class="col-lg-2 control-label">Vehicle Model(s)</label>
                        <div class="col-lg-10">
                            <form:textarea path="newVehicleModel" cssClass="form-control" rows="3" id="inputNewVehicleModel" placeholder="Vehicle Model Name(s)"></form:textarea>
                            <span class="help-block">Enter each new Model on a new line.</span>
                        </div>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="inputNewVehicleModelName" class="col-lg-2 control-label">Vehicle Model</label>--%>
<%--                        <div class="col-lg-10">--%>
<%--                            <form:input path="newVehiceModelName" cssClass="form-control" id="inputNewVehicleModelName" placeholder="Vehicle Model Name"></form:input>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button disabled="true" class="btn btn-default"></form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>

        <div class="col-sm-4">
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Added successfully to the database!</strong>
                </div>
            </div>

            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert2">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised</h4>
                    <p>All fields required. Please enter a Vehicle Type and associated Vehicle Make and Model.</p>
                </div>
            </div>

            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Error</strong>
                </div>
            </div>
        </div>
    </div>
</div>