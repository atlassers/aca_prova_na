package it.euris.academy.teslabattery_na.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_na.data.archetype.Dto;
import it.euris.academy.teslabattery_na.data.archetype.Model;
import it.euris.academy.teslabattery_na.data.dto.FormulaComponentDto;
import it.euris.academy.teslabattery_na.data.model.key.FormulaComponentKey;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
@Table(name = "formula_component")
@Entity
@SQLDelete(sql = "UPDATE Formula SET deleted_flag = true WHERE formula_id=? AND component_id=?")
@Where(clause = "deleted_flag = false")
public class FormulaComponent implements Model {

  @EmbeddedId
  private FormulaComponentKey id;

  @ManyToOne
  @MapsId("formulaId")
  @JoinColumn(name = "formula_id")
  @JsonIgnore
  private Formula formula;

  @ManyToOne
  @MapsId("componentId")
  @JoinColumn(name = "component_id")
  @JsonIgnore
  private Component component;

  @Column(name = "num_of_components")
  private Integer numberOfComponents;

  @Column(name = "deleted_flag")
  @Builder.Default
  private Boolean deleted = Boolean.FALSE;

  @Override
  public FormulaComponentDto toDto() {
    return FormulaComponentDto.builder()
        .formulaIdDto(String.valueOf(formula.getFormulaId()))
        .componentIdDto(String.valueOf(component.getComponentId()))
        .numberOfComponentsDto(String.valueOf(numberOfComponents))
        .build();
  }
}
