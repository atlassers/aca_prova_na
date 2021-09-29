package it.euris.academy.teslabattery_na.controller;

import io.swagger.annotations.Api;
import it.euris.academy.teslabattery_na.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_na.service.AssemblyLineService;
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

@Api(value = "AssemblyLineController")
@RestController
@RequestMapping("/assemblylines")
public class AssemblyLineController {
  
  @Autowired
  private AssemblyLineService assemblyLineService;

  @GetMapping("/v1")
  public List<AssemblyLineDto> getAll() {
    return assemblyLineService.getAll();
  }

  @GetMapping("/v1/{id}")
  public AssemblyLineDto get(@PathVariable("id") Long id) {
    return assemblyLineService.get(id);
  }

  @PostMapping("/v1")
  public AssemblyLineDto add(@RequestBody AssemblyLineDto assemblyLineDto) throws ParseException {
    return assemblyLineService.add(assemblyLineDto);
  }

  @PutMapping("/v1")
  public AssemblyLineDto update(@RequestBody AssemblyLineDto assemblyLineDto) throws ParseException {
    return assemblyLineService.update(assemblyLineDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return assemblyLineService.delete(id);
  }
}
