<#include "base.ftl">
<#macro title>Проедшие матчи</#macro>
<#macro content>
<section class="page">
    <div class="container">
        <#if playedMatches?has_content>
            <#list playedMatches as pm>
                <div class="col-lg-12 near_matches" style="padding: 10px; margin: 15px">
                    <div class="row">
                        <div class="col-lg-4 team" style="text-align: center">
                            <div class="logoMatches">
                                <img style="float: right"
                                     src="/img/teams/${pm.firstTeam.id}.jpg"
                                     alt>
                            </div>
                            <b style="font-size: 35px">${pm.firstTeamName}</b>
                        </div>
                        <div class="col-lg-4 team" style="text-align: center; margin-top: 25px">
                            <b style="font-size: 80px">${pm.firstTeamScore}:${pm.secondTeamScore}</b> <br>
                        </div>
                        <div class="col-lg-4 team" style="text-align: center">
                            <div class="logoMatches">
                                <img style="float: left"
                                     src="/img/teams/${pm.secondTeam.id}.jpg"
                                     alt>
                            </div>
                            <b style="font-size: 35px">${pm.secondTeamName}</b>
                        </div>
                    </div>
                    <div class="col-lg-12" style="margin-top: 15px">
                        <div class="row">
                            <button id="pb${pm.id}" onclick="sh${pm.id}()" class="btn-group-lg"
                                    style="float: left; margin-left: 140px">Инфо
                            </button>
                            <button id="mb${pm.id}" onclick="cl${pm.id}()" class="btn-group-lg"
                                    style="float: left; margin-left: 140px; display: none;">Скрыть
                            </button>
                            <button class="btn-group-lg" onclick="location.href = '/album?id=${pm.id}&page=1'"
                                    style="float: right; margin-right: 140px">Фото
                            </button>
                        </div>
                    </div>
                    <div id="content${pm.id}" class="col-md-4 col-md-offset-4 aboutGoals"
                         style="text-align: center; display: none;">
                        <p>${pm.aboutGoals}</p>
                    </div>
                    <script>
                        function sh${pm.id}() {
                            $("#content${pm.id}").show();
                            $("#pb${pm.id}").hide();
                            $("#mb${pm.id}").show();
                        }

                        function cl${pm.id}() {
                            $("#content${pm.id}").hide();
                            $("#mb${pm.id}").hide();
                            $("#pb${pm.id}").show();
                        }
                    </script>
                </div>
            </#list>
        </#if>

        <div class="col-lg-12" style="display: inline">
            <div class="row col-md-4 col-md-offset-4" style="text-align: center;">
                <#if 0 < pageNumber>
                    <a href="/played/${pageNumber - 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: left">←Назад>
                        </button>
                    </a>
                </#if>

                <#if pageNumber < maxPageNumber>
                    <a href="/played/${pageNumber + 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: right;"> Вперёд→
                        </button>
                    </a>
                </#if>
            </div>
        </div>

    </div>
</section>
</#macro>