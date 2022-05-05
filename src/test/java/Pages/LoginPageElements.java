package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class LoginPageElements extends BaseClass {
	 @FindBy(id="txtUsername")
	    public WebElement usernameField;

	    @FindBy(id="txtPassword")
	    public WebElement passwordField;

	    @FindBy(id="btnLogin")
	    public WebElement loginBtn;

	    @FindBy(id="spanMessage")
	    public WebElement errorMessage;


	   public LoginPageElements(){
	       PageFactory.initElements(driver, this);
	    }
}
