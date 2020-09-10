/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tad.framework.core_lib;

/**
 *
 * @author ELLURV
 */
public class WebApp {

	private static final WebApp webAppInstance = new WebApp();

	private WebApp() {
		// load WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		
		// resources path is required
		// object resuources must be pulled from here
	}

	public static WebApp getInstance() {
		return webAppInstance;
	}

	public static void launchApp(String browser) {

	}

}
