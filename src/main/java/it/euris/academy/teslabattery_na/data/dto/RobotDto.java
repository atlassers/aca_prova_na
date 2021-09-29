package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.enums.RobotTasks;
import it.euris.academy.teslabattery_na.data.model.Robot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RobotDto implements Dto {

  private String robotIdDto;
  private String robotTaskDto;

  @Override
  public Robot toModel() {
    return Robot.builder()
        .robotId(robotIdDto == null ? null : Long.valueOf(robotIdDto))
        .robotTask(RobotTasks.valueOf(robotTaskDto))
        .build();
  }
}
