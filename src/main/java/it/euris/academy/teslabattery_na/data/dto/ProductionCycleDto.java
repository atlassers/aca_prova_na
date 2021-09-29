package it.euris.academy.teslabattery_na.data.dto;

import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.enums.PCStatus;
import it.euris.academy.teslabattery_na.data.model.ProductionCycle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
  public ProductionCycle toModel() throws ParseException {
    return ProductionCycle.builder()
        .productionCycleId(productionCycleIdDto == null ? null : Long.valueOf(productionCycleIdDto))
        .pcStatus(PCStatus.valueOf(pcStatusDto))
        .startDate(new SimpleDateFormat("yyyy-MM-dd").parse(startDateDto))
        .statusDate(new SimpleDateFormat("yyyy-MM-dd").parse(statusDateDto))
        .statusDate(new SimpleDateFormat("yyyy-MM-dd").parse(endDateDto))
        .build();
  }
}
