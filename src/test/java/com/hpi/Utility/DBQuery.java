package com.hpi.Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DBQuery {
	Connection con;
	Statement stmt;
	ResultSet resultset;
	String caseId;
	

	
/*	public String getCaseID(String randomtitle, String randomdescription) throws ClassNotFoundException, SQLException
	{	
		String query = "select caseId from enablementservice.case where title='"+randomtitle+"' and problemDescription='"+randomdescription+"';";
		System.out.println("executing the query" + query);
		DatabaseReader dbconnection = new DatabaseReader();
		con = dbconnection.getConnection();
		stmt = con.createStatement();
		do
		{
			resultset = stmt.executeQuery(query);
			 while(resultset.next())
			 {
				 caseId= resultset.getString("caseId");
			 }
		}while(caseId==null);
		return caseId;
	}*/
	
	public String getnewCaseID(String randomtitle, String randomdescription,ExtentTest logger) throws ClassNotFoundException, SQLException, Throwable
	{	
		String query = "select caseId from enablementservice.case where title='"+randomtitle+"' and problemDescription='"+randomdescription+"';";
		System.out.println("executing the query" + query);
		DatabaseReader dbconnection = new DatabaseReader();
		con = dbconnection.getConnection();
		stmt = con.createStatement();
		int count = 1;
		int maxretrycount = 10;
		do
		{
			 resultset = stmt.executeQuery(query);
			 count++;
			 while(resultset.next())
			 {
				 caseId= resultset.getString("caseId");
				 if(count==maxretrycount)
				 {
					 logger.log(LogStatus.FAIL, "Unable to get Case Id withing 10 min");
					 Assert.fail("Unable to get Case Id withing 10 min");
				 }
			 }
			 Thread.sleep(60000);
		}while(caseId==null);
		return caseId;
	}
	
	
	/*public static void main(String[] args) throws Throwable, SQLException{
		DBQuery db = new DBQuery();
		System.out.println(db.getCaseID("test21","test22"));
	}*/
}
