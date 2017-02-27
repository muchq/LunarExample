package com.andyaylward.lunarexample.resources;

import com.andyaylward.lunarexample.data.ExampleDao;
import com.andyaylward.lunarexample.data.ExampleRecord;
import com.google.inject.Inject;
import com.muchq.lunarcat.util.PublicPreconditions;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {
  private final ExampleDao dao;

  @Inject
  public ExampleResource(ExampleDao dao) {
    this.dao = dao;
  }

  @POST
  public ExampleRecord sayHello(@QueryParam("name") String name) {
    PublicPreconditions.checkNotNull(name, "name must not be null");
    int id = dao.insert(name);
    return ExampleRecord.builder().setId(id).setName(name).build();
  }

  @GET
  @Path("{id}")
  public Optional<ExampleRecord> sayHello(@PathParam("id") int id) {
    return dao.getRecordById(id);
  }
}
