<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
    <head>
        <title>Todo</title>
    </head>

    <body>
        <h1>Edit Todo Details</h1>

        <form:form method="post" modelAttribute="todo">
            Description: <form:input path="description" type="text" name="description" required="true"/>
            <%--            Target Date: <form:input path="targetData"  type="date" name="description" required="true"/>--%>

            <form:input path="id" type="hidden" />
            <form:input path="done" type="hidden" />

            <input type="submit" value="Save"/>
        </form:form>

<%--        <pre>${error}</pre>--%>
    </body>
</html>