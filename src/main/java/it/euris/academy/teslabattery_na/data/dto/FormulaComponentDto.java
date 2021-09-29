package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.model.Component;
import it.euris.academy.teslabattery_na.data.model.Formula;
import it.euris.academy.teslabattery_na.data.model.FormulaComponent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaComponentDto implements Dto {

  private String formulaIdDto;
  private String componentIdDto;
  private String numberOfComponentsDto;

  @Override
  public FormulaComponent toModel() {
    return FormulaComponent.builder()
        .formula(new Formula(Long.valueOf(formulaIdDto)))
        .component(new Component(Long.valueOf(formulaIdDto)))
        .build();
  }
}
