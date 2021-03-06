<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>

        <%--FAVICON--%>

        <%--JQUERY--%>
        <c:url value="/webjars/jquery/3.6.0/jquery.min.js" var="jquery" />
            <script src="${jquery}"></script>

        <%--BOOTSTRAP--%>
        <c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" var="bootstrapJS" />
            <script src="${bootstrapJS}"></script>

<%--        <c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" var="bootstrapCSS" />--%>
<%--            <link href="${bootstrapCSS}" rel="stylesheet" media="screen" />--%>
        <%--BOOTSWATCH CSS--%>
        <c:url value="/static/css/bootswatch_paper.css" var="bootstrapCSS" />
            <link href="${bootstrapCSS}" rel="stylesheet" media="screen" />

        <%--CUSTOM JS--%>
        <c:url value="/static/js/common.js" var="common" />
            <script src="${common}"></script>

        <%--CUSTOM CSS--%>
        <c:url value="/static/css/astonengineer.css" var="bootstrap_custom" />
            <link href="${bootstrap_custom}" rel="stylesheet" media="screen">

        <title>Aston Technologies HR Application</title>

    </head>
<body>


