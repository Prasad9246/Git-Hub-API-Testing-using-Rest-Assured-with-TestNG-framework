package com.chiacon.utility;

import static com.chiacon.readProperties.ReadProperties.prop;

import com.chiacon.methodBody.MethodsBody;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reports.ExtentLoggerReport;

public class ApiUtility {
	
	 	private static final String USER_ID = prop.getProperty("USER_ID");
	    private static String repositoryName;
	    private static Response response;
	    private static RequestSpecification requestSpecification;

	    public static RequestSpecification getAuthorization() {
	        RestAssured.baseURI = prop.getProperty("BASE_URL");
	        return RestAssured
	                .given()
	                .log()
	                .all()
	                .contentType(ContentType.JSON)
	                .header("Authorization", "Bearer " + prop.getProperty("TOKEN"));
	    }

	    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
	    	QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
	        ExtentLoggerReport.logInfoDetails("EndPoint is " + queryableRequestSpecification.getBaseUri());
	        ExtentLoggerReport.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
	    }

	    private static void printResponseLogInReport(Response response) {
	        ExtentLoggerReport.logInfoDetails("Response Status is " + response.getStatusCode());
	        ExtentLoggerReport.logInfoDetails("Response Header is " + response.getHeaders().asList().toString());
	        ExtentLoggerReport.logInfoDetails("Response Body is " + response.getBody().asString());
	    }

	    private static Response sendPostRequest(String endpoint, String requestBody) {
	        requestSpecification = getAuthorization();
	        response = requestSpecification
	                .given()
	                .body(requestBody)
	                .post(endpoint)
	                .then()
	                .log()
	                .all()
	                .extract()
	                .response();
	        repositoryName =  getRepositoryName(response);
	        printRequestLogInReport(requestSpecification);
	        printResponseLogInReport(response);
	        return response;
	    }

	    private static Response sendGetRequest(String endpoint) {
	        requestSpecification = getAuthorization();
	        response = requestSpecification
	                .given()
	                .get(endpoint)
	                .then()
	                .log()
	                .all()
	                .extract()
	                .response();
	        printRequestLogInReport(requestSpecification);
	        printResponseLogInReport(response);
	        return response;
	    }

	    private static Response sendPatchRequest(String endpoint, String requestBody) {
	        requestSpecification = getAuthorization();
	        response = requestSpecification
	                .given()
	                .body(requestBody)
	                .patch(endpoint)
	                .then()
	                .log()
	                .all()
	                .extract()
	                .response();
	        repositoryName = getRepositoryName(response);
	        printRequestLogInReport(requestSpecification);
	        printResponseLogInReport(response);
	        return response;
	    }

	    private static Response sendDeleteRequest(String endpoint) {
	        requestSpecification = getAuthorization();
	        response = requestSpecification
	                .given()
	                .delete(endpoint)
	                .then()
	                .log()
	                .all()
	                .extract()
	                .response();
	        printRequestLogInReport(requestSpecification);
	        printResponseLogInReport(response);
	        return response;
	    }

	    public static Response createRepository() {
	        return sendPostRequest(APIEndpoints.postUserReposEndpoint(), MethodsBody.getPostBody());
	    }

	    public static Response getRepositories() {
	        return sendGetRequest(APIEndpoints.getUserReposEndpoint(USER_ID, repositoryName));
	    }

	    public static Response updateRepository() {
	        return sendPatchRequest(APIEndpoints.patchUserRepoEndpoint(USER_ID, repositoryName), MethodsBody.getPatchBody());
	    }

	    public static Response deleteRepository() {
	        return sendDeleteRequest(APIEndpoints.deleteUserRepoEndpoint(USER_ID, repositoryName));
	    }

	    public static String getRepositoryName(Response response) {
	        return response.jsonPath().getString("name");
	    }
}
