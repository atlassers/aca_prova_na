package it.euris.academy.teslabattery_na.data.archetype;

import java.text.ParseException;

public interface Dto {
  public Model toModel() throws ParseException;
}
