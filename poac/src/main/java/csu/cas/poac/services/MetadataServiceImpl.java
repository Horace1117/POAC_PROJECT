package csu.cas.poac.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import csu.cas.poac.model.CctcRaw;
import csu.cas.poac.model.Plan;
import csu.cas.poac.repository.CctcRawRepository;
import csu.cas.poac.repository.DownlinkPlanRepository;
import csu.cas.poac.repository.PlanRepository;
import csu.cas.poac.valueobject.MetadataCtccRawForm;

@Service
@Transactional
public class MetadataServiceImpl implements MetadataService {
    @Autowired
    private  CctcRawRepository<CctcRaw, String> cctcRawRepository;

	public CctcRaw archiveCtccRawMetadata(MetadataCtccRawForm cctcRawForm) {
		CctcRaw cctcRaw = new CctcRaw();
		BeanUtils.copyProperties(cctcRawForm,cctcRaw);
		cctcRawRepository.save(cctcRaw);
		return cctcRaw;
	}

}
