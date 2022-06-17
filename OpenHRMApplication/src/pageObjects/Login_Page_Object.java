package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Object {

	@FindBy(id="txtUsername")
	public static WebElement UserName;

	@FindBy(id="txtPassword")
	public static WebElement password;

	@FindBy(id="btnLogin")
	public static WebElement SubmitButton;



}
