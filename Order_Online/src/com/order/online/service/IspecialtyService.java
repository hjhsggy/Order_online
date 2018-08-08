package com.order.online.service;
import com.order.online.domain.specialtyBean;

import java.util.List;

public interface IspecialtyService {

    public List<specialtyBean> GetSpecialty();
	
	public specialtyBean getObject(String id);
	
	public int AddSpecialty(specialtyBean specialty);
	
	public int ModSpecialty(specialtyBean specialty);
	
	public int DelSpecialty(specialtyBean specialty);
}
