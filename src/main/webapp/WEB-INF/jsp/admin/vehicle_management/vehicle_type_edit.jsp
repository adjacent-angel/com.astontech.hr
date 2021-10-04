<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

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
            $('#vehicleType').submit();
        });
    });

</script>
<div class="wrapper">

    <%--SIDEBAR--%>
    <%@include file="vehicle_edit_sidebar.jsp"%>

    <div id="main-wrapper" class="col-sm-10">

        <div class="col-sm-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
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
        </div>

        <div class="col-sm-12">
          <c:set var="idx" value="0" scope="page" />
            <form:form class="form-horizontal" modelAttribute="vehicleTypeList" action="/admin/vehicle/type/edit" method="post">
                <form:hidden path="vehicleTypeId" />
                <form:hidden path="version" />
                <div class="row">
                    <div class="form-group">
                        <label for="inputVehicleTypeName" class="col-sm-2 control-label">Vehicle Type</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleType" type="text" id="inputVehicleTypeName" cssClass="form-control"></form:input>
                        </div>
                    </div>
                </div>

               <c:forEach var="vt" items="${vehicleTypeList}">
                   <form:hidden path="vehicleTypeList[${idx}].vehicleTypeId" />
                   <form:hidden path="vehicleTypeList[${idx}].version" />
                   <div class="row">
                       <div class="form-group">
                           <label for="${idx}" class="col-sm-3 control-label">Vehicle Type</label>
                           <div class="sol-sm-7">
                               <div class="input-group">
                                   <form:input path="vehicleTypeList[${idx}].vehicleType" id="${idx}" cssClass="form-control" />
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
                        <label for="inputNewVehicleTypeName" class="col-sm-3 control-label">Add New Vehicle Type</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="inputNewVehicleTypeName" id="inputNewVehicleTypeName" />
                        </div>
                    </div>
                </div>


                <div class="row">
                    <button class="btn btn-primary">Update Type</button>
                </div>
            </form:form>
          <div class="row">
              <button class="btn btn-default"><a href="/admin/vehicle/edit">Back to Edit</a></button>
          </div>
      </div>
    </div>
</div>
