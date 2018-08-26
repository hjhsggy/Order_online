package com.order.online.service.impl;

import java.util.List;

import com.order.online.dao.IspecialtyDao;
import com.order.online.domain.specialtyBean;
import com.order.online.service.IspecialtyService;

public class specialtyServiceImpl implements IspecialtyService {
	private IspecialtyDao ispecialty;
	public specialtyServiceImpl(IspecialtyDao ispecialty)
	{
		this.ispecialty = ispecialty;
	}
	@Override
	public List<specialtyBean> GetSpecialty() {
		// TODO Auto-generated method stub
		return ispecialty.GetSpecialty();
	}

	@Override
	public specialtyBean getObject(String id) {
		// TODO Auto-generated method stub
		return ispecialty.getObject(id);
	}

	@Override
	public int AddSpecialty(specialtyBean specialty) {
		// TODO Auto-generated method stub
		return ispecialty.AddSpecialty(specialty);
	}

	@Override
	public int ModSpecialty(specialtyBean specialty) {
		// TODO Auto-generated method stub
		return ispecialty.ModSpecialty(specialty);
	}

	@Override
	public int DelSpecialty(specialtyBean specialty) {
		// TODO Auto-generated method stub
		return ispecialty.DelSpecialty(specialty);
	}

}
