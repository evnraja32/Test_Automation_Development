/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tad.framework.new_tours.pages;

import com.tad.framework.core_lib.WebApp;

/**
 *
 * @author ELLURV
 */
public class NewTours{

	public static WebApp webApp = null;

	public NewTours(String browser) {
		webApp = WebApp.getInstance();
		webApp.launchApp(browser);
	}

	public LoginPage login_page() {
		return new LoginPage(webApp);
	}
}
