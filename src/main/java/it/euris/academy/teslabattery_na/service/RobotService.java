package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.RobotDto;
import java.util.List;

public interface RobotService {

  List<RobotDto> getAll();

  RobotDto get(Long id);

  RobotDto add(RobotDto robotDto);

  RobotDto update(RobotDto robotDto);

  Boolean delete(Long id);
}
