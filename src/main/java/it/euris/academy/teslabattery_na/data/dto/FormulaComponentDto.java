package it.euris.academy.teslabattery_na.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.model.FormulaComponent;
import it.euris.academy.teslabattery_na.repository.ComponentRepository;
import it.euris.academy.teslabattery_na.repository.FormulaRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaComponentDto implements Dto {

  @Autowired
  @JsonIgnore
  FormulaRepository formulaRepository;

  @Autowired
  @JsonIgnore
  ComponentRepository componentRepository;

  private String formulaIdDto;
  private String componentIdDto;
  private String numberOfComponentsDto;

  @Override
  public FormulaComponent toModel() {
    return FormulaComponent.builder()
        .formula(formulaRepository.getById(Long.valueOf(formulaIdDto)))
        .component(componentRepository.getById(Long.valueOf(componentIdDto)))
        .build();
  }
}
