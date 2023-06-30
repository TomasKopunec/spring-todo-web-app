<html>
    <head>
        <title>Login</title>
    </head>

    <body>
        <h2>Login</h2>

        <form method="post">
            Name:     <input type="text" name="username" placeholder="Username">
            Password: <input type="password" name="password" placeholder="Password">
            <input type="submit" name="submit" value="login">
        </form>

        <pre>${errorMessage}</pre>
    </body>
</html>