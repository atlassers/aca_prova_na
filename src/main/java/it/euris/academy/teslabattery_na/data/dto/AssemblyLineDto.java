package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.model.AssemblyLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssemblyLineDto implements Dto {

  private String assemblyLineIdDto;
  private String assemblyLineNameDto;
  private String assemblyLineProdTimeDto;

  @Override
  public AssemblyLine toModel() {
    return AssemblyLine.builder()
        .assemblyLineId(assemblyLineIdDto == null ? null : Long.valueOf(assemblyLineIdDto))
        .assemblyLineName(assemblyLineNameDto)
        .assemblyLineProdTime(Integer.valueOf(assemblyLineProdTimeDto))
        .build();
  }
}
