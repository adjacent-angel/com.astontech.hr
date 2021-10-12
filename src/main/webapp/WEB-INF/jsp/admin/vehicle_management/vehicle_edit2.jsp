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
            $('#vehicleVO').submit();
        });
    });

</script>

<div class="wrapper">
    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <c:set var="idx" value="0" scope="page"/>

        <form:form class="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/update2" method="post">
            <form:hidden path="vehicleType.vehicleTypeId"/>



            <div class="col-sm-10">
                <table class="table table-striped table-hover">
                    <tbody>
                    <tr>
                        <th>Vehicle Type</th>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${vehicleVO.vehicleType.vehicleTypeName}"></c:out>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <form:hidden path="vehicleMake.vehicleMakeId"/>
            <form:hidden path="vehicleMakeList[${idx}].vehicleMakeId"/>
            <div class="col-sm-10">
                <table class="table table-striped table-hover">
                    <tbody>
                    <tr>
                        <th>Vehicle Make</th>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${vehicleVO.vehicleMakeList[idx].vehicleMakeName}"></c:out>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="col-sm-10">
                <c:set var="idx2" value="0" scope="page"/>
                <form:hidden path="vehicleModel.vehicleModelId"/>
                <form:hidden path="vehicleModelList[${idx2}].vehicleModelId"/>
                <table class="table table-striped table-hover">
                    <tbody>
                    <tr>
                        <th>Vehicle Model(s)</th>
                    </tr>
                    <c:forEach items="${vehicleVO.vehicleModelList}">
                        <tr>
                            <td class="input-group">
                                <form:input path="vehicleModelList[${idx2}].vehicleModelName" type="text" id="VehicleModelName" cssClass="form-control"></form:input>
                                <span class="input-group btn">
                                    <button class="btn btn-default">Update Vehicle Model</button>
                                    <button name="${idx2}" class="btn btn-default remove_button" type="button">Remove</button>
                                </span>
                            </td>
                            <c:set var="idx" value="${idx2 + 1}" scope="page"/>
                            <c:set var="idx" value="${idx + 1}" scope="page"/>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="input-group">
                            <input type="text" class="form-control" name="inputNewModelName" id="inputNewModelName"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default">Add New Model</button>
                            </span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form:form>
    </div>
</div>
