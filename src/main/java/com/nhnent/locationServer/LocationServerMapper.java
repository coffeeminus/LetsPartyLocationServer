package com.nhnent.locationServer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LocationServerMapper{
	
	@Select("SELECT count(*) FROM location_map WHERE PARTY_ID=#{partyId}")
	int findPartyId(@Param("partyId") int partyId);
	   
	@Select("SELECT server_name FROM location_map WHERE PARTY_ID=#{partyId}")
	String getServerName(@Param("partyId") int partyId);
}
