package com.muchq.lunarexample.data;

import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.muchq.mentat.MentatModule;
import com.muchq.mentat.MySqlConfiguration;

public class ExampleDataModule extends MentatModule {
  @Override
  protected void configure() {
    super.configure();
    bindDaos(ExampleDao.class);
  }

  @Provides
  public MySqlConfiguration getMySqlConfiguration(@Named("example.db.user") String username,
                                                  @Named("example.db.pass") String password,
                                                  @Named("example.db.host") String host,
                                                  @Named("example.db.db") String db) {
    return MySqlConfiguration.builder()
        .setUsername(username)
        .setPassword(password)
        .setHost(host)
        .setDb(db)
        .build();
  }
}
