<#include "base.ftl">
<#macro title>Альбомы</#macro>
<#macro content>
<section class="page">
    <div class="container" style="background-color: #e4cb00">
        <#if  matches?has_content>
            <div class="row" style="margin-top: 10px; background-color: #e4cb00">
                <#list matches as a>
                    <div class="col-lg-4">
                        <div class="photo">
                            <a href="/album/${a.id}/0">
                                <img class="photo" src="/img/m${a.id}/1.jpg"
                                     alt="no cover">
                                <p>${a.firstTeamName} vs ${a.secondTeamName}</p>
                                <p>${a.date?date}</p>
                            </a>
                        </div>
                    </div>
                </#list>
            </div>
        </#if>
        <br>
        <br>
        <br>
        <br>

        <div class="col-lg-12" style="display: inline">
            <div class="row col-md-4 col-md-offset-4" style="text-align: center;">
                <#if 0 < pageNumber>
                    <a href="/albums/${pageNumber - 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: left">
                                ←Назад
                        </button>
                    </a>
                </#if>

                <#if pageNumber < maxPageNumber>
                    <a href="/albums/${pageNumber + 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: right">
                            Вперёд→
                        </button>
                    </a>
                </#if>
            </div>
        </div>
</section>



</#macro>