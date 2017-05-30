<#include "base.ftl">
<#macro title>Регистрация</#macro>
<#macro content>
<section class="page">
    <div class="container" style="background-color: white; border-radius: 5px;">
        <h2 style="text-align: center">Регистрация</h2>
        <hr>
        <div class="col-lg-12">
            <form class="form-horizontal" action="register" method="POST" <#--enctype="multipart/form-data" -->
                  style="margin: 20px;">
                <fieldset>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="username">Имя</label>
                        <div class="col-sm-10">
                            <input type="text" name="firstname" id="name" class="form-control" maxlength="29"
                                   pattern="[А-Я]*[a-я]*[A-Z]*[a-z]*"
                                   title="Только буквы английского или русского алфавита"
                                   <#if firstname??>value='${firstname}'</#if>>
                            <p class="help-block">Введите Ваше имя</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="username">Фамилия</label>
                        <div class="col-sm-10">
                            <input type="text" name="lastname" id="surname" class="form-control" maxlength="29"
                                   pattern="[А-Я]*[a-я]*[A-Z]*[a-z]*"
                                   title="Только буквы английского или русского алфавита"
                                   <#if lastname??>value='${lastname}'</#if>>
                            <p class="help-block">Введите Вашу фамилию</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="username">Пол</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="M" id=male/>М
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="F" id=female/>Ж
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="username">Login</label>
                        <div class="col-sm-10">
                            <input type="text" name="login" id="login" class="form-control" maxlength="19"
                                   oninput="check()"
                                   pattern="([A-Z]*[a-z]*[-_]*[0-9]*)*" title="Только буквы английского алфавита, - и _"
                                   <#if login??>value='${login}'</#if>>
                            <p id="login-help" class="help-block">Введите никнейм, используя любые буквы и цифры, без
                                пробелов</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="inputEmail3" maxlength="49"
                                   <#if email??>value='${email}'</#if>>
                            <p class="help-block">Введите ваш e-mail</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Пароль</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" class="form-control" id="inputPassword3"
                                   maxlength="29">
                            <p class="help-block">Придумайте надежный пароль</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="password_confirm">Пароль (Подтверждение)</label>
                        <div class="col-sm-10">
                            <input type="password" name="password_confirmation" id="password_confirm"
                                   class="form-control" maxlength="29">
                            <p class="help-block">Подтвердите пароль</p>
                        </div>
                    </div>

                    <#if error?has_content>
                        <h3 style="color: #cb1800; text-align: center">${error}</h3>
                    </#if>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-success" data-toggle="modal"
                                    data-target=".bs-example-modal-sm">Зарегистрироваться
                            </button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</section>

<script>
    var check = function () {
        var login = $('#login').val();
        $.ajax({
            'url': '/check',
            'data': {
                'login': login,
            },
            'method': 'get',
            'success': function (obj) {
                if (!obj) {
                    $("#login").css("border-color", "green");
                    $("#login-help").html("Login свободен");
                    $("#login-help").css("color", "green")
                }
                else {
                    $("#login").css("border-color", "red");
                    $("#login-help").html("Login занят");
                    $("#login-help").css("color", "red")
                }
            }
        });
    };
</script>

</#macro>