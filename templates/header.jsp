<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header>
    <div id="logoContainer">
        <a href="home.jsp"><img src="img/logo2.png"></a>
        <a href="home.jsp">WorldCrafters</a>
    </div>

    <div id="categoriesContainer">
        <a onclick="toggleSidebar()">Categorie</a>
    </div>

    <form id="searchbarContainer" onclick="closeAll()">
        <input type="text" placeholder="Cerca...">
        <button type="submit"><i class="fa fa-search fa-xl" aria-hidden="true"></i></button>
    </form>

    <nav id="topnavContainer">
        <a href="home.jsp">Home</a>
        <a href="#"><i class="fa fa-heart fa-xl" aria-hidden="true"></i></a>
        <a href="cart.jsp"><i class="fa fa-shopping-cart fa-xl" aria-hidden="true"></i></a>
        <a onclick="toggleUserbar()"><i class="fa fa-user fa-xl" aria-hidden="true"></i></a>
    </nav>
</header>
<div id="headerSpace"></div>