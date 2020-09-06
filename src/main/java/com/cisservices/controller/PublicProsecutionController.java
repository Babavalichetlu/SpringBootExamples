package com.cisservices.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisservices.model.PublicProsecutionModel;
import com.cisservices.service.PublicProsecutionServiceImpl;

@RestController

public class PublicProsecutionController {
private static final Logger logger = LoggerFactory.getLogger(PublicProsecutionController.class);
	
/*Map<String, List<PublicProsecutionModel> > map = new HashMap<String, List<PublicProsecutionModel> >(); 
public static final String deptName = "pp";*/
	@Autowired
	private PublicProsecutionServiceImpl pservice;
	
/*	//Reterive All data
	@RequestMapping(value = RestURIConstants.MYCASES_ALL, method = RequestMethod.GET)	
	public @ResponseBody List<PublicProsecutionModel> getAll() {		
		logger.info("*****Fetching getAllData");		
		return pservice.getData();	
	}*/
/*	//Get data By id
	@RequestMapping(value = RestURIConstants.GET_DATA_ID, method = RequestMethod.GET)
	public @ResponseBody PublicProsecutionModel getDataById(@PathVariable("id") int Id) {	
		logger.info("Start Get Data By ID="+Id);		
		return pservice.getDataById(Id);
	}
	*/
	//------------------------------------------------------------------------------------
	// working with   http://localhost:8083/rak/cis?dept=deptName
	//working with   http://localhost:8083/rak/cis?dept=deptName&&count=10
	@RequestMapping(value = "/rak/cis", method = RequestMethod.GET)		
	public @ResponseBody List<PublicProsecutionModel> getAllData(@RequestParam(name = "dept", required = false, defaultValue = "") String dept,
			                                                     @RequestParam(name = "id", required = false, defaultValue = "") String id,
			                                                     @RequestParam(name = "count", required = false, defaultValue = "10") Integer count) {
		System.out.println("*****Calling getAllData Method");
		//System.out.println("Start getEmployee. deptName="+deptName);
		//comparator method starts
		/*SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
		Comparator<PublicProsecutionModel> dateComparator = (PublicProsecutionModel obj1, PublicProsecutionModel obj2) ->{
				    			     try {
				    					Date d1 = sdformat.parse(obj1.getDate());
				    					Date d2 = sdformat.parse(obj2.getDate());
				    					 return d1.compareTo(d2);
				    				      } catch (ParseException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    					return 1;
				     
				    	        } 
				    	    };//comparator method ends 
				    	    
*/	     	
		//Collections.sort(pservice.getData());
		    return  pservice.getData()
	     			        .stream() 
				            .filter(e -> StringUtils.isEmpty(dept) || e.getDept().equalsIgnoreCase(dept))
				            .filter(e -> StringUtils.isEmpty(id) || String.valueOf(e.getId()).equalsIgnoreCase(id))
		                    .limit(count)
		                    .collect(Collectors.toList());
		   
			
		}
	
	//Not working with   http://localhost:8083/rak/cis?dept=pp
	//@RequestMapping(params ="dept")
	/* public @ResponseBody List<PublicProsecutionModel> getAllData(@RequestParam("dept") String deptName,Model map) {
		System.out.println("*****Calling getAllData Method");
		System.out.println("Start getEmployee. deptName="+deptName);
		return  pservice.getData();
			
		}*/
	
	//http://localhost:8083/rak/cis?Dept=PP&&Id=1234
	//Get data By id
	//@RequestMapping(value = RestURIConstants.GET_DATA_ID, method = RequestMethod.GET)
/*	@RequestMapping(params ="dept")
	public @ResponseBody PublicProsecutionModel getDataById(@RequestParam("id") int Id) {	
		logger.info("********Start Get Data By ID="+Id);
		
		return pservice.getDataById(Id);
	}*/
	//http://localhost:8083/rak/cis?Dept=PP&&Count=3
	
	
	
	
	
	
}
