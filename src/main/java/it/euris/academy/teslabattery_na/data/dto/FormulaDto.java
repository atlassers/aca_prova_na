package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.model.AssemblyLine;
import it.euris.academy.teslabattery_na.data.model.Formula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaDto implements Dto {

  private String formulaIdDto;
  private String formulaNameDto;
  private String assemblyLineIdDto;

  @Override
  public Formula toModel() {
    return Formula.builder()
        .formulaId(formulaIdDto == null ? null : Long.valueOf(formulaIdDto))
        .formulaName(formulaNameDto)
        .assemblyLine(new AssemblyLine(Long.valueOf(assemblyLineIdDto)))
        .build();
  }
}
