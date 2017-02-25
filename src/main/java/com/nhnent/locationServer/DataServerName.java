package com.nhnent.locationServer;

public enum DataServerName{ 

	TCRLPMDB01A901("tcrlpmdb-01a901"),
	TCRLPMDB01A902("tcrlpmdb-01a902");

	private String DataServerName;

	DataServerName(String DataServerName ){
		this.DataServerName = DataServerName;
	}

	public String getDataServerName() {
		return DataServerName;
	}

	public void setDataServerName(String DataServerName) {
		this.DataServerName = DataServerName;
	}
}
/*
	 HOW TO USE!

	 ReturnStatus rs = ReturnStatus.SUCCESS;
	 String temp = rs.getStatusMessage();
 */
