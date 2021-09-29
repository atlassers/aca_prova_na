package it.euris.academy.teslabattery_na.controller;

import io.swagger.annotations.Api;
import it.euris.academy.teslabattery_na.data.dto.FormulaDto;
import it.euris.academy.teslabattery_na.service.FormulaService;
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

@Api(value = "FormulaController")
@RestController
@RequestMapping("/formulas")
public class FormulaController {
  
  @Autowired
  private FormulaService formulaService;

  @GetMapping("/v1")
  public List<FormulaDto> getAll() {
    return formulaService.getAll();
  }

  @GetMapping("/v1/{id}")
  public FormulaDto get(@PathVariable("id") Long id) {
    return formulaService.get(id);
  }

  @PostMapping("/v1")
  public FormulaDto add(@RequestBody FormulaDto formulaDto) throws ParseException {
    return formulaService.add(formulaDto);
  }

  @PutMapping("/v1")
  public FormulaDto update(@RequestBody FormulaDto formulaDto) throws ParseException {
    return formulaService.update(formulaDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return formulaService.delete(id);
  }
}
