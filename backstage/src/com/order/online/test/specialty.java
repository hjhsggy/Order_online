package com.order.online.test;

import org.junit.Test;

import com.order.online.dao.IspecialtyDao;
import com.order.online.dao.impl.specialtyDaoImpl;
import com.order.online.domain.specialtyBean;
import com.order.online.service.IspecialtyService;
import com.order.online.service.impl.specialtyServiceImpl;

public class specialty {
	
	@Test
	public void getspeciualty()
	{
		IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        System.out.println(specialtyservice.GetSpecialty().size());
	}
	
	@Test
	public void addspecialty()
	{
		IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        specialtyBean specialty = new specialtyBean("1","1","1",1,"1","1");
        System.out.println(specialtyservice.AddSpecialty(specialty));
	}
	
	@Test
	public void getobject()
	{
		IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);

        specialtyBean specialty = specialtyservice.getObject("4");
        if(specialty != null)
        {
            System.out.print(specialty.getFID()
                    +" "+specialty.getFname()
                    +" "+specialty.getFinfo()
                    +" "+specialty.getFother()
                    +" "+specialty.getFpicture()
                    +" "+specialty.getFother());
        }
	}
	
	@Test
	public void modspecialty()
	{
		IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        specialtyBean specialty = new specialtyBean("4","4","4",5,"4","4");
        int count = specialtyservice.ModSpecialty(specialty);
        System.out.print(count);
	}
	

	@Test
	public void delspecialty()
	{
		IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        specialtyBean specialty = new specialtyBean("4","4","4",4,"4","4");
        int count = specialtyservice.DelSpecialty(specialty);
        System.out.print(count);
	}
	
	
}
