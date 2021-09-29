package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.FormulaComponentDto;
import it.euris.academy.teslabattery_na.data.model.key.FormulaComponentKey;
import java.util.List;

public interface FormulaComponentService {

  List<FormulaComponentDto> getAll();

  FormulaComponentDto get(FormulaComponentKey id);

  FormulaComponentDto add(FormulaComponentDto formulaDto);

  FormulaComponentDto update(FormulaComponentDto formulaDto);

  Boolean delete(FormulaComponentKey id);
}
