<#include "base.ftl">
<#macro title>Фотографии</#macro>
<#macro content>
<section class="page">
    <div class="container" style="background-color: #e4cb00">
        <#if photos?has_content>
            <div class="row" style="margin-top: 20px">
                <#list photos as p>
                    <div class="col-lg-4">
                        <div class="photo">
                            <img class="photo" src="/img/m${p.match.id}/${p.name}">
                        </div>
                    </div>
                </#list>
            </div>

            <div class="col-lg-12" style="display: inline">
                <div class="row col-md-4 col-md-offset-4" style="text-align: center;">
                    <#if 0 < pageNumber>
                        <a href="/album/${matchId}/${pageNumber - 1}">
                            <button type="button" class="btn btn-primary" style="width: 150px; float: left">←Назад
                            </button></a>
                    </#if>
                    <#if pageNumber < maxPageNumber>
                        <a href="/album/${matchId}/${pageNumber + 1}">
                            <button type="button" class="btn btn-primary" style="width: 150px; float: right">Вперёд→
                            </button>
                        </a>
                    </#if>
                </div>
            </div>
        </#if>
    </div>
</section>





</#macro>