package com.jihoon.rest;
 
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
 
@Path("/todos")
public class HelloWorldService {
 
	@GET
	public Response getTodos() {
 
		String output = "getTodos";
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/{todo_id}")
	public Response getTodo(@PathParam("todo_id") String todoId) {

		String output = "getTodo" + todoId;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/{todo_id}/tasks/{task_id}")
	public Response getTask(@PathParam("todo_id") String todoId, @PathParam("task_id") String taskId) {

		String output = "getTask"+ todoId + taskId;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/{todo_id}/tasks/done")
	public Response getTaskDone(@PathParam("todo_id") String todoId) {

		String output = "getTaskDone"+ todoId;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/{todo_id}/tasks/not-done")
	public Response getTaskNotDone(@PathParam("todo_id") String todoId) {

		String output = "getTaskNotDone";
		return Response.status(200).entity(output).build();
	}

	@POST
	public Response createTodos() {

		String output = "createTodos";
		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/{todo_id}/tasks")
	public Response createTasks(@PathParam("todo_id") String todoId) {

		String output = "createTasks";
		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/{todo_id}/tasks/{task_id}")
	public Response createTask(@PathParam("todo_id") String todoId) {

		String output = "createTask";
		return Response.status(200).entity(output).build();
	}


	@DELETE
	@Path("/{todo_id}")
	public Response deleteTodo(@PathParam("todo_id") String todoId) {

		String output = "deleteTodo";
		return Response.status(200).entity(output).build();
	}

	@DELETE
	@Path("/{todo_id}/tasks/{task_id}")
	public Response deleteTask(@PathParam("todo_id") String todoId, @PathParam("task_id") String taskId) {

		String output = "deleteTask";
		return Response.status(200).entity(output).build();
	}

}