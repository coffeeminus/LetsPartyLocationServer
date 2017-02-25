package com.nhnent.locationServer;

import org.springframework.stereotype.Service;

@Service
public class LocationServerService {
	private static final int NUM_DATABASE = 2;
	private final LocationServerMapper locationServerMapper;
	
	public LocationServerService(LocationServerMapper locationServerMapper){
		this.locationServerMapper = locationServerMapper;
	}
	
	public String selectServer(int partyId){
		String serverName = "";
		//check if this party is already mapped 
		if(!isMapped(partyId)){ //no mapping
			serverName = getServerName(partyId);
		}else{
			serverName = locationServerMapper.getServerName(partyId);
		}
		return serverName;
	}
	
	private boolean isMapped(int partyId){ 
		//0 - no mapping
		//1 - yes
		//1 or higher - something is not right :(
		int numParty = locationServerMapper.findPartyId(partyId);
		
		if(numParty == 0 || numParty > 1){ //TODO: do something about numParty > 1
			return false;
		}else {
			return true;
		}		
	}
	
	private String getServerName(int partyId){
		if(partyId % NUM_DATABASE == 0){
			return DataServerName.TCRLPMDB01A901.getDataServerName();
		}
		return DataServerName.TCRLPMDB01A902.getDataServerName();
	}
}
