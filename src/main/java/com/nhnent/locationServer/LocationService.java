package com.nhnent.locationServer;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

	private static final int NUM_DATABASE = 2;
	private final LocationMapper locationServerMapper;

	public LocationService(LocationMapper locationServerMapper) {
		this.locationServerMapper = locationServerMapper;
	}

	public String returnLocationToBeSave(int partyId) {

		String serverName = shardingPolicy(partyId);
		locationServerMapper.insertServerName(partyId, serverName);

		return serverName;
	}

	public String returnLocationOfParty(int partyId) {

		return locationServerMapper.getServerName(partyId);
	}

	private String shardingPolicy(int partyId) {
		
		if (partyId % NUM_DATABASE == 0)
			return DataServerName.TCRLPMDB01A901.getDataServerName();
		return DataServerName.TCRLPMDB01A902.getDataServerName();
	}
}
