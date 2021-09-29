package it.euris.academy.teslabattery_na.service.impl;

import it.euris.academy.teslabattery_na.data.dto.ProductionCycleDto;
import it.euris.academy.teslabattery_na.data.model.ProductionCycle;
import it.euris.academy.teslabattery_na.repository.ProductionCycleRepository;
import it.euris.academy.teslabattery_na.repository.projection.ICyclesCountDate;
import it.euris.academy.teslabattery_na.service.ProductionCycleService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionCycleServiceImpl implements ProductionCycleService {

  @Autowired
  private ProductionCycleRepository productionCycleRepository;

  @Override
  public List<ProductionCycleDto> getAll() {
    return productionCycleRepository.findAll()
        .stream().map(productionCycle -> productionCycle.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ProductionCycleDto get(Long id) {
    Optional<ProductionCycle> findById = productionCycleRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public ProductionCycleDto add(ProductionCycleDto productionCycleDto) {
    return null;
  }

  @Override
  public ProductionCycleDto update(ProductionCycleDto productionCycleDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    productionCycleRepository.deleteById(id);
    Optional<ProductionCycle> deletedProductionCycle = productionCycleRepository.findById(id);
    if(deletedProductionCycle.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  @Override
  public List<ICyclesCountDate> countCompletedProdCyclesEachMonth() {
    return productionCycleRepository.countCompletedProdCyclesEachMonth();
  }

  @Override
  public List<ICyclesCountDate> countFailedProdCyclesEachMonth() {
    return productionCycleRepository.countFailedProdCyclesEachMonth();
  }

  @Override
  public List<ICyclesCountDate> countTotalProdCyclesEachMonth() {
    return productionCycleRepository.countTotalProdCyclesEachMonth();
  }

}
