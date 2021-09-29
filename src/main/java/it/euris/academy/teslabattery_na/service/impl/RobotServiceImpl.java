package it.euris.academy.teslabattery_na.service.impl;

import it.euris.academy.teslabattery_na.data.dto.RobotDto;
import it.euris.academy.teslabattery_na.data.model.Component;
import it.euris.academy.teslabattery_na.data.model.Robot;
import it.euris.academy.teslabattery_na.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_na.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_na.repository.RobotRepository;
import it.euris.academy.teslabattery_na.service.RobotService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotServiceImpl implements RobotService {

  @Autowired
  private RobotRepository robotRepository;

  @Override
  public List<RobotDto> getAll() {
    return robotRepository.findAll()
        .stream().map(robot -> robot.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public RobotDto get(Long id) {
    Optional<Robot> findById = robotRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public RobotDto add(RobotDto robotDto) {
    if(robotDto.getRobotIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return robotRepository.save(robotDto.toModel()).toDto();
  }

  @Override
  public RobotDto update(RobotDto robotDto) {
    if(robotDto.getRobotIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return robotRepository.save(robotDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    robotRepository.deleteById(id);
    Optional<Robot> deletedRobot = robotRepository.findById(id);
    if(deletedRobot.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
