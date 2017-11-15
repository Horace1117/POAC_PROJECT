package csu.cas.poac.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.CrudRepository;

import csu.cas.poac.model.Plan;


@NoRepositoryBean
public interface PlanRepository<Plan,String> extends CrudRepository<Plan, Long> {
	@Query(value = "select * from plan p where p.timestart < ?1 and p.timestop>?2", nativeQuery = true)
	Collection<Plan> findPlanByTime(String timeStart,String timeStop);
	
}
