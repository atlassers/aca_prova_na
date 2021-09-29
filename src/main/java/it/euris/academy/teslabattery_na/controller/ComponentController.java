package it.euris.academy.teslabattery_na.controller;

import io.swagger.annotations.Api;
import it.euris.academy.teslabattery_na.data.dto.ComponentDto;
import it.euris.academy.teslabattery_na.service.ComponentService;
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

@Api(value = "ComponentController")
@RestController
@RequestMapping("/components")
public class ComponentController {

  @Autowired
  ComponentService componentService;

  @GetMapping("/v1")
  public List<ComponentDto> getAll() {
    return componentService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ComponentDto get(@PathVariable("id") Long id) {
    return componentService.get(id);
  }

  @PostMapping("/v1")
  public ComponentDto add(@RequestBody ComponentDto componentDto) throws ParseException {
    return componentService.add(componentDto);
  }

  @PutMapping("/v1")
  public ComponentDto update(@RequestBody ComponentDto componentDto) throws ParseException {
    return componentService.update(componentDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return componentService.delete(id);
  }
}
