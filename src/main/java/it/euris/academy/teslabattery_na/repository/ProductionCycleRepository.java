package it.euris.academy.teslabattery_na.repository;

import it.euris.academy.teslabattery_na.data.model.ProductionCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductionCycleRepository extends JpaRepository<ProductionCycle,Long> {
  @Query(value =
      "SELECT COUNT(pc.production_cycle_id) AS 'completed cycles', "
        +"pc.end_date as 'end_date' "
          + "FROM teslabattery_na.prodcycle pc\n"
            + "WHERE pc.production_cycle_status = 1", nativeQuery = true)
  public int countCompletedProdCyclesEachMonth();

}
