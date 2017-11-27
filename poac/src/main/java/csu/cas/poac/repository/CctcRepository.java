package csu.cas.poac.repository;

import csu.cas.poac.model.CctcRaw;
import csu.cas.poac.model.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CctcRepository<CctcRaw,String> extends CrudRepository<CctcRaw, Long> {

}
