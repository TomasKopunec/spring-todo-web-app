<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Todo</title>
    </head>

    <body>
        <h1>Todo Details</h1>

        <form method="post">
            Description: <input type="text" name="description" value="${todo.description}"/><br/>
            Target Date: <input type="date" name="targetDate" value="${todo.targetDate}"/><br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>