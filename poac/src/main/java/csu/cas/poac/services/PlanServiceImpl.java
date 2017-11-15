package csu.cas.poac.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import csu.cas.poac.model.Plan;
import csu.cas.poac.repository.PlanRepository;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepository<Plan, String> downlinkPlanRepository;
	
	public Collection<Plan> getDownlinkPlanByTime(String timeStart, String timeStop) {

		return downlinkPlanRepository.findPlanByTime(timeStart,timeStop);
	}

}
