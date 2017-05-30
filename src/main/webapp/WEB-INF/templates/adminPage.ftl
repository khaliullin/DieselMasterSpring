<#include "adminBase.ftl">
<#macro title>Admin</#macro>
<#macro content>
<div class="content">
    <div class="col-md-8 col-md-offset-2 tables">
        <h4>Добавление матча</h4>
        <div class="row" style="padding: 20px;">
            <form action="/add_match" method="post">
                <select name="first_team_id" id="">
                    <#if teams??>
                        <#list teams as t>
                            <option value="${t.id}">${t.name}</option>
                        </#list>
                    </#if>
                </select>
                <select name="second_team_id" id="">
                    <#if teams??>
                        <#list teams as t>
                            <option value="${t.id}">${t.name}</option>
                        </#list>
                    </#if>
                </select>

                <label for="date">Дата</label>
                <input type="datetime-local" name="date" id="date" required>

                <br>
                <br>
                <label for="stadium">Стадион</label>
                <input type="text" name="stadium" id="stadium" required>
                <br>
                <hr>
                <label for="played">Сыгран</label>
                <input type="checkbox" name="played" id="played">
                <input type="hidden" value="on" name="_played"/>

                <label for="first_team_score">Счет: </label>
                <input type="number" name="first_team_score" id="first_team_score" value="0">
                :
                <input type="number" name="second_team_score" id="second_team_score" value="0">
                <hr>


                <textarea name="about" id="about" cols="30" rows="10" placeholder="Информация о голах"
                          style="width: 100%;"></textarea>

                <br>
                <input type="submit" value="Добавить">
            </form>
        </div>
    </div>
</div>
</#macro>