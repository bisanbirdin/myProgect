<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>
</head>
<body>
<form action="/signInNew/${customer.id}">
    <label>Ваш email
        <input type="email" value="${customer.email}" name="email">
    </label>
    <label>Ваш пароль
        <input type="password" placeholder="Введите пароль" name="password">
    </label>
    <label>
        <input type="checkbox" name="rememberMe">Запомни меня
    </label>
    <input type="submit">
</form>
</body>
</html>