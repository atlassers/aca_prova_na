package it.euris.academy.teslabattery_na.repository;

import it.euris.academy.teslabattery_na.data.model.ProductionCycle;
import it.euris.academy.teslabattery_na.repository.projection.ICyclesCountDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductionCycleRepository extends JpaRepository<ProductionCycle,Long> {
  @Query(value =
      "SELECT COUNT(pc.production_cycle_id) AS 'countCycles', "
        +"pc.end_date as 'endDate' "
          + "FROM teslabattery_na.prodcycle pc\n"
            + "WHERE pc.production_cycle_status = 1\n"
              +"GROUP BY MONTH(pc.end_date)", nativeQuery = true)
  public List<ICyclesCountDate> countCompletedProdCyclesEachMonth();

  @Query(value =
      "SELECT COUNT(pc.production_cycle_id) AS 'countCycles', "
        + "pc.end_date as 'endDate' "
          + "FROM teslabattery_na.prodcycle pc\n"
            + "WHERE pc.production_cycle_status = 0\n"
              + "GROUP BY MONTH(pc.end_date)", nativeQuery = true)
  public List<ICyclesCountDate> countFailedProdCyclesEachMonth();

  @Query(value =
      "SELECT COUNT(pc.production_cycle_id) AS 'countCycles', "
        +"pc.end_date as 'endDate' "
          + "FROM teslabattery_na.prodcycle pc\n"
            + "GROUP BY MONTH(pc.end_date)", nativeQuery = true)
  public List<ICyclesCountDate> countTotalProdCyclesEachMonth();
}
