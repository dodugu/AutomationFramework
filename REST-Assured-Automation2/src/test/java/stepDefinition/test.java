package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.testng.asserts.SoftAssert;

import Utils.RestUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class test {
	SoftAssert softAssert = new SoftAssert();
	public Response res = null;

	@Given("^I reset the baseURI$")
	public void resetBaseURI() {
		RestUtils.resetBaseURI();
	}

	@Given("^I reset the basePath$")
	public void resetBasePath() {
		RestUtils.resetBasePath();
	}

	@Given("^I setup the request with baseURI \"([^\"]*)\"$")
	public void setBaseURI(String baseURI) throws Exception {
		RestUtils.setBaseURI(baseURI);
	}

	@When("^I setup the request with basePath \"([^\"]*)\"$")
	public void setBasePath(String basePath) throws Exception {
		RestUtils.setBasePath(basePath);
	}

	@When("^I set the request with content type \"([^\"]*)\"$")
	public void setContentType(String contentType) throws Exception {
		if (contentType.equalsIgnoreCase("json")) {
			RestUtils.setContentType(ContentType.JSON);
		}
	}

	@When("I set the request with action \"([^\"]*)\" with its value as \"([^\"]*)\"$")
	public void setActionAndValue(String param, String value) throws Exception {
		HelperMethods.setSearchQuery(param, value);
	}

	@When("^I set the iso(\\d+)Code as \"([^\"]*)\"$")
	public void i_set_the_iso_Code_as(int arg1, String isoCode) throws Exception {
		HelperMethods.setSearchQuery(isoCode);
	}

	@Then("^I get the response$")
	public void getResponse() throws Exception {
		res = RestUtils.getResponse();
	}

	@Then("^I validate response is successfull$")
	public void checkResponseStatusIs200() {
		softAssert.assertEquals(200, res.getStatusCode(), "Status Check Failed!!!");
		softAssert.assertAll();
		// assertEquals("Status Check Failed!!!", res.getStatusCode(), 200);
	}

	@Then("^I validate response is not successfull$")
	public void checkResponseStatusIsNot200() {
		softAssert.assertNotEquals(200, res.getStatusCode(), "Status Check Passed - Supposed to be failed!!!");
		softAssert.assertAll();
		// assertNotEquals("Status Check Passed - Supposed to be failed!!!",
		// res.getStatusCode(), 200);
	}

	@Then("^I validate the error message is \"([^\"]*)\"$")
	public void validateErrorMessage(String errorMessage) {
		assertEquals("Status Check Passed - Supposed to be failed!!!", HelperMethods.getMessage(res), errorMessage);
	}

}
