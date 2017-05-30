<#include "base.ftl">
<#macro title>Главная</#macro>
<#macro content>
<section class="page">
    <div class="container">
        <div class="col-md-9">
            <div class="slider_container">
                <div class="sliderFrame" id="sliderFrame">
                    <div class="slider" id="slider">

                    <#--todo change photos (be careful with size)-->

                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/1.png"
                                         alt="Добро пожаловать!"></a>
                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/2.png"
                                         alt="Мы стараемся быть лучшими"></a>
                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/6.png"
                                         alt="Мы одни из лидеров в Казани"></a>
                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/3.png"
                                         alt="Ни дня без тренировок"></a>
                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/4.png"
                                         alt="Обладатели кубка Стэнли сради любителей"></a>
                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/5.png"
                                         alt="Лучшие в городе"></a>
                        <a href="#"><img src="http://localhost:8080/img/sliderFiles/7.png"
                                         alt="В нашей команде играют обычные люди, но сильные духом"></a>
                    </div>
                </div>
                <div class="div2">
                </div>
            </div>
        </div>
        <div class="col-md-3 tournament">
            <#if topTeams?has_content>
                <div class="mod_heading">Турнирная таблица</div>
                <table class="table table-bordered" style="background-color: white; color: black">
                    <thead style="padding: 0">
                    <tr>
                        <th>№</th>
                        <th>Команда</th>
                        <th>Игры</th>
                        <th>Победы</th>
                    </tr>
                    </thead>
                    <tbody style="padding: 0">
                        <#assign place=1>
                        <#list topTeams as t>
                        <tr>
                            <th>${place}</th>
                            <th>${t.name}</th>
                            <th>${t.games}</th>
                            <th>${t.points}</th>
                        </tr>
                            <#assign place++>
                        </#list>
                    </tbody>
                </table>
            </#if>
        </div>
    </div>
    <div class="container" style="margin-top: 10px">
        <div class="col-md-4" style="margin-top: 5px; margin-bottom: 5px">
            <div class="mod_heading">Прошедшие матчи</div>
            <table class="table" style="background-color: white; color: black;  margin:0">
                <tbody>
                    <#if playedMatches??>
                        <#list playedMatches as pm>
                        <tr>
                            <th>
                                <a href="/album?id=${pm.id}&page=1">
                                    <div class="teamTable">
                                        <ul>
                                            <li>
                                                <div class="logoMin">
                                                    <img src="/img/teams/${pm.firstTeam.id}.jpg"
                                                         alt>
                                                </div>
                                            </li>
                                            <li><b style="font-size: 20px">${pm.firstTeamName}</b></li>
                                        </ul>
                                    </div>
                                </a>
                            </th>
                            <th style="padding:0; font-size: 45px; text-align: center;
                             vertical-align: middle"><a href="/album?id=${pm.id}&page=1">${pm.firstTeamScore}:${pm.secondTeamScore}</a></th>
                            <th>
                                <a href="/album?id=${pm.id}&page=1">
                                    <div class="teamTable">
                                        <ul>
                                            <li>
                                                <div class="logoMin">
                                                    <img src="/img/teams/${pm.secondTeam.id}.jpg"
                                                         alt>
                                                </div>
                                            </li>
                                            <li><b style="font-size: 20px">${pm.secondTeamName}</b></li>
                                        </ul>
                                    </div>
                                </a>
                            </th>
                        </tr>
                        </#list>
                    </#if>
                </tbody>
            </table>
            <div class="green_button">
                <a href="/played/0">+</a>
            </div>
        </div>
        <div class="col-md-4" style="margin-top: 5px; margin-bottom: 5px">
            <#if futureMatches?has_content>
                <div class="mod_heading">Ближайшие матчи</div>
                <table class="table" style="background-color: white; color: black; margin:0">
                    <tbody>
                        <#list futureMatches as fm>
                        <tr>
                            <th>
                                <div class="teamTable">
                                    <ul>
                                        <li>
                                            <div class="logoMin">
                                                <img src="img/teams/${fm.firstTeam.id}.jpg" alt>
                                            </div>
                                        </li>
                                        <li><b style="font-size: 20px">${fm.firstTeamName}</b></li>
                                    </ul>
                                </div>
                            </th>
                            <th style="font-size: 45px; text-align: center; vertical-align: middle">-</th>
                            <th>
                                <div class="teamTable">
                                    <ul>
                                        <li>
                                            <div class="logoMin">
                                                <img src="img/teams/${fm.secondTeam.id}.jpg"
                                                     alt>
                                            </div>
                                        </li>
                                        <li><b style="font-size: 20px">${fm.secondTeamName}</b></li>
                                    </ul>
                                </div>
                            </th>
                        </tr>
                        </#list>
                    </tbody>
                </table>
                <div class="green_button">
                    <a href="/future/0">+</a>
                </div>
            </#if>
        </div>

        <#if topPlayers?has_content>
            <div class="col-md-4" style="margin-top: 5px; margin-bottom: 5px">
                <div class="mod_heading">Игроки</div>
                <table class="table table-bordered" style="background-color: white; color: black;  margin:0">
                    <thead style="padding: 0">
                    <tr>
                        <th>Игрок</th>
                        <th>Ш</th>
                        <th>А</th>
                        <th>О</th>
                    </tr>
                    </thead>
                    <tbody style="padding: 0">
                        <#list topPlayers as tp>
                        <tr>
                            <th><a href="/player?id=${tp.id}">${tp.firstName} ${tp.lastName}</a></th>
                            <th>${tp.goals}</th>
                            <th>${tp.assists}</th>
                            <th>${tp.points}</th>
                        </tr>
                        </#list>

                    </tbody>
                </table>
                <div class="green_button">
                    <a href="/players">+</a>
                </div>
            </div>
        </#if>
    </div>
</section>
</#macro>