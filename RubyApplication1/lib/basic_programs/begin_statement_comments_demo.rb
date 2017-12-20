#BEGIN Declares code to be called before the program is run.

#Multiple comments Demo:

=begin
This BEGIN block is similar to the TestNG's @BeforeMethod and
similar to static block in java.

This BEGIN block will be executed first before the execution 
of actual code

=end

#Trailing Comments:

puts "In main Ruby Program";

BEGIN {
  puts "Initializing Ruby Program"
}