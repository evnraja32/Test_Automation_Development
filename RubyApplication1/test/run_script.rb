# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative '../lib/basic_programs/oop_implementation/customer.rb'

cust1 = Customer.new(1, "Raja", "address");

cust1.display_cust_details;
cust1.display_no_of_customers;

cust2 = Customer.new(2, "EVN", "address");

cust1.display_cust_details;
cust1.display_no_of_customers;

cust2.display_cust_details;
cust2.display_no_of_customers;