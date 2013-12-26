package com.soap.vendor;

import java.util.List;

import com.dbhelp.util.OracleHelper;
import com.model.Address;

public class VendorAddressService {
	
	public Address getVendorAddress(String vendorId){
		
		OracleHelper oh = new OracleHelper();
		List<Address> addrList = oh.getAddress(vendorId);
		
		Address adr = addrList.get(0);
		
		return adr;
	}

}
