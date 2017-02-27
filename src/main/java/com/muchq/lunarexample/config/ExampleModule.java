package com.muchq.lunarexample.config;

import com.google.inject.AbstractModule;
import com.hubspot.liveconfig.LiveConfig;
import com.hubspot.liveconfig.LiveConfigModule;
import com.muchq.lunarexample.data.ExampleDataModule;

public class ExampleModule extends AbstractModule {
  @Override
  protected void configure() {
    install(new ExampleDataModule());
    install(new LiveConfigModule(LiveConfig.builder()
                                     .usingEnvironmentVariables()
                                     .usingSystemProperties()
                                     .build()));
  }
}
