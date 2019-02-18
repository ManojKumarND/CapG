package com.insurance.claim;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewClaim extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		RequestDispatcher rd=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String str=null;
		
		try {
			con=Connect.getconnect();
			
			String reason=request.getParameter("reason");
			 String location=request.getParameter("location");
			 String city=request.getParameter("city");
			 String state=request.getParameter("state");
			 int zip=Integer.parseInt(request.getParameter("zip"));
			 String type=request.getParameter("type");
			
			 String sql="insert into Claim values(claimnumber_seq.nextval,?,?,?,?,?,?,policynumber_seq.nextval)";
			 //policynumber_seq.nextval
			 pst=con.prepareStatement(sql);
				pst.setString(1,reason);
				pst.setString(2,location);
				pst.setString(3,city);
				pst.setString(4,state);
				pst.setInt(5,zip);
				pst.setString(6,type);
				
				rs=pst.executeQuery();
				//int num=pst.executeQuery();
				System.out.println("added the claim details");
			
		}
		catch (Exception e)
		{ System.out.println(e);}
		
		
	}
	
}







/*   create table Claim(Claim_Number number(10) primary key,
 * Clain_Reason varchar(30),Accident_Location varchar(40),
 * Accident_City varchar(15),Accident_State varchar(15),
 * Accident_Zip number(5),Claim_Type varchar(30),
 * Policy_Number number(10));*/
 