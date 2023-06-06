<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Сеансы</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<#if role=='ADMIN'>
    <a href="/customers">Ко всем пользователям</a>
</#if>
<#include "../header/navigation.ftlh">
<h1>Сеансы</h1>
<table>
    <tr>
        <th>Зал</th>
        <th>Начало</th>
        <#if role=='ADMIN'>
            <th>Действия</th>
        </#if>
        <th>Фильм</th>
    </tr>
    <#list sessions as session>
        <tr>
            <td>${session.hall}</td>
            <td>${session.startTime}</td>
            <#if role=='ADMIN'>
            <td>
                <a href="/sessions/${session.id}">Перейти</a>
                <a href="/sessions/${session.id}/delete">Удалить</a>
            </td>
            </#if>
            <#list session.movies as movie>
                <td>${movie.name}</td>
            </#list>
        </tr>
    </#list>
</table>
<#if role=='ADMIN'>
<form action="/sessions" method="post">
    <h4>Добавить новый сеанс</h4>
    <label>
        Зал
        <input type="title" name="hall" placeholder="Введите зал">
    </label>
    <br>
    <label>
        Начало сеанса
        <input type="time" name="startTime" placeholder="Введите время начала сеанса">
    </label>
    <br>
    <label>
        Стоимость билета
        <input type="number" name="price" placeholder="Введите стоимость">
    </label>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</#if>
</body>
</html>