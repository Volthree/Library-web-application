<!--  -->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" xmlns:th="http://thymeleaf.org">
    <title>Human page</title>
</head>
<body>
<h2>Welcome to the library application!</h2>

<form th:method="GET" th:action="@{/books}">
    <p>
        <input type="submit" value="Book list"/>
    </p>
</form>
<form th:method="GET" th:action="@{/human}">
    <p>
        <input type="submit" value="Reader list"/>
    </p>
</form>


<p>
    <a th:href="@{/books/newbook}">New book</a>
</p>
<p>
    <a th:href="@{/books}">Book list</a>
</p>
</body>
</html>
