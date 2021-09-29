package it.euris.academy.teslabattery_na.data.model;

import it.euris.academy.teslabattery_na.data.model.key.FormulaComponentKey;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class FormulaComponent {

  @EmbeddedId
  FormulaComponentKey id;

  @ManyToOne
  @MapsId("formulaId")
  @JoinColumn(name = "formula_id")
  Formula formula;

  @ManyToOne
  @MapsId("componentId")
  @JoinColumn(name = "component_id")
  Component component;

  @Column(name = "num_of_components")
  private Integer numberOfComponents;

}
