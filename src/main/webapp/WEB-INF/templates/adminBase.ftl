<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title><@title>Admin</@title></title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="/js/jquery-3.1.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/admin.css"/>
    <link rel="stylesheet" href="/css/media.css"/>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
</head>

<body>
<header class="topMenu">
    <h1>Панель администратора</h1>
    <a href="/"><h5>Главная</h5></a>
    <a href="/logout"><h5>Выход</h5></a>
</header>

<div class="main-page" style="min-height: 80vh; margin-top: 30px;">

<@content></@content>
</div>

</body>
</html>









