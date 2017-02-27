package com.andyaylward.lunarexample.config;

import com.andyaylward.lunarexample.data.ExampleDataModule;
import com.google.inject.AbstractModule;
import com.hubspot.liveconfig.LiveConfig;
import com.hubspot.liveconfig.LiveConfigModule;

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
