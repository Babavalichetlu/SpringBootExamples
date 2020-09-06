package com.cisservices.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.cisservices.config.RestURIConstants;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;

@JsonPropertyOrder({RestURIConstants.ID, RestURIConstants.NAME,RestURIConstants.CREATED_DATE, RestURIConstants.STATUS })

public class PublicProsecutionModel implements Comparable{	
	private int id;
	private String name;	
	private String date;
	private String status;
	private String dept;

	
	public PublicProsecutionModel(int id, String name, String date, String status,String dept) {	
		this.id = id;
		this.name = name;
		this.date = date;
		this.status = status;
		this.dept = dept;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
	    return MoreObjects.toStringHelper(this)
	            .add("Id", id)
	            .add("Name", name)
	            .add("Date", date)
	            .add("Status", status)
	            .add("Dept", dept)
	            .toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublicProsecutionModel other = (PublicProsecutionModel) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else {
			SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
	      
		try {
			Date d1 = sdformat.parse(this.date);
			Date d2 = sdformat.parse(other.date);
		
			 if(d1.compareTo(d2) > 0) {
				 System.out.println("Date 1 occurs after Date 2");
				 System.out.println("Date 1 --"+this.date);
				 System.out.println("Date 2 --"+other.date);
				 return false;
		         
		      } else if(d1.compareTo(d2) < 0) {
		         System.out.println("Date 1 occurs before Date 2");
		         System.out.println("Date 1 --"+this.date);
				 System.out.println("Date 2 --"+other.date);
		         return false;
		      } else if(d1.compareTo(d2) == 0) {
		         System.out.println("Both dates are equal");
		         return true;
		      }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		}
	     
	
		return false;
	}

	SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return 1;
		if (getClass() != obj.getClass())
			return 1;
		PublicProsecutionModel other = (PublicProsecutionModel) obj;
		if (date == null) {
			if (other.date != null)
				return 1;
		}
		try {
			Date d1 = sdformat.parse(this.date);
			Date d2 = sdformat.parse(other.date);
			return d1.compareTo(d2);
		
			 /*if(d1.compareTo(d2) > 0) {
				 System.out.println("Date 1 occurs after Date 2");
				 System.out.println("Date 1 --"+this.date);
				 System.out.println("Date 2 --"+other.date);
				 return 1;
		         
		      } else if(d1.compareTo(d2) < 0) {
		         System.out.println("Date 1 occurs before Date 2");
		         System.out.println("Date 1 --"+this.date);
				 System.out.println("Date 2 --"+other.date);
		         return -1;
		      } else if(d1.compareTo(d2) == 0) {
		         System.out.println("Both dates are equal");
		         return 0;
		      }*/
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}	

}
