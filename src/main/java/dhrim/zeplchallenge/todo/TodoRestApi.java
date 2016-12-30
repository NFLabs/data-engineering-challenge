package dhrim.zeplchallenge.todo;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("/")
@Slf4j
public class TodoRestApi {

    @Inject
    private TodoService todoService;

    @GET
    @Path("/todos")
    @Produces("application/json")
    public Response getTodos() throws IOException {
        List<Todo> todoList = todoService.getTodoList();
        return new ResponseBuilder(Response.Status.OK, todoList).build();
    }

    @GET
    @Path("/todos/{todoId}")
    @Produces("application/json")
    public Response getTodoTasks(@PathParam("todoId") String todoId) throws IOException {
        List<Task> taskList = todoService.getTaskList(todoId);
        return new ResponseBuilder(Response.Status.OK, taskList).build();
    }

    @GET
    @Path("/todos/{todoId}/tasks/{taskId}")
    @Produces("application/json")
    public Response getTodoTask(@PathParam("todoId") String todoId, @PathParam("taskId") String taskId) throws IOException {
        Task task = todoService.getTodoTask(todoId, taskId);
        return new ResponseBuilder(Response.Status.OK, task).build();
    }

    @GET
    @Path("/todos/{todoId}/tasks/done}")
    @Produces("application/json")
    public Response getTodoTasksOfStatusDone(@PathParam("todoId") String todoId) throws IOException {
        List<Task> taskList = todoService.getTodoTaskList(todoId, Task.Status.DONE);
        return new ResponseBuilder(Response.Status.OK, taskList).build();
    }

    @GET
    @Path("/todos/{todoId}/tasks/not-done}")
    @Produces("application/json")
    public Response getTodoTasksOfStatusNotDone(@PathParam("todoId") String todoId) throws IOException {
        List<Task> taskList = todoService.getTodoTaskList(todoId, Task.Status.NOT_DONE);
        return new ResponseBuilder(Response.Status.OK, taskList).build();
    }

    @POST
    @Path("/todos")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTodo(Todo todo) throws IOException {
        Todo newTodo = todoService.createTodo(todo);
        return new ResponseBuilder(Response.Status.OK, newTodo).build();
    }

    @POST
    @Path("/todos/{todoId}/tasks")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTask(@PathParam("todoId") String todoId, Task task) throws IOException {
        Task newTask = todoService.createTask(todoId, task);
        return new ResponseBuilder(Response.Status.OK, newTask).build();
    }

    @PUT
    @Path("/todos/{todoId}")
    @Produces("application/json")
    public Response deleteTodo(@PathParam("todoId") String todoId) throws IOException {
        todoService.deleteTodo(todoId);
        return new ResponseBuilder(Response.Status.OK).build();
    }

    @DELETE
    @Path("/todos/{todoId}/tasks/{taskId}")
    @Produces("application/json")
    public Response deleteTodoTask(@PathParam("todoId") String todoId, @PathParam("taskId") String taskId) throws IOException {
        todoService.deleteTask(todoId, taskId);
        return new ResponseBuilder(Response.Status.OK).build();
    }

    // TODO : remove
    @GET
    @Path("/hello")
    public String hello() {
        return "hello";
    }


}
