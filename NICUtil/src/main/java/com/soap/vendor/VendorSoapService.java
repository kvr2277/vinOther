package com.soap.vendor;
 
public class VendorSoapService {
	
  public String vendorName(String vendorId) {
    String vendorName = "";
    if ("001".equals(vendorId)) {
    	vendorName = "Google India";
    } else if ("002".equals(vendorId)) {
    	vendorName = "Google US";
    } else {
    	vendorName = "Amazon !";
    }
    return vendorName;
  }
}