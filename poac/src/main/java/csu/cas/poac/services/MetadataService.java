package csu.cas.poac.services;

import csu.cas.poac.model.CctcRaw;
import csu.cas.poac.valueobject.MetadataCtccRawForm;

public interface MetadataService {
	public CctcRaw archiveCtccRawMetadata(MetadataCtccRawForm cctcRawForm);
}
