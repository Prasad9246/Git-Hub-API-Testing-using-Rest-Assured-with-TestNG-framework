package com.chiacon.utility;

public class APIEndpoints {

	public static String postUserReposEndpoint() {
		return "/user/repos";
	}

	public static String getUserReposEndpoint(String userId, String repositoryName) {
		return "/repos/" + userId + "/"+repositoryName;
	}

	public static String patchUserRepoEndpoint(String userId, String repositoryName) {
		return "/repos/" + userId + "/" + repositoryName;
	}

	public static String deleteUserRepoEndpoint(String userId, String updatedName) {
		return "/repos/" + userId + "/" + updatedName;
	}

}
