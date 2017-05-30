<#include "base.ftl">
<#macro title>Вход</#macro>
<#macro content>

<section class="page">
    <div class="container col-md-4 col-md-offset-4"
         style="background-color: white; padding: 10px; border-radius: 5px; margin-top: 50px">
        <form action="/login/process" method="post" class="form-horizontal" style="padding-top: 30px">
            <fieldset>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Login</label>
                    <div class="col-lg-10">
                        <input type="text" name="login" class="form-control" id="inputEmail" placeholder="login"
                               style="width: 95%"
                            <#if login?has_content>
                               value="${login}"
                            </#if> maxlength="19">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Пароль</label>
                    <div class="col-lg-10">
                        <input type="password" name="password" class="form-control" id="inputPassword"
                               placeholder="Password"
                               style="width: 95%" maxlength="39">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="remember"> Запомнить меня
                            </label>
                        </div>
                        <#if err?has_content>
                            <h4 style="color: #bd1700;">${err}</h4>
                        </#if>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="submit" class="btn btn-default">Войти</button>
                        <button onclick="location.href = '/register'" type="button" class="btn btn-primary">Регистрация
                        </button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</section>
</#macro>