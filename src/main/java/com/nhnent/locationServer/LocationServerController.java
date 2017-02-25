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
	
	/*
	 * 파티를 저장할때 어느 서버에 저장하는지 결정하는 메소드
	 * 파티 생성 시 사용 
	 */
	@RequestMapping(value = "/selectServer", method = RequestMethod.GET)
	public @ResponseBody String selectDatabase(int partyId){
		String ret = "";
		try {
			ret = lsService.selectServer(partyId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "all is good: " + ret; 
	}
	
	/*
	 * 요청받은 파티가 어느 서버에 있는지 알려주는 메소드
	 * 파티조회, 수정 시 사용 
	 */
	@RequestMapping(value="findServer", method = RequestMethod.GET)
	public @ResponseBody String findServer(int partyId){		
		return "find Server " + lsService.findServer(partyId);
	}
}
