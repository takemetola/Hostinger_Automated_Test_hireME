package pom.tests.hostinger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.hostinger.LoginPage;
import pom.pages.hostinger.UpdateProfileNamePage;
import pom.tests.TestBase;

public class UpdateProfileNameTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        UpdateProfileNamePage.openUrl("https://www.hostinger.com");
        LoginPage.clickCookiesDecline();

        String email = "desire2work4hostinger@gmail.com";
        String password = "Testas123!";

        UpdateProfileNamePage.clickOnButtonLogin();
        UpdateProfileNamePage.inputEmail(email);
        UpdateProfileNamePage.inoutPassword(password);
        UpdateProfileNamePage.clickOnButtonLoginAccount();
    }
    @Test
    public void testUpdateProfileInfo() throws InterruptedException {

        String password = "Testas123!";
        String firstName = "John";
        String lastName = "Wick";

        UpdateProfileNamePage.clickOnAccountIcon();
        UpdateProfileNamePage.clickonAccountInfomation();
        UpdateProfileNamePage.clickonNameGroup();
        UpdateProfileNamePage.addTextFirstName(firstName);
        UpdateProfileNamePage.addTextLastName(lastName);
        UpdateProfileNamePage.clickOnButtonContinue();
        UpdateProfileNamePage.addTextConfirmPassword(password);
        UpdateProfileNamePage.clickOnConfirmButton();

        String expectedResult = "John Wick";
        String actualResult;
        actualResult = UpdateProfileNamePage.readTextFullName();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
