package it.euris.academy.teslabattery_na.data.model;

import it.euris.academy.teslabattery_na.data.archetype.Model;
import it.euris.academy.teslabattery_na.data.dto.RobotDto;
import it.euris.academy.teslabattery_na.data.enums.RobotTasks;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "robot")
@Entity
@SQLDelete(sql = "UPDATE Robot SET deleted_flag = true WHERE robot_id=?")
@Where(clause = "deleted_flag = false")
public class Robot implements Model {

  @Id
  @Column(name = "robot_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long robotId;

  @Column(name = "robot_task")
  private RobotTasks robotTask;

  @Column(name = "deleted_flag")
  @Builder.Default
  private Boolean deleted = Boolean.FALSE;

  @Override
  public RobotDto toDto() {
    return RobotDto.builder()
        .robotIdDto(String.valueOf(robotId))
        .robotTaskDto(String.valueOf(robotTask))
        .build();
  }
}
