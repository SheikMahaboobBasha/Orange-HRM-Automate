package testCases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.User_Role_PageObject;

public class Test_User_Role extends CommonFunctions {
	@Test
	public void moveToUsersPage() {

		PageFactory.initElements(driver,  User_Role_PageObject.class);
		Actions Action = new Actions(driver);
		Action.moveToElement(User_Role_PageObject.adminLink);
		Action.moveToElement(User_Role_PageObject.userManagementLink);
		Action.moveToElement(User_Role_PageObject.usersLink);
		Action.click().build().perform();
	}

	@Test
	public void checkUserRole() {
		PageFactory.initElements(driver,  User_Role_PageObject.class);
		moveToUsersPage();
		selectUserRole();
		selectStaatus();
		User_Role_PageObject.Searchbutton.click();
		String Roletext = User_Role_PageObject.userRoleValue.getText();
		String Statustext = User_Role_PageObject.userStatusValue.getText();
		Assert.assertEquals(Roletext, "Admin");
		Assert.assertEquals(Statustext, "Enabled");

	}

	@Test
	public void selectUserRole() {
		Select select = new Select(User_Role_PageObject.userRole);
		select.selectByIndex(1);
	}

	@Test
	public void selectStaatus() {
		Select select = new Select(User_Role_PageObject.userStatus);
		select.selectByIndex(1);
	}











}
