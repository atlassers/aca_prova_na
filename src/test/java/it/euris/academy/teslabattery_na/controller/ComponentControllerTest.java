package it.euris.academy.teslabattery_na.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import it.euris.academy.teslabattery_na.data.dto.ComponentDto;
import it.euris.academy.teslabattery_na.data.enums.MeasureUnit;
import it.euris.academy.teslabattery_na.data.model.Component;
import it.euris.academy.teslabattery_na.repository.ComponentRepository;
import it.euris.academy.teslabattery_na.service.ComponentService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ComponentControllerTest {

  @Autowired
  ComponentService componentService;

  @MockBean
  ComponentRepository componentRepository;

  private Component createComponent(Long id, String name, Boolean dangerous) {

    return Component.builder()
        .componentId(id)
        .componentName(name)
        .componentMU(MeasureUnit.g)
        .dangerous(dangerous)
        .build();
  }

  private List<Component> createComponentsList() {
    return List.of(createComponent(1L, "component1", Boolean.FALSE),
                    createComponent(2L, "component2", Boolean.TRUE));
  }


  @Test
  void getAll() {
    List<Component> mockedComponents = createComponentsList();
    when(componentRepository.findAll()).thenReturn(mockedComponents);

    List<ComponentDto> purchases = componentService.getAll();

    assertEquals(mockedComponents.size(), purchases.size());
    for(int i = 0; i < mockedComponents.size(); i++)
      assertEquals(mockedComponents.get(i).toDto(), purchases.get(i));
  }

  @Test
  void get() {
    final Long ID = 1L;
    Component mockedComponent = createComponent(ID, "component1", Boolean.FALSE);
    when(componentRepository.findById(ID)).thenReturn(Optional.of(mockedComponent));

    ComponentDto component = componentService.get(ID);

    assertEquals(mockedComponent.toDto(), component);
  }

  @Test
  void add() {
    Component componentToAdd = createComponent(null, null, null);
    Component componentToReturn = createComponent(10L, "component", Boolean.TRUE);
    when(componentRepository.save(any())).thenReturn(componentToReturn);

    ComponentDto componentDto = componentService.add(componentToAdd.toDto());

    assertEquals(componentToReturn.toDto(), componentDto);
  }

  @Test
  void update() {
    Component componentToUpdate = createComponent(9L,"lol", Boolean.TRUE);
    Component componentToReturn = createComponent(10L, "lol", Boolean.TRUE);
    when(componentRepository.save(any())).thenReturn(componentToReturn);

    ComponentDto componentDto = componentService.update(componentToUpdate.toDto());

    assertEquals(componentToReturn.toDto(), componentDto);
  }

  @Test
  void delete() {
    final Long ID = 1L;
    doNothing().when(componentRepository).deleteById(ID);
    when(componentRepository.findById(ID)).thenReturn(Optional.empty());

    Boolean deleted = componentService.delete(ID);

    assertTrue(deleted);
  }
}