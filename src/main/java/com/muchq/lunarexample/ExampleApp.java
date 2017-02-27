package com.muchq.lunarexample;

import com.muchq.lunarexample.config.ExampleModule;
import com.muchq.lunarcat.Service;
import com.muchq.lunarcat.config.Configuration;

public class ExampleApp {
  public static void main(String... args) {
    Configuration configuration = Configuration.newBuilder()
        .withBasePackage(ExampleApp.class.getPackage())
        .withModules(new ExampleModule())
        .build();
    new Service(configuration).run();
  }
}
