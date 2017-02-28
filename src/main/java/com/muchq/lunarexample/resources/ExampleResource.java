package com.muchq.lunarexample.resources;

import com.google.inject.Inject;
import com.muchq.lunarexample.data.ExampleRecord;
import com.muchq.lunarexample.data.ModifiableExampleRecord;
import com.muchq.lunarexample.managers.ExampleRecordManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {
  private final ExampleRecordManager manager;

  @Inject
  public ExampleResource(ExampleRecordManager manager) {
    this.manager = manager;
  }

  @POST
  public ExampleRecord sayHello(ModifiableExampleRecord record) {
    return manager.insert(record);
  }

  @GET
  @Path("{id}")
  public Optional<ExampleRecord> sayHello(@PathParam("id") int id) {
    return manager.getById(id);
  }
}
