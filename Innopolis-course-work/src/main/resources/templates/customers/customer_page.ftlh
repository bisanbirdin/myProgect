<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователь</title>
</head>
<body>
<a href="/customers">Ко всем пользователям</a>
<#include "../header/navigation.ftlh">
<h1>${customer.firstName} ${customer.lastName} <#if role='ADMIN'>${customer.role}</#if></h1>
<h4>Изменить данные пользователя</h4>
<form action="/customers/${customer.id}/update" method="post">
    <label>
        Email
        <input type="email" name="email" value=${customer.email}>
    </label>
    <br>
    <label>
        Имя
        <input type="text" name="firstName" value=${customer.firstName}>
    </label>
    <br>
    <label>
        Фамилия
        <input type="text" name="lastName" value=${customer.lastName}>
    </label>
    <br>
    <label>
        Возраст
        <input type="text" name="age" value=${customer.age}>
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>