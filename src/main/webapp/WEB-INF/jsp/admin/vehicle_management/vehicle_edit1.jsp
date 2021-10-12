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

        <form:form class="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/update1" method="post">
            <form:hidden path="vehicleType.vehicleTypeId"/>

        <div class="col-sm-10">
            <table class="table table-striped table-hover">
                <tbody>
                <tr>
                    <th>Vehicle Type</th>
                </tr>
                <tr>
                    <td>
                    <c:out value="${vehicleVO.vehicleType.vehicleTypeName}" ></c:out>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
<%--            </c:forEach>--%>

        <div class="col-sm-10">

                <form:hidden path="vehicleMake.vehicleMakeId"/>
                <form:hidden path="vehicleMakeList[${idx}].vehicleMakeId"/>
                <table class="table table-striped table-hover">
                    <tbody>
                    <tr>
                        <th>Vehicle Make</th>
                    </tr>
                    <c:forEach items="${vehicleVO.vehicleMakeList}">
                        <tr>
                            <td class="input-group">
                                <form:input path="vehicleMakeList[${idx}].vehicleMakeName" type="text" id="VehicleMakeName" cssClass="form-control"></form:input>
                                <span class="input-group btn">
                                    <button class="btn btn-default">Update Vehicle Make</button>
                                    <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>
                                </span>
                            </td>
                            <c:set var="idx" value="${idx + 1}" scope="page"/>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form:form>
        </div>
    </div>
</div>
