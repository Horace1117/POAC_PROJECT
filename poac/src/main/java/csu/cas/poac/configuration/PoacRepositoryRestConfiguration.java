package csu.cas.poac.configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import csu.cas.poac.model.CctcRaw;
import csu.cas.poac.model.Plan;


public class PoacRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter{
	  @Override
	   public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	  config.exposeIdsFor(Plan.class);
      config.exposeIdsFor(CctcRaw.class);
	  }
}
