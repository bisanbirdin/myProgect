<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Фильм</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<#if role=='ADMIN'>
    <a href="/customers">Ко всем пользователям</a>
</#if>
<#include "../header/navigation.ftlh">
<h1>${movie.name} - ${movie.description}</h1>
<form action="/movies/${movie.id}/update" method="post">
    <h4>Изменить данные о фильме</h4>
    <label>
        Название
        <input type="text" name="name" value="${movie.name}">
    </label>
    <br>
    <label>
        Описание
        <input type="text" name="description" value="${movie.description}">
    </label>
    <br>
    <label>
        Режиссер
        <input type="text" name="director" value="${movie.director}">
    </label>
    <br>
    <label>
        Главные роли
        <input type="text" name="mainRole" value="${movie.mainRole}">
    </label>
    <br>
    <label>
        Продолжительность
        <input type="number" name="durationMin" value="${movie.durationMin}">
    </label>
    <br>
    <label>
        Возрастное ограничение
        <input type="number" name="ageLimit" value="${movie.ageLimit}">
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>