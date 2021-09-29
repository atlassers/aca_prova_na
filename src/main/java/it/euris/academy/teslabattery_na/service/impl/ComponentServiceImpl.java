package it.euris.academy.teslabattery_na.service.impl;

import it.euris.academy.teslabattery_na.data.dto.ComponentDto;
import it.euris.academy.teslabattery_na.data.model.Component;
import it.euris.academy.teslabattery_na.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_na.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_na.repository.ComponentRepository;
import it.euris.academy.teslabattery_na.service.ComponentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentServiceImpl implements ComponentService {

  @Autowired
  ComponentRepository componentRepository;

  @Override
  public List<ComponentDto> getAll() {
    return componentRepository.findAll()
        .stream().map(component -> component.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ComponentDto get(Long id) {
    Optional<Component> findById = componentRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public ComponentDto add(ComponentDto componentDto) {
    if(componentDto.getComponentIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return componentRepository.save(componentDto.toModel()).toDto();
  }

  @Override
  public ComponentDto update(ComponentDto componentDto) {
    if(componentDto.getComponentIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return componentRepository.save(componentDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    componentRepository.deleteById(id);
    Optional<Component> deletedComponent = componentRepository.findById(id);
    if(deletedComponent.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
