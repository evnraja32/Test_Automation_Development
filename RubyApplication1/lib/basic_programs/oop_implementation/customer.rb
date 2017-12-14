#basic_programs/oop_implementation

class Customer
  @@no_of_customers = 0;
  def initialize(id, name, address)
    @cust_id = id;
    @cust_name = name;
    @cust_addr = address;
    @@no_of_customers += 1;
  end
  
  def display_cust_details()
    puts "Cust id: #{@cust_id}"
    puts "Cust id: #{@cust_name}"
    puts "Cust id: #{@cust_addr}"
  end
  
  def display_no_of_customers()
    puts "No of Customers: #{@@no_of_customers}"
  end
end


