package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
public static String webURL = "https://rise.fairsketch.com/dashboard/view/1";	
public static By textEmail = By.id("email");
public static By textPassword = By.id("password");
public static By btnLogin = By.xpath("//button[@type='submit' and text()='Sign in']");
public static By TEXT_DASHBOARD = By.xpath("//span[text()='Dashboard']");
}
