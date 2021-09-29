package it.euris.academy.teslabattery_na.repository;

import it.euris.academy.teslabattery_na.data.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component,Long> {

}
