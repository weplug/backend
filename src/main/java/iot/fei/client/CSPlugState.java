package iot.fei.client;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CSPlugState {
  
  ON("ON"),
  
  OFF("OFF"),
  
  ERROR("ERROR");

  private String value;

  CSPlugState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CSPlugState fromValue(String text) {
    for (CSPlugState b : CSPlugState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

