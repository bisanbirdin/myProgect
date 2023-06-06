<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Корзина</title>
</head>
<body>
<h3>Ваш заказ</h3>
<table>
    <tr>
        <th>Фильм</th>
        <th>Зал</th>
        <th>Начало</th>
        <th>Цена</th>
        <th>Возраст</th>
    </tr>
    <tr>
        <form action="/movie/${movie.id}">
            <td>${movie.name}</td>
            <td>${session.hall}</td>
            <td>${session.startTime}</td>
            <td>${session.price}</td>
            <td>от ${movie.ageLimit}+</td>
        </form>
    </tr>
</table>
<#--<h4>Заказанная еда</h4>-->
<#--<table>-->
<#--    <tr>-->
<#--        <th>Название</th>-->
<#--        <th>Цена</th>-->
<#--    </tr>-->
<#--    <#list inCustomerProducts as product>-->
<#--        <tr>-->
<#--            <td>${product.name}</td>-->
<#--            <td>${product.price}</td>-->
<#--        </tr>-->
<#--        <td></td>-->
<#--        <td></td>-->
<#--    </#list>-->
<#--</table>-->
<#--<h4>Добавить к заказу еду</h4>-->
<#--<form action="/basket/${customer.id}" method="post">-->
<#--    <label>Продукты-->
<#--        <select name="product-id">-->
<#--            <#list products as product>-->
<#--                <option value="${product.id}">${product.name}</option>-->
<#--            </#list>-->
<#--        </select>-->
<#--    </label>-->
<#--    <input type="submit" value="Добавить">-->
<#--</form>-->
</body>
</html>