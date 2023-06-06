<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Фильмы</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<#if role=='ADMIN'>
    <a href="/customers">Ко всем пользователям</a>
</#if>
<#include "../header/navigation.ftlh">
<h1>Фильмы</h1>
<table>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <#if role=='USER'>
            <th>Сеансы</th>
        </#if>
        <#if role=='ADMIN'>
            <th>Действия</th>
        </#if>
    </tr>
    <#list movies as movie>
        <tr>
            <td>${movie.name}</td>
            <td>${movie.description}</td>
            <#if role=='USER'>
                <#list movie.sessions as session>
                    <td>
                        <a href="/basket/${movie.id}/${session.id}">${session.startTime}</a>
                    </td>
                </#list>
            </#if>
            <#if role=='ADMIN'>
            <td>
                <a href="/movies/${movie.id}">Перейти</a>
                <a href="/movies/${movie.id}/delete">Удалить</a>
            </td>
            </#if>
        </tr>
    </#list>
</table>
<#if role=='ADMIN'>
<form action="/movies" method="post">
    <h4>Добавить новый фильм</h4>
    <label>
        Название
        <input type="text" name="name">
    </label>
    <br>
    <label>
        Описание
        <input type="text" name="description">
    </label>
    <br>
    <label>
        Режиссер
        <input type="text" name="director">
    </label>
    <br>
    <label>
        Главные роли
        <input type="text" name="mainRole">
    </label>
    <br>
    <label>
        Продолжительность фильма
        <input type="number" name="durationMin">
    </label>
    <br>
    <label>
        Возрастное ограничение
        <input type="number" name="ageLimit">
    </label>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</#if>
</body>
</html>