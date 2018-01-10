# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require 'watir'

driver = Watir::IE.start("http://www.google.com");

puts driver.get_title()

driver.close
#=======
require 'selenium-webdriver'

# copy IEDriverServer.exe to the test script directory
ie_path = File.join(File.dirname(__FILE__)+"\\drivers", "IEDriverServer.exe")
Selenium::WebDriver::IE.driver_path = ie_path
driver = Selenium::WebDriver.for(:ie)
driver.navigate.to "http://www.google.com"
element = driver.find_element(:name, 'q')
element.send_keys "Hello Selenium WebDriver!"
element.submit

puts driver.title
