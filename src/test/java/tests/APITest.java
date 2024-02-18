package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chiacon.utility.ApiUtility;

import baseTest.BaseTest;
import io.restassured.response.Response;

public class APITest extends BaseTest {

	@Test(priority = 1)
	public void testCreateRepository() {
		Response response = ApiUtility.createRepository();
		int statusCode = response.getStatusCode();
		String repositoryName = ApiUtility.getRepositoryName(response);
		Assert.assertEquals(statusCode, 201, "Failed to create repository. Status code is not as expected.");
		Assert.assertNotNull(repositoryName, "Repository name is null.");
	}

	@Test(priority = 2)
	public void testGetUserRepositories() {
		Response response = ApiUtility.getRepositories();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Failed to get user repositories. Status code is not as expected.");
	}

	@Test(priority = 3)
	public void testUpdateRepository() {
		Response response = ApiUtility.updateRepository();
		int statusCode = response.getStatusCode();
		String repositoryName = ApiUtility.getRepositoryName(response);
		Assert.assertEquals(statusCode, 200, "Failed to update repository. Status code is not as expected.");
		Assert.assertNotNull(repositoryName, "Repository name is null.");
	}

	@Test(priority = 4)
	public void testDeleteRepository() {
		Response response = ApiUtility.deleteRepository();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 204, "Failed to delete repository. Status code is not as expected.");
	}
}
