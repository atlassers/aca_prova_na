package it.euris.academy.teslabattery_na.controller;

import io.swagger.annotations.Api;
import it.euris.academy.teslabattery_na.data.dto.FormulaComponentDto;
import it.euris.academy.teslabattery_na.data.model.key.FormulaComponentKey;
import it.euris.academy.teslabattery_na.service.FormulaComponentService;
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

@Api(value = "FormulaComponentController")
@RestController
@RequestMapping("/formulacomponents")
public class FormulaComponentController {
  
  @Autowired
  private FormulaComponentService formulaComponentService;

  @GetMapping("/v1")
  public List<FormulaComponentDto> getAll() {
    return formulaComponentService.getAll();
  }

  @GetMapping("/v1/{id}")
  public FormulaComponentDto get(@PathVariable("id") FormulaComponentKey id) {
    return formulaComponentService.get(id);
  }

  @PostMapping("/v1")
  public FormulaComponentDto add(@RequestBody FormulaComponentDto formulaComponentDto) throws ParseException {
    return formulaComponentService.add(formulaComponentDto);
  }

  @PutMapping("/v1")
  public FormulaComponentDto update(@RequestBody FormulaComponentDto formulaComponentDto) throws ParseException {
    return formulaComponentService.update(formulaComponentDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") FormulaComponentKey id) {
    return formulaComponentService.delete(id);
  }

}
