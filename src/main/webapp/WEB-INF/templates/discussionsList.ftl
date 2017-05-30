<#include "base.ftl">
<#macro title>Обсуждения</#macro>
<#macro content>
<section class="page">
    <div class="container" style="text-decoration: none; color: black; border-radius: 5px;">
        <div class="forum">
            <a href="/discussion/create" class="col-lg-12 btn btn-success" style="margin-bottom: 0px; color: #ebebeb">
                <h4>Создать новое
                    обсуждение</h4></a>

            <#if discussions?has_content>
                <#list discussions as d>
                    <a href="/discussion/${d.id}/0" class="col-lg-12 forum"
                       style="padding: 10px; margin-top: 5px; margin-bottom: 5px; vertical-align: middle">
                        <h3>${d.name}</h3>
                        <hr>
                        <p>${d.content}</p>
                        <p>Создано: ${d.created?string.short}</p>
                        <p>Автор: ${d.author.firstName} ${d.author.lastName}</p>
                    </a>
                </#list>
            </#if>
        </div>
        <div class="col-lg-12" style="display: inline; margin: 10px 0">
            <div class="row col-md-4 col-md-offset-4" style="text-align: center;">
                <#if 0 < pageNumber>
                    <a href="/discussions/${pageNumber - 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: left">←Назад>
                        </button>
                    </a>
                </#if>
                <#if pageNumber <= maxPageNumber>
                    <a href="/discussions/${pageNumber + 1}">
                        <button type="button" class="btn btn-primary" style="width: 150px; float: right;"> Вперёд→
                        </button>
                    </a>
                </#if>
            </div>
        </div>
    </div>
</section>
</#macro>