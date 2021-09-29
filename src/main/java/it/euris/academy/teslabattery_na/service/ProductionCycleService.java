package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.ProductionCycleDto;
import it.euris.academy.teslabattery_na.repository.projection.ICyclesCountDate;
import java.util.List;

public interface ProductionCycleService {
  List<ProductionCycleDto> getAll();

  ProductionCycleDto get(Long id);

  ProductionCycleDto add(ProductionCycleDto productionCycleDto);

  ProductionCycleDto update(ProductionCycleDto productionCycleDto);

  Boolean delete(Long id);
  //////////////////////////////////////////////////////////////////////////////////////////////////

  List<ICyclesCountDate> countCompletedProdCyclesEachMonth();

  List<ICyclesCountDate> countFailedProdCyclesEachMonth();

  List<ICyclesCountDate> countTotalProdCyclesEachMonth();
}
