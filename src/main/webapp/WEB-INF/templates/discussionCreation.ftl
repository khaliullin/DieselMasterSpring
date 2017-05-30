<#include "base.ftl">
<#macro title>Новое обсуждение</#macro>
<#macro content>

<section class="page">
    <div class="container" style="background-color: white; padding-bottom: 15px; border-radius: 5px;">
        <form action="/discussion/create" method="post">
            <h2 style="text-align: center">Создание нового обсуждения</h2>
            <hr>
            <div class="form-group" style="margin-top:25px; margin-bottom:10px;">
                <input type="text" name="name" class="form-control" placeholder="Название темы..." maxlength="100"
                <#if name??> value='${name}'</#if>>
            </div>
            <div class="form-group" style="margin-top:10px; margin-bottom:10px;">
                <textarea class="form-control" name="content" rows="5" placeholder="Введите текст..." maxlength="2000"><#if content?has_content>${content}</#if></textarea>
            </div>
            <input type="submit" value="Создать" style="float: right" class="btn btn-success">

            <#if err?has_content>
            <h4 style="color: #bd1700">${err}</h4>
            </#if>
        </form>
    </div>
</section>

</#macro>