package com.cisservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cisservices.model.PublicProsecutionModel;

@Component
public class PublicProsecutionServiceImpl implements PublicProsecution  {
	private static List<PublicProsecutionModel> serviceData = new ArrayList<>();	
	static {
		PublicProsecutionModel pp1= new PublicProsecutionModel(12345,"Request for commercial general waste pickup","22/02/2020","Completed","PP");
		PublicProsecutionModel pp2= new PublicProsecutionModel(23456,"Cancellation of commercial license","14/01/1999","Rejected","CC");
		PublicProsecutionModel pp3= new PublicProsecutionModel(34567,"Request for commercial Electricity Bill","02/04/2020","Closed","MU");
		PublicProsecutionModel pp4= new PublicProsecutionModel(45678,"Request for Municipality for water tanker","28/09/2020","In Progress","PP");
		PublicProsecutionModel pp5= new PublicProsecutionModel(56789,"Request for re-instatement for Phone ","28/02/1998","Closed","CC");
		PublicProsecutionModel pp6= new PublicProsecutionModel(11111,"Request for commercial general waste pickup","22/02/2020","Completed","PP");
		PublicProsecutionModel pp7= new PublicProsecutionModel(22222,"Cancellation of commercial license","14/01/2020","Rejected","CC");
		PublicProsecutionModel pp8= new PublicProsecutionModel(3333,"Request for commercial Electricity Bill","02/04/2020","Closed","MU");
		PublicProsecutionModel pp9= new PublicProsecutionModel(4444,"Request for Municipality for water tanker","28/06/2020","In Progress","PP");
		PublicProsecutionModel pp10= new PublicProsecutionModel(55555,"Request for re-instatement for Phone ","28/02/2020","Closed","CC");
		serviceData.add(pp1);
		serviceData.add(pp2);
		serviceData.add(pp3);
		serviceData.add(pp4);
		serviceData.add(pp5);
		serviceData.add(pp6);
		serviceData.add(pp7);
		serviceData.add(pp8);
		serviceData.add(pp9);
		serviceData.add(pp10);
		
	}
	
	@Override
	public List<PublicProsecutionModel> getData() {		
		return serviceData;
	}

	@Override
	public PublicProsecutionModel getDataById(int id) {		
		Optional<PublicProsecutionModel> cid= serviceData.stream().filter(a -> a.getId()==id).findFirst();
		return cid.isPresent() ? cid.get() : null;
	
	}

	@Override
	public List<PublicProsecutionModel> getData(String deptname) {		
		return serviceData;
	}

	

	


}
