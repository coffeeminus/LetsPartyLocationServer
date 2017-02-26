package com.nhnent.locationServer;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LocationMapper{
	
	@Select("SELECT server_name FROM location_map WHERE party_id=#{partyId}")
	String getServerName(@Param("partyId") int partyId);
	
	@Insert("INSERT INTO location_map (party_id, server_name) VALUES (#{partyId}, #{serverName})")
	int insertServerName(@Param("partyId") int partyId, @Param("serverName") String serverName);
}
