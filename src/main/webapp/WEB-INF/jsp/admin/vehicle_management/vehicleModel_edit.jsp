<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function () {
        //attach onclick function to remove buttons
        $('.remove_button').click(function () {
            //log name button and contents of associated text box
            console.log(this.name);
            console.log($('#' + this.name).val());
            //clear value of textbox
            $('#' + this.name).val('');
            //submit form
            $('#vehicleModel').submit();
        });
    });
</script>

<div class="wrapper">
    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <legend>Add Details to Model</legend>
        <div class="col-sm-8">
            <c:set var="idx" value="0" scope="page"/>
            <form:form class="form-horizontal" modelAttribute="vehicleModel" action="/admin/vehicleModel/update"
                       method="post">
            <form:hidden path="vehicleModelId"/>
            <form:hidden path="version"/>

            <div class="row">
                <div Class="form-group">
                    <label for="inputVehicleModelName" class="col-sm-2 control-label">Vehicle Model</label>
                    <div class="col-sm-8">
                        <form:input path="vehicleModelName" type="text" id="inputVehicleModelName"
                                    cssClass="form-control"></form:input>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-10">
                    <hr>
                </div>
            </div>

            <legend>Vehicle Details</legend>

            <div class="row">
                <div class="form-group">
                    <div class="col-sm-7">
                        <div class="input-group">
                            <table>
                                <tbody>
                                <c:forEach items="${vehicleModel.vehicleTypeList}" var="vtl">
                                <form:hidden path="vehicleTypeList[${idx}].vehicleTypeId"/>
                                <form:hidden path="vehicleTypeList[${idx}].version"/>
                                    <tr>
                                        <th>Year:&nbsp;</th>
                                        <td>
                                            <form:input path="vehicleTypeList[${idx}].vehicleYear" id="${idx}"
                                                        cssClass="form-control"/>
                                        </td>
                                        <th>Plate:&nbsp;</th>
                                        <td>
                                            <form:input path="vehicleTypeList[${idx}].vehiclePlate" id="${idx}"
                                                        cssClass="form-control"/>
                                        </td>
                                        <td>
                                            <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>
                                        </td>
                                    </tr>
                                    <c:set var="idx" value="${idx + 1}" scope="page"/>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <br>
                <legend>Add New Details</legend>
                <div class="row">
                    <div class="form-group">
                        <label for="inputNewYear" class="col-sm-3 control-label">Add New Year</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="inputNewYear" id="inputNewYear"/>
                        </div>
                        <label for="inputNewPlate" class="col-sm-3 control-label">Add New Plate</label>
                        <div class="col-sm-7">
                            <input Type="text" class="form-control" name="inputNewPlate" id="inputNewPlate"/>
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