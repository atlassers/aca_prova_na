package it.euris.academy.teslabattery_na.data.model;

import it.euris.academy.teslabattery_na.data.archetype.Model;
import it.euris.academy.teslabattery_na.data.dto.FormulaDto;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "formula")
@Entity
@SQLDelete(sql = "UPDATE Formula SET deleted_flag = true WHERE formula_id=?")
@Where(clause = "deleted_flag = false")
public class Formula implements Model {

  @Id
  @Column(name = "formula_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long formulaId;

  @Column(name = "formula_name")
  private String formulaName;

  @OneToOne
  @Cascade(CascadeType.ALL)
  @JoinColumn(name = "assembly_line_id", referencedColumnName = "assembly_line_id")
  private AssemblyLine assemblyLine;

  @OneToMany(mappedBy = "formula")
  private Set<FormulaComponent> formulaComponents;

  @Override
  public FormulaDto toDto() {
    return null;
  }
}
