package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import helpers.HelperMethods;

public class RestUtils {

	public static void setBaseURI(String baseURI) {
		LoggerUtils.debug("Setting base URI : " + baseURI);
		RestAssured.baseURI = baseURI;
	}

	public static void setBasePath(String basePath) {
		LoggerUtils.debug("Setting base path : " + basePath);
		RestAssured.basePath = basePath;
	}

	public static void setContentType(ContentType json) {
		LoggerUtils.debug("Setting content type : " + json);
		given().contentType(json);
	}

	public static Response getResponse() {
		LoggerUtils.debug("Request Path : " + HelperMethods.getSearchPath());
		LoggerUtils.debug("Response : " + get(HelperMethods.getSearchPath()));
		return get(HelperMethods.getSearchPath());
	}

	public static JsonPath getJsonPath(Response res) {
		String json = res.asString();
		return new JsonPath(json);
	}

	public static void resetBaseURI() {
		setBaseURI(null);
	}

	public static void resetBasePath() {
		setBasePath(null);
	}
}
