package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.model.ProductionCycle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCycleDto implements Dto {

  private String productionCycleIdDto;
  private String pcStatusDto;
  private String startDateDto;
  private String statusDateDto;
  private String endDateDto;

  @Override
  public ProductionCycle toModel() {
    return null;
  }
}
