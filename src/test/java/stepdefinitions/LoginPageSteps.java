package stepdefinitions;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    private static String title;


    @Given("user is on Login Page")
    public void userIsOnLoginPage() {
        DriverFactory.getDriver().get("https://www.airmeet.com/signup");
    }

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        title = loginPage.getLogInPageTitle();
        System.out.println("The Title of LogIn Page is : "+title);
    }

    @Then("the title of the page should be {string}")
    public void theTitleOfThePageShouldBe(String expectedTitle) {

        Assert.assertTrue(title.contains(expectedTitle));// true if title = expectedTitle

    }

    @Then("Privacy Policy link should be displayed")
    public void privacyPolicyLinkShouldBeDisplayed() {

        Assert.assertTrue(loginPage.isPrivacyPolicyLinkExists());

    }

    @When("user enters email Id {string}")
    public void userEntersEmailId(String emailId) {

        loginPage.enterUserName(emailId);
    }

    @And("user click on Continue button")
    public void userClickOnContinueButton() {

        loginPage.clickContinueButton();
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

//    @And("page title should be {string}")
//    public void pageTitleShouldBe(String arg0) {
//    }

    @Then("Forgot Password link should be displayed")
    public void forgotPasswordLinkShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkExists());
    }
}
