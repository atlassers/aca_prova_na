package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.ComponentDto;
import java.util.List;

public interface ComponentService {

  List<ComponentDto> getAll();

  ComponentDto get(Long id);

  ComponentDto add(ComponentDto componentDto);

  ComponentDto update(ComponentDto componentDto);

  Boolean delete(Long id);
}
