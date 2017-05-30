<#include "base.ftl">
<#macro title>Предстоящие матчи</#macro>
<#macro content>
<section class="page">
    <div class="container">
        <#if futureMatches?has_content>
            <#list futureMatches as fm>
                <div class="col-lg-12 near_matches" style="padding: 10px; margin: 15px">
                    <div class="col-lg-4 team" style="text-align: center">
                        <div class="logoMatches">
                            <img style="float: right"
                                 src="/img/teams/${fm.firstTeam.id}.jpg"
                                 alt>
                        </div>
                        <b style="font-size: 35px">${fm.firstTeamName}</b>
                    </div>
                    <div class="col-lg-4 team" style="text-align: center">
                        <p><b style="font-size: 60px">VS</b></p>
                        <p></p><b style="font-size: 14px">
                        <#if fm.date?has_content>${fm.date}</#if> <#if fm.time?has_content>${fm.time}</#if></b></p>
                        <p><b style="font-size: 16px"><#if fm.stadium?has_content>${fm.stadium}</#if></b></p>
                    </div>
                    <div class="col-lg-4 team" style="text-align: center">
                        <div class="logoMatches">
                            <img style="float: left"
                                 src="/img/teams/${fm.secondTeam.id}.jpg" alt>
                        </div>
                        <b style="font-size: 35px">${fm.secondTeamName}</b>
                    </div>
                </div>
            </#list>
        </#if>

        <div class="col-lg-12" style="display: inline">
            <div class="row col-md-4 col-md-offset-4" style="text-align: center;">
                <#if 0 < pageNumber>
                    <a href="/future/${pageNumber - 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: left">←Назад>
                        </button>
                    </a>
                </#if>

                <#if pageNumber < maxPageNumber>
                    <a href="/future/${pageNumber + 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: right;"> Вперёд→
                        </button>
                    </a>
                </#if>
            </div>
        </div>


    </div>

</section>
</#macro>