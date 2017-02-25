package com.nhnent.locationServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LocationServerController {

	@Autowired
	private LocationServerService lsService;
	
	@RequestMapping(value = "/databaseSelector", method = RequestMethod.GET)
	public @ResponseBody String selectDatabase(int partyId){
		String ret = "";
		try {
			ret = lsService.selectServer(partyId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "all is good: " + ret; 
	}
}
