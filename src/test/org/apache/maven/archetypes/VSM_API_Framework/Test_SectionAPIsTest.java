package org.apache.maven.archetypes.VSM_API_Framework;

import static org.junit.Assert.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.maven.archetypes.VSM_API_Framework.Common.API;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Test_SectionAPIsTest extends Common{
	
	/*
	 ** UserName: ashish.khatri@synechron.com
	 *  Password: pass@123
	 */

	@Test
	public void TC01_VerifyLogin() throws Exception{
		try
		{
			logger.info("Test Execution Started- TC01_VerifyLogin");
			
			HttpPost request=new HttpPost(url+API.session);
	
			request.addHeader("content-type", "application/json");
					
			String strJson=inputJson("TeacherLoginTestRequest.json");
			
			StringEntity params =new StringEntity(strJson);
			request.setEntity(params);
			
			HttpResponse actualResponse = httpclient.execute(request, context);
					
			String strActualResponse = EntityUtils.toString(actualResponse.getEntity());
			
			Assert.assertTrue("Not valid json response", fnCompaireJsonResponse(strActualResponse,"TC01_Response_LoginForSections.json",true));
		}
		finally
		{
			logger.info("Test Execution End- TC01_VerifyLogin");
		}
	}
		
	
	@Test
	public void TC02_PostSections() throws Exception{
		try
		{
			logger.info("Test Execution Started- TC02_PostSections");
			
			HttpPost request=new HttpPost(url+API.sections);
	
			request.addHeader("content-type", "application/json");
					
			String strJson=inputJson("PostSectionRequest.json");
			
			StringEntity params =new StringEntity(strJson);
			request.setEntity(params);
			
			HttpResponse actualResponse = httpclient.execute(request, context);
					
			String strActualResponse = EntityUtils.toString(actualResponse.getEntity());
			
			Assert.assertTrue("Not valid json response", fnCompaireJsonResponse(strActualResponse,"TC02_Response_PostSections.json",true));
		}
		finally
		{
			logger.info("Test Execution End- TC02_PostSections");
		}
	}
	
	
	@Test
	public void TC03_GetSectionsClasscodes() throws Exception{
		try
		{
			logger.info("Test Execution Started- TC03_GetSectionsClasscodes");
			
			HttpGet request=new HttpGet(url+API.sections+"/classcodes/"+"K16");
	
			request.addHeader("content-type", "application/json");
					
			HttpResponse actualResponse = httpclient.execute(request, context);
					
			String strActualResponse = EntityUtils.toString(actualResponse.getEntity());
			
			Assert.assertTrue("Not valid json response", fnCompaireJsonResponse(strActualResponse,"TC03_Response_GetSectionsClasscodes.json",true));
		}
		finally
		{
			logger.info("Test Execution End- TC03_GetSectionsClasscodes");
		}
	}
	
	
	
	@Test		
	public void TC04_TeacherLogout() throws Exception {	
		try
		{
			logger.info("Test Execution Started- TC03_TeacherLogout");
			
			HttpDelete request=new HttpDelete(url+API.session);
					
			request.addHeader("content-type", "application/json");
					
			HttpResponse actualResponse = httpclient.execute(request, context);
				
			String strActualResponse = EntityUtils.toString(actualResponse.getEntity());
			
			Assert.assertTrue("Logout_Response - Not valid json response", fnCompaireJsonResponse(strActualResponse,"Logout_Response.json",true));			
		}
		finally
		{
			logger.info("Test Execution End- TC03_TeacherLogout");
		}
	}
}
