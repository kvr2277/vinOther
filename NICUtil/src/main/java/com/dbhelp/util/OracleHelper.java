package com.dbhelp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Address;


public class OracleHelper {
	
	public List<Address> getAddress(String vendorId){
		Connection con = null;
		ResultSet rs = null;
		List<Address> addressList = new ArrayList<Address>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "vinoracle","password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String queryString = "select * from Address where address_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setInt(1, Integer.parseInt(vendorId));
			rs = ps.executeQuery();
			
			
			while(rs.next()){
				Address adr = new Address();
				adr.setAddressLine1(rs.getString("address_line_1"));
				adr.setAddressLine2(rs.getString("address_line_2"));
				adr.setCity(rs.getString("city"));
				adr.setState(rs.getString("state"));
				adr.setCountry(rs.getString("country"));
				adr.setZipcode(rs.getString("zipcode"));
				adr.setAddressId(rs.getInt("address_id"));
				
				System.out.println("Address String is : "+adr.toString());
				
				addressList.add(adr);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return addressList;
		
		
	}
	
	public static void main(String[] args){
		OracleHelper oh = new OracleHelper();
		oh.getAddress("001");
	}
}
