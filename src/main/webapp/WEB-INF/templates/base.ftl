<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="ru">

<head>
    <meta charset="utf-8"/>
<title><@title></@title></title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="shortcut icon" href="/favicon.png"/>
    <script src="/js/jquery-3.1.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/common.js"></script>
    <link rel="stylesheet" href="/slider/generic.css"/>
    <link rel="stylesheet" href="/slider/js-image-slider.css"/>
    <link rel="stylesheet" href="/css/main.css"/>
    <link rel="stylesheet" href="/css/media.css"/>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
    <script src="/slider/js-image-slider.js"></script>
</head>

<body>
<header class="topMenu">
    <div class="header_topline">
        <div class="container">
            <div class="col-md-12">
                <div class="row">
                    <div class="top_menu">
                        <div class="logo">
                            <a href="/" class="logo">
                                <img src="http://team.dieselmaster.org/img/logo.png" width="208px" height="93px">
                            </a>
                        </div>
                        <nav class="top_links clearfix">
                            <button class="top_links_button hidden-md hidden-lg hidden-sm"><i
                                    class="fa fa-bars"></i></button>
                            <ul>
                                <li><a href="/future/0">Игры</a></li>
                                <li><a href="/discussions/0">Обсуждения</a></li>
                                <li><a href="/albums/0">Фото</a></li>
                                <li><a href="/players">Состав</a></li>
                            <#if admin?has_content>
                                <li><a href="/admin">+</a></li>
                            </#if>
                            <#if logined?has_content>
                                <li><a href="/logout">Выход</a></li>
                            </#if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="main-page" style="min-height: 80vh; margin-top: 23px;">

<@content></@content>
</div>
<footer class="footer">
    <div class="container">
        <div class="col-md-12">
            <div class="row">
                <div class="col-xs-6" style="float: left">©2014-15 ХК «Дизель Мастер». <br>Все права защищены</div>
                <div class="col-xs-6" style="float: right; text-align: right">Связаться с администрацией <br>
                    <a href="mailto:#">e-mail</a>
                </div>
            </div>
        </div>
    </div>
</footer>

</body>
</html>









