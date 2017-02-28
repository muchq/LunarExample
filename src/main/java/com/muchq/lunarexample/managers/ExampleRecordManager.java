package com.muchq.lunarexample.managers;

import com.google.inject.Inject;
import com.muchq.lunarcat.util.PublicPreconditions;
import com.muchq.lunarexample.data.ExampleDao;
import com.muchq.lunarexample.data.ExampleRecord;
import com.muchq.lunarexample.data.ModifiableExampleRecord;

import java.util.Optional;

public class ExampleRecordManager {
  private final ExampleDao dao;

  @Inject
  public ExampleRecordManager(ExampleDao dao) {
    this.dao = dao;
  }

  public ExampleRecord insert(ModifiableExampleRecord input) {
    PublicPreconditions.checkNotNull(input.getName(), "name must not be null");
    int id = dao.insert(input.getName());
    return ExampleRecord.copyOf(input.setId(id));
  }

  public Optional<ExampleRecord> getById(int id) {
    return dao.getRecordById(id);
  }
}
