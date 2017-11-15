package csu.cas.poac.services;

import java.util.Collection;

import csu.cas.poac.model.Plan;

public interface PlanService {

	public Collection<Plan> getDownlinkPlanByTime(String timeStart, String timeStop);
}
