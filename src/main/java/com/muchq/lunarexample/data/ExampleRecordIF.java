package com.muchq.lunarexample.data;

import com.hubspot.rosetta.annotations.RosettaProperty;
import com.muchq.immutables.MoonStyle;
import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Modifiable;

@Immutable
@Modifiable
@MoonStyle
public interface ExampleRecordIF {
  @RosettaProperty("id")
  int getId();
  @RosettaProperty("name")
  String getName();
}
