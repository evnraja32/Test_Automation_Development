# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require 'watir'

driver = Watir::IE.start("http://www.google.com");

puts driver.get_title()

driver.close