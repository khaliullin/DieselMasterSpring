<#include "base.ftl">

<#macro title>Состав</#macro>

<#macro content>
<section class="page">
    <div class="container">
        <div class="col-md-11 search-border">Поиск &nbsp <i class="fa fa-search" aria-hidden="true"></i>
            <input class="search-field" type="text" name="name" id="name" oninput="func()">

            <select name="position" id="position" class="position" onchange="func()">
                <option value="A">Все</option>
                <option value="W">Нападающий</option>
                <option value="D">Защитник</option>
                <option value="G">Вратарь</option>
            </select>
        </div>

        <div class="result" id="res">Список игроков</div>
    <#--<div class="playersList" id="res"></div>-->
    <#--<#if allPlayers?has_content>-->
    <#--<#list allPlayers as p>-->
    <#--<div class="col-md-11 col-md-offset-1 team_list" style="margin: 5px;">-->
    <#--<a class="row" href="/player?id=${p.id}" style="padding: 5px">-->
    <#--<p style="margin: auto">#${p.number}-->
    <#--<img src="http://localhost:8080/files/players/${p.id}.jpg">-->
    <#--&nbsp ${p.firstName} ${p.lastName}</p>-->
    <#--</a>-->
    <#--</div>-->
    <#--</#list>-->
    <#--</#if>-->
    </div>
</section>

<script type="application/javascript">
    var func = function () {
        $.ajax({
            'contentType': 'application/javascript; charset=utf-8',
            'url': '/search',
            'data': {
                'name': $("#name").val(),
                'position': $("#position").val()
            },
            'type': 'get',
            'success': function (obj) {
                var data = obj;
                var htmlText = "";
                for (var key in data) {
                    htmlText += "<div class=\"col-md-11 col-md-offset-1 team_list\" style=\"margin: 5px;\">";
                    htmlText += "<a class=\"row\" href=\"/player/" + data[key].id + "\" style=\"padding: 5px\">";
                    htmlText += "<p style=\"margin: auto\">#" + data[key].number + " ";
                    htmlText += "<img src=\"/img/players/" + data[key].id + ".jpg\">";
                    htmlText += "&nbsp " + data[key].firstName + " " + data[key].lastName + "</p>";
                    htmlText += "</a>";
                    htmlText += "</div>";
                }
                $("#res").html(htmlText);
            }
        })
    };

    $(document).ready()
    {
        func();
    }
</script>
</#macro>