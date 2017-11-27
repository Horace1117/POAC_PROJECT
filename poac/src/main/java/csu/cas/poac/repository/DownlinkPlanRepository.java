package csu.cas.poac.repository;




import csu.cas.poac.model.Plan;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface DownlinkPlanRepository extends PlanRepository<Plan, String>{
    @Query(value = "select * from plan p where p.timestart < ?1 and p.timestop>?2", nativeQuery = true)
    Collection<Plan> findPlanByTime(String timeStart, String timeStop);

}
