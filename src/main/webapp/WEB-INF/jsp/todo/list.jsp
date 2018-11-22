<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Todo List</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
</head>
<body>
<input type="text" id="todo-text"/>
<input type="button" id="todo-btn" value="添加"/>
<table id="todo-list">
    <thead>
    <tr>
        <th colspan="2">
            待办事项
        </th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${todoList}" var="todo">
        <tr>
            <td><input type="checkbox" class="todoSelector" data-id="${todo.id}"/></td>
            <td>${fn:escapeXml(todo.name)}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<script>
    $(function() {
        var $todoText = $("#todo-text"),
            $todoList = $("#todo-list");

        $todoList.on('click', 'input.todoSelector', function(e) {
            e.preventDefault();
            var $self = $(this),
                id = $self.data("id");

            $.post('/todo/del', {id: id}, function(data) {
                if (data.success) {
                    $self.parent().parent().remove();
                } else {
                    alert('删除失败');
                }
            });
        });

        $('#todo-btn').click(function(e) {
            e.preventDefault();
            var name = $todoText.val();

            $.post('/todo/new', {name: name}, function(data) {
                if (data.success) {
                    var newTodo = '<tr>' +
                        '<td><input type="checkbox" class="todoSelector" data-id="'+data.todo.id+'"></td>' +
                        '<td>'+data.todo.name+'</td>' +
                        '</tr>';
                    $todoList.find('tbody').append(newTodo);
                } else {
                    alert('添加失败');
                }
            });
        })
    });
</script>
</body>
</html>
