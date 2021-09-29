package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.enums.MeasureUnit;
import it.euris.academy.teslabattery_na.data.model.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentDto implements Dto {

  private String componentIdDto;
  private String componentNameDto;
  private String componentMUDto;
  private String dangerousDto;

  @Override
  public Component toModel() {
    return Component.builder()
        .componentId(componentIdDto == null ? null : Long.valueOf(componentIdDto))
        .componentName(componentNameDto)
        .componentMU(MeasureUnit.valueOf(componentMUDto))
        .dangerous(Boolean.valueOf(dangerousDto))
        .build();
  }

}
