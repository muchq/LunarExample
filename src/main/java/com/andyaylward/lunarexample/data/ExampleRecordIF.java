package com.andyaylward.lunarexample.data;

import com.hubspot.rosetta.annotations.RosettaProperty;
import com.muchq.immutables.MoonStyle;
import org.immutables.value.Value.Immutable;

@Immutable
@MoonStyle
public interface ExampleRecordIF {
  @RosettaProperty("id")
  int getId();
  @RosettaProperty("name")
  String getName();
}
