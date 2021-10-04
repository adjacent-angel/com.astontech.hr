<nav class="navbar navbar-static-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <%--HOME--%>
            <button type="button"  class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Home</a>
        </div>
        <div calss="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--PAGELINKS--%>
                <li class="nav-item"><a class="nav-link" href="/employee">Employee</a></li>
                <li class="nav-item"><a class="nav-link" href="/project">Project</a></li>
                <li class="nav-item"><a class="nav-link" href="/contact">Contact</a></li>
                <li class="nav-item"><a class="nav-link" href="/admin">Admin</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--LOGIN LINK--%>
                <li class="nav-item"><a class="nav-link" href="#">Login</a></li>
            </ul>
        </div>
    </div>
</nav>