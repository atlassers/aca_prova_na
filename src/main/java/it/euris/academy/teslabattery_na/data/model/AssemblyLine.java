package it.euris.academy.teslabattery_na.data.model;

import it.euris.academy.teslabattery_na.data.archetype.Model;
import it.euris.academy.teslabattery_na.data.dto.AssemblyLineDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "assemblyline")
@Entity
@SQLDelete(sql = "UPDATE AssemblyLine SET deleted_flag = true WHERE assembly_line_id=?")
@Where(clause = "deleted_flag = false")
public class AssemblyLine implements Model {

  @Id
  @Column(name = "assembly_line_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long assemblyLineId;

  @Column(name = "assembly_line_name")
  private String assemblyLineName;

  @Column(name = "assembly_line_prodTime") // in seconds
  private Integer assemblyLineProdTime;

  @Column(name = "deleted_flag")
  @Builder.Default
  private Boolean deleted = Boolean.FALSE;

  @OneToOne(mappedBy = "assemblyLine")
  private Formula formula;

  @Override
  public AssemblyLineDto toDto() {
    return AssemblyLineDto.builder()
        .assemblyLineIdDto(String.valueOf(assemblyLineId))
        .assemblyLineNameDto(assemblyLineName)
        .assemblyLineProdTimeDto(String.valueOf(assemblyLineProdTime))
        .build();
  }
}
