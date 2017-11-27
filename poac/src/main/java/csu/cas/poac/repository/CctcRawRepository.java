package csu.cas.poac.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


import csu.cas.poac.model.CctcRaw;

public interface CctcRawRepository extends CctcRepository<CctcRaw, String> {
	@Query(value = "select * from cctcraw c", nativeQuery = true)
	Collection<CctcRaw> getAll();
}
