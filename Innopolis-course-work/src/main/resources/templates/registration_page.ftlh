<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="/registration" method="post">
    <label>
        Email
        <input type="email" name="email">
    </label>
    <br>
    <label>
        Пароль
        <input type="password" name="password">
    </label>
    <br>
    <label>
        Имя
        <input type="text" name="firstName">
    </label>
    <br>
    <label>
        Фамилия
        <input type="text" name="lastName">
    </label>
    <br>
    <label>
        Возраст
        <input type="number" name="age">
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
<a href="/signIn">Авторизоваться</a>
</body>
</html>