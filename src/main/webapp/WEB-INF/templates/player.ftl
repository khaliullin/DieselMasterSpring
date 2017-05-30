<#include "base.ftl">
<#macro title>${p.firstName} ${p.lastName}</#macro>
<#macro content>

<section class="page">
    <div class="container" style="background-color: white; padding: 10px; border-radius: 5px;">
        <div class="col-lg-4">
            <img src="/img/players/${p.id}.jpg" width="240px" height="240px">
        </div>
        <div class="col-lg-8" style="font-size: 20px; font-family: ArvoRegular">
            <h2 style="margin-bottom: 40px">#${p.number}  ${p.firstName} ${p.lastName}</h2>
            <p><b>Дата рождения:</b> ${p.birthDate}</p>
            <p><b>Позиция:</b>
            <#if p.position == "G">Вратарь</p>
            <#elseif p.position == "D">Защитник</p>
            <#elseif p.position == "W">Нападающий</p></#if>
            <p><b>Хват:</b>
                <#if p.grip == "R">Правый</p>
                <#elseif p.grip == "L">Левый</#if></p>
            <p><b>Количество игр:</b> ${p.games}</p>
            <p><b>Голы:</b> ${p.goals}</p>
            <p><b>Пасы:</b> ${p.assists}</p>
            <p style="margin-bottom: 242px"><b>Очки:</b> ${p.points}</p>
        </div>
    </div>
</section>
</#macro>