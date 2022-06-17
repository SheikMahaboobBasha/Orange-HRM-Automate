package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.DashBoard_Page_Object;
import pageObjects.Login_Page_Object;

public class Test_Pending_Leave_Request extends CommonFunctions {

	@Test
	public void verifyPendingLeaveRequest() {
		PageFactory.initElements(driver,Login_Page_Object.class );
		Login_Page_Object.UserName.sendKeys(properties.getProperty("username"));
		Login_Page_Object.password.sendKeys(properties.getProperty("password"));
		Login_Page_Object.SubmitButton.click();
		
		PageFactory.initElements(driver,DashBoard_Page_Object.class );
		
		String actualMessage = DashBoard_Page_Object.pendingLeaveRequest.getText();
		Assert.assertEquals(actualMessage, "No Records are Available");
		
		
	}
	
	
	
	
	
	
	
}
