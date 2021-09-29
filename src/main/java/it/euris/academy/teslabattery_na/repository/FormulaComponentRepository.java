package it.euris.academy.teslabattery_na.repository;

import it.euris.academy.teslabattery_na.data.model.FormulaComponent;
import it.euris.academy.teslabattery_na.data.model.key.FormulaComponentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaComponentRepository extends JpaRepository<FormulaComponent, FormulaComponentKey> {

}
