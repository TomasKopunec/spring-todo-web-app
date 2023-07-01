<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Todos</title>
    </head>

    <body>
        <h1>Your Todos:</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
<%--                    <th>Username</th>--%>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
<%--                        <td>${todo.userName}</td>--%>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="edit-todo?id=${todo.id}">  <button>Edit</button></a></td>
                        <td><a href="delete-todo?id=${todo.id}"><button>Delete</button></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="add-todo">
            <button>Add a new Todo</button>
        </a>

    </body>
</html>