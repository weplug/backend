package iot.fei.core.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PlugState {
  
  ON("ON"),
  
  OFF("OFF"),
  
  ERROR("ERROR");

  private String value;

  PlugState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PlugState fromValue(String text) {
    for (PlugState b : PlugState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

