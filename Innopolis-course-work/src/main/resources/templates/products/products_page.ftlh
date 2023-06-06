<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Продукты</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<#if role=='ADMIN'>
    <a href="/customers">Ко всем пользователям</a>
</#if>
<#include "../header/navigation.ftlh">
<h1>Продукты</h1>
<table>
    <tr>
        <th>Название</th>
        <th>Цена</th>
        <#if role=='ADMIN'>
            <th>Действия</th>
        </#if>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <#if role=='ADMIN'>
            <td>
                <a href="/products/${product.id}">Перейти</a>
                <a href="/products/${product.id}/delete">Удалить</a>
            </td>
            </#if>
        </tr>
    </#list>
</table>
<#if role=='ADMIN'>
<form action="/products" method="post">
    <h4>Добавить новый продукт</h4>
    <label>
        Название
        <input type="title" name="name" placeholder="Введите название">
    </label>
    <br>
    <label>
        Цена
        <input type="number" name="price" placeholder="Введите стоимость">
    </label>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</#if>
</body>
</html>