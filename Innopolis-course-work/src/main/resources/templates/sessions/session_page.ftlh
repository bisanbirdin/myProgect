<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Сессия</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<#if role=='ADMIN'>
    <a href="/customers">Ко всем пользователям</a>
</#if>
<#include "../header/navigation.ftlh">
<h1>Зал №${session.hall} - начало в ${session.startTime}</h1>
<h4>Фильмы в сеансе</h4>
<table>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Продолжительность</th>
    </tr>
    <#list inSessionMovies as movie>
        <tr>
            <td>${movie.name}</td>
            <td>${movie.description}</td>
            <td>  ${movie.durationMin} минут</td>
        </tr>
        <td></td>
        <td></td>
    </#list>
</table>
<form action="/sessions/${session.id}/movies" method="post">
    <label>Фильмы
        <select name="movie-id">
            <#list notInSessionMovies as movie>
                <option value="${movie.id}">${movie.name}</option>
            </#list>
        </select>
    </label>
    <input type="submit" value="Добавить">
</form>
<br>
<h4>Пользователи в сеансе</h4>
<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>О пользователе</th>
    </tr>
    <#list inSessionCustomers as customer>
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td><a href="/customers/${customer.id}">Перейти</a></td>
        </tr>
        <td></td>
        <td></td>
    </#list>
</table>
<#--<form action="/sessions/${session.id}/customers" method="post">-->
<#--    <label>Пользователи-->
<#--        <select name="customer-id">-->
<#--            <#list notInSessionCustomers as customer>-->
<#--                <option value="${customer.id}">${customer.firstName}</option>-->
<#--            </#list>-->
<#--        </select>-->
<#--    </label>-->
<#--    <input type="submit" value="Добавить">-->
<#--</form>-->
<br>
<form action="/sessions/${session.id}/update" method="post">
    <h4>Изменение сеанса</h4>
    <label>
        Зал
        <input type="text" name="hall" value="${session.hall}">
    </label>
    <br>
    <label>
        Время сеанса
        <input type="time" name="startTime" value="${session.startTime}">
    </label>
    <br>
    <label>
        Стоимость
        <input type="number" name="price" value="${session.price}">
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>