package it.euris.academy.teslabattery_na.repository;

import it.euris.academy.teslabattery_na.data.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot,Long> {

}
