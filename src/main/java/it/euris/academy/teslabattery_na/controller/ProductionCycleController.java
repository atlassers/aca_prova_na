package it.euris.academy.teslabattery_na.controller;

import io.swagger.annotations.Api;
import it.euris.academy.teslabattery_na.data.dto.ProductionCycleDto;
import it.euris.academy.teslabattery_na.repository.projection.ICyclesCountDate;
import it.euris.academy.teslabattery_na.service.ProductionCycleService;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "ProductionCycleController")
@RestController
@RequestMapping("/productioncycles")
public class ProductionCycleController {
  
  @Autowired
  private ProductionCycleService productionCycleService;

  @GetMapping("/v1")
  public List<ProductionCycleDto> getAll() {
    return productionCycleService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ProductionCycleDto get(@PathVariable("id") Long id) {
    return productionCycleService.get(id);
  }

  @PostMapping("/v1")
  public ProductionCycleDto add(@RequestBody ProductionCycleDto productionCycleDto) throws ParseException {
    return productionCycleService.add(productionCycleDto);
  }

  @PutMapping("/v1")
  public ProductionCycleDto update(@RequestBody ProductionCycleDto productionCycleDto) throws ParseException {
    return productionCycleService.update(productionCycleDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return productionCycleService.delete(id);
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  @GetMapping("/v1/queryOne")
  public List<ICyclesCountDate> countCompletedProdCyclesEachMonth() {
    return productionCycleService.countCompletedProdCyclesEachMonth();
  }

  @GetMapping("/v1/queryTwo")
  public List<ICyclesCountDate> countFailedProdCyclesEachMonth() {
    return productionCycleService.countFailedProdCyclesEachMonth();
  }

  @GetMapping("/v1/queryThree")
  public List<ICyclesCountDate> countTotalProdCyclesEachMonth() {
    return productionCycleService.countTotalProdCyclesEachMonth();
  }
}
