package ru.fa.software.engineering.resources.internal;

import ru.fa.software.engineering.dbms.orm.internal.Task;
import ru.fa.software.engineering.dbms.services.AbstractSoftDeletableService;
import ru.fa.software.engineering.dbms.services.internal.TaskService;
import ru.fa.software.engineering.dto.internal.TaskDto;
import ru.fa.software.engineering.resources.AbstractResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/tasks")
public class TaskResource extends AbstractResource<Task, TaskDto, Long> {

    @Inject
    TaskService taskService;

    @Override
    @GET
    @RolesAllowed("employee")
    public Response getAll(Integer skip, Integer limit, String search, String... fields) {
        return super.getAll(skip, limit, search, "name", "description");
    }

    @Override
    @GET
    @Path("/{task_id}")
    @RolesAllowed("employee")
    public Response getById(@PathParam("task_id") Long id) {
        return super.getById(id);
    }

    @Override
    public AbstractSoftDeletableService<Task, TaskDto, Long> getService() {
        return taskService;
    }

    @Override
    @POST
    @RolesAllowed("manager")
    public Response create(TaskDto dto) {
        return super.create(dto);
    }

    @PUT
    @Path("/{task_id}")
    @RolesAllowed("manager")
    public Response update(@PathParam("task_id") long taskId,TaskDto dto) {
        dto.setId(taskId);
        return super.update(dto);
    }

    @DELETE
    @Override
    @RolesAllowed("manager")
    @Path("/{task_id}")
    public Response delete(@PathParam("task_id") Long id) {
        return super.delete(id);
    }
}
