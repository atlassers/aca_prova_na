package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.FormulaDto;
import java.util.List;

public interface FormulaService {

  List<FormulaDto> getAll();

  FormulaDto get(Long id);

  FormulaDto add(FormulaDto formulaDto);

  FormulaDto update(FormulaDto formulaDto);

  Boolean delete(Long id);
}
