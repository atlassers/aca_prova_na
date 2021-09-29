package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.ProductionCycleDto;
import java.util.List;

public interface ProductionCycleService {
  List<ProductionCycleDto> getAll();

  ProductionCycleDto get(Long id);

  ProductionCycleDto add(ProductionCycleDto productionCycleDto);

  ProductionCycleDto update(ProductionCycleDto productionCycleDto);

  Boolean delete(Long id);
}
