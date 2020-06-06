package com.hpi.Utility;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceCenterAPIUtility {
	
/*	public static String loginToPostman() throws IOException, JSONException
	{
		System.setProperty("jsse.enableSNIExtension", "false");
		URL url = new URL("https://www.printos.com/api/aaa/v4/users/login");
		HttpURLConnection huc =(HttpURLConnection)url.openConnection();
		HttpURLConnection.setFollowRedirects(false);
		huc.setRequestProperty("Content-Type", "application/json");
		huc.setRequestProperty("Accept", "application/json");
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("login", "komma-naga@hp.com");
		jsonobj.put("password", "bharathprintOS12$");
		huc.setRequestMethod("POST");
		huc.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(huc.getOutputStream());
		wr.writeBytes(jsonobj.toString());
		wr.flush();
		wr.close();

		huc.connect();
		int responseCode = huc.getResponseCode();
		String cookie = null;
		InputStream inputstream = null;
		String headerscookie = null;
		//String token_data = null;
		System.out.println("Response Code : " + responseCode);
		if(huc.getResponseCode()!= 200)
		{
			throw new RuntimeException("Failed : To login : " + huc.getResponseCode());
		}else{
			inputstream = huc.getInputStream();
			JSONObject json = null;
			BufferedReader rd = new BufferedReader(new InputStreamReader(inputstream, Charset.forName("UTF-8")));
			String jsonText = readAll(rd).toString();
			json = new JSONObject(jsonText);
			//System.out.println(json);
			headerscookie = huc.getHeaderFields().get("Set-Cookie").get(0);
			System.out.println(headerscookie);
			String token_data1 = headerscookie.substring(22, 48);
			System.out.println(token_data1);
		}
		
		inputstream.close();
		huc.disconnect();
		return headerscookie;
	}
	
	public static String getToken() throws Throwable, JSONException{
		String data = loginToPostman();
		String val= data.substring(22, 48);
		System.out.println(val);
		return val;
	}
	
	private static String readAll(BufferedReader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
	
	
	public void getcase_attachments() throws IOException, JSONException
	{
		System.setProperty("jsse.enableSNIExtension", "false");
		URL url = new URL("https://www.printos.com/api/enablement-service/v4/cases/caseAttachments?caseNumber=2064");
		HttpURLConnection huc =(HttpURLConnection)url.openConnection();
		HttpURLConnection.setFollowRedirects(false);
		huc.setRequestProperty("Content-Type", "application/json");
		huc.setRequestProperty("Accept", "application/json");
		huc.setRequestProperty("incomingChannel", "ETMsDgAAAWQX6gi4ABRBRVMvQ0JDL1BLQ1M1UGFkZGluZwCAABAAEMoQgTdOQFcKukdmCI8V3akAAAAgO9jzoMHvV3L785QcKFW6gFodTzR8uoRuQYBA5DQYjTIAFFGvcyNB/bmreUsaFCgGJ8c3d50J");
		huc.setRequestProperty("originator", "ETMsDgAAAWQX7yxsABRBRVMvQ0JDL1BLQ1M1UGFkZGluZwCAABAAENwlkBH7zzNgMY+y8f0095wAAAAwObAVKSgu9dYc53B2spTAjfCuu6OrnGjFKppMfPWzaLokVfRCynw2+zHpx8t05HvUABT0h21ETCDQUBQIhbXEoxLgYjt/0w==");
		JSONObject jsonobj = new JSONObject();
		huc.setRequestMethod("GET");
		huc.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(huc.getOutputStream());
		wr.writeBytes(jsonobj.toString());
		wr.flush();
		wr.close();

		huc.connect();
		int responseCode = huc.getResponseCode();
		InputStream inputstream = null;
		System.out.println("Response Code : " + responseCode);
		if(huc.getResponseCode()!= 200)
		{
			throw new RuntimeException("Failed : To login : " + huc.getResponseCode());
		}else{
			
			inputstream = huc.getInputStream();
			JSONObject json = null;
			BufferedReader rd = new BufferedReader(new InputStreamReader(inputstream, Charset.forName("UTF-8")));
			String jsonText = readAll(rd).toString();
			json = new JSONObject(jsonText);
			System.out.println(json);
		}
		
	}
	
	public static void main(String[] args) throws Throwable{
		//loginToPostman();
		getToken();
	}*/

}
