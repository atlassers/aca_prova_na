package it.euris.academy.teslabattery_na.data.model;

import it.euris.academy.teslabattery_na.data.archetype.Model;
import it.euris.academy.teslabattery_na.data.dto.ComponentDto;
import it.euris.academy.teslabattery_na.data.enums.MeasureUnit;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "component")
@Entity
@SQLDelete(sql = "UPDATE Component SET deleted_flag = true WHERE component_id=?")
@Where(clause = "deleted_flag = false")
public class Component implements Model {

  @Id
  @Column(name = "component_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long componentId;

  @Column(name = "component_name")
  private String componentName;

  @Column(name = "component_measure_unit")
  private MeasureUnit componentMU;

  @Column(name = "danger_flag")
  private Boolean dangerous;

  @Column(name = "deleted_flag")
  @Builder.Default
  private Boolean deleted = Boolean.FALSE;

  @OneToMany(mappedBy = "component")
  private Set<FormulaComponent> formulaComponents;

  @Override
  public ComponentDto toDto() {
    return ComponentDto.builder()
        .componentIdDto(String.valueOf(componentId))
        .componentNameDto(componentName)
        .componentMUDto(String.valueOf(componentMU))
        .dangerousDto(String.valueOf(dangerous))
        .build();
  }
}
