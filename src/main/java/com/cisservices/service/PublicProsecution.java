package com.cisservices.service;

import java.util.List;

import com.cisservices.model.PublicProsecutionModel;

public interface PublicProsecution {
	public abstract List<PublicProsecutionModel> getData();
	public abstract PublicProsecutionModel getDataById(int id);
	public abstract List<PublicProsecutionModel> getData(String deptname );
}
