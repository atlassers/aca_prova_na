package it.euris.academy.teslabattery_na.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_na.data.archetype.Model;
import it.euris.academy.teslabattery_na.data.dto.ProductionCycleDto;
import it.euris.academy.teslabattery_na.data.enums.PCStatus;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "prodcycle")
@Entity
@SQLDelete(sql = "UPDATE Prodcycle SET deleted_flag = true WHERE production_cycle_id=?")
@Where(clause = "deleted_flag = false")
public class ProductionCycle implements Model {

  @Id
  @Column(name = "production_cycle_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productionCycleId;

  @Column(name = "production_cycle_status")
  private PCStatus pcStatus;

  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "status_date")
  private Date statusDate;

  @Column(name = "end_date")
  private Date endDate;

  @OneToOne
  @Cascade(CascadeType.MERGE)
  @JoinColumn(name = "assembly_line_id", referencedColumnName = "assembly_line_id")
  @JsonIgnore
  private AssemblyLine assemblyLine;

  @Column(name = "deleted_flag")
  @Builder.Default
  private Boolean deleted = Boolean.FALSE;

  @Override
  public ProductionCycleDto toDto() {
    return ProductionCycleDto.builder()
        .productionCycleIdDto(String.valueOf(productionCycleId))
        .pcStatusDto(String.valueOf(pcStatus))
        .startDateDto(String.valueOf(startDate))
        .statusDateDto(String.valueOf(statusDate))
        .endDateDto(String.valueOf(endDate))
        .build();
  }
}
