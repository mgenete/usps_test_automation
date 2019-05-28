package com.base;

public class TestEnvironment {
	
	
	/*
	 * load settings about a 
	 * particular test environment including authentication info 
	 */
	
	private String servertUrl;
	private String url;
	private String testUser;
	private String testPassword;
	private String version;
	private String browser;
	private String proxyEnabled;
	
	
	
	public String getServertUrl() {
		return servertUrl;
	}

	public void setServertUrl(String servertUrl) {
		this.servertUrl = servertUrl;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTestUser() {
		return testUser;
	}
	public void setTestUser(String testUser) {
		this.testUser = testUser;
	}
	public String getTestPassword() {
		return testPassword;
	}
	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getProxyEnabled() {
		return proxyEnabled;
	}
	public void setProxyEnabled(String proxyEnabled) {
		this.proxyEnabled = proxyEnabled;
	}

	
	
}
