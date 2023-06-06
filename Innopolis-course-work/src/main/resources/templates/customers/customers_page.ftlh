<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<a href="/customers">Ко всем пользователям</a>
<#include "../header/navigation.ftlh">
<h1>Пользователи</h1>
<table>
    <tr>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <td>Действия</td>
    </tr>
    <#list customers as customer>
        <tr>
            <td>${customer.email}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>
                <a href="/customers/${customer.id}">Перейти</a>
                <a href="/customers/${customer.id}/delete">Удалить</a>
            </td>
        </tr>
    </#list>
</table>
<#--<form action="/customers" method="post">-->
<#--    <label>-->
<#--        Email-->
<#--        <input type="email" name="email" placeholder="Введите почту">-->
<#--    </label>-->
<#--    <br>-->
<#--    <label>-->
<#--        Имя-->
<#--        <input type="text" name="firstName" placeholder="Введите имя">-->
<#--    </label>-->
<#--    <br>-->
<#--    <label>-->
<#--        Фамилия-->
<#--        <input type="text" name="lastName" placeholder="Введите фамилию">-->
<#--    </label>-->
<#--    <br>-->
<#--    <label>-->
<#--        Возраст-->
<#--        <input type="text" name="age" placeholder="Введите возраст">-->
<#--    </label>-->
<#--    <br>-->
<#--    <input autofocus type="submit" value="Добавить"/>-->
<#--</form>-->
</body>
</html>