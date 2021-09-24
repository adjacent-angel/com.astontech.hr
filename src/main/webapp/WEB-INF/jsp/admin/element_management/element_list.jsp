<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav_admin.jsp"%>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="element_sidebar.jsp"%>

        <div id="main-wrapper" class="col-md-11 pull-right">
            <div class="col-lg-8 col-md-7 col-sm-6">
                <%--LIST OF EXISTING ELEMENTS--%>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Element Type</th>
                            <th>Elements</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="elementType" items="${elementTypeList}">
                            <tr>
                                <td>${elementType.elementTypeId}</td>
                                <td>${elementType.elementTypeName}</td>
                                <td>Elements will go here...</td>
                                <td><a href="/admin/element/edit/${elementType.elementTypeId}">Edit</a></td>
                                <td><a href="/admin/element/delete/${elementType.elementTypeId}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

</div>

<%@include file="../../includes/footer.jsp"%>