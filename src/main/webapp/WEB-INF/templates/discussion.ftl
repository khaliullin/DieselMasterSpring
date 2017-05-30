<#include "base.ftl">
<#macro title>Обсуждение</#macro>
<#macro content>
<section class="page">
    <div class="container" style="background-color: white; padding-bottom: 15px; border-radius: 5px;">
        <#if discussion?has_content>
            <h1>${discussion.name}</h1>
            <p class="lead">
                by <span style="font-weight: bold;">${discussion.author.firstName} ${discussion.author.lastName}</span>
            </p>
            <hr>
            <p><i class="fa fa-clock-o" aria-hidden="true"></i> ${discussion.created?string.short}</p>
            <hr>
            <p>${discussion.content}</p>
        </#if>
        <hr>

        <div class="well">
            <h4>Оставьте комментарий:</h4>
            <form role="form" method="post" action="/discussion/${discussionId}/${pageNumber}">
                <div class="form-group">
                    <textarea name="content" class="form-control" rows="3" maxlength="2000"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Отправить</button>
            </form>
        </div>
        <hr>

        <#--<#if m.authorPhoto == true>-->
            <#--<img src="http://localhost:8080/files/${m.login}.jpg" alt="?">-->
        <#--<#else>-->
            <#--<img src="http://localhost:8080/files/no-avatar.jpg" alt="?">-->
        <#--</#if>-->

        <#if messages?has_content>
            <#list messages as m>
                <div class="media">
                    <div class="media-body">
                        <h4 class="media-heading">${m.user.firstName} ${m.user.lastName}
                            <small>${m.created?string.short}</small>
                        </h4>
                    ${m.content}
                    </div>
                </div>
                <hr>
            </#list>
        </#if>
    </div>
</section>

    <#if 1 < pageNumber>
    <a href="/discussion/${discussionId}/${pageNumber - 1}">Назад</a>
    </#if>

    <#if pageNumber <= maxPageNumber>
    <a href="/discussion/${discussionId}/${pageNumber + 1}">Вперед</a>
    </#if>



<#--<script type="application/javascript">-->
<#--var f = function () {-->
<#--$.ajax({-->
<#--'url': '/discussion?id=${discussionId}&page=${pageNumber}',-->
<#--'data': {-->
<#--'q': $("#q").val()-->
<#--},-->
<#--'type': 'post',-->
<#--'success': function (obj) {-->
<#--$("#res").html(obj.result.join(", "));-->
<#--}-->
<#--})-->
<#--}-->
<#--</script>-->

<#--todo add AJAX on autorefresh if possible-->

</#macro>