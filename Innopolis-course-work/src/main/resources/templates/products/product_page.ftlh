<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Продукт</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<#if role=='ADMIN'>
    <a href="/customers">Ко всем пользователям</a>
</#if>
<#include "../header/navigation.ftlh">
<h2>${product.name} - ${product.price}</h2>
<form action="/products/${product.id}/update" method="post">
    <h2>Изменение продукта</h2>
    <label>
        Новое название
        <input type="text" name="name" value="${product.name}">
    </label>
    <br>
    <label>
        Новая цена
        <input type="text" name="price" value="${product.price}">
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>