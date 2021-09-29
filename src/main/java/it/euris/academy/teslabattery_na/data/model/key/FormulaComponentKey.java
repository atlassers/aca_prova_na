package it.euris.academy.teslabattery_na.data.model.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FormulaComponentKey implements Serializable {

  @Column(name = "formula_id")
  Long formulaId;

  @Column(name = "component_id")
  Long componentId;

}
