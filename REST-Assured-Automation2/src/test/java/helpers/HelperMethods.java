package helpers;

import Utils.RestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HelperMethods {
	public static String path;

	// set the search query for get as param and all as value
	public static void setSearchQuery(String action, String actionValue) {
		path = action + "/" + actionValue;
	}

	public static void setSearchQuery(String isoCode) {
		path = path + "/" + isoCode;
	}

	public static String getSearchPath() {
		return path;
	}

	public static String getMessage(Response res) {
		JsonPath response = RestUtils.getJsonPath(res);
		return response.get("RestResponse.messages[0]");
	}
}
