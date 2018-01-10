# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

a = 2

#Simple if condition

if(a>2)
  puts 'a is greater'
else
  puts 'a is lesser'
end

#if... else... condition
b = 10

if (b>11)
  puts 'inside if condition'
elsif(b>14)
  puts 'inside 2nd if condition'
elsif(b>5)
  puts 'inside 3rd if condition'
else
  puts 'inside else and b value is comparetively less'
end

#unless... implementation
unless (b>11)
  puts 'inside unless and b is lesser'
else
  puts 'inside else and b is greater'
end

#switch statement
begin
  case b
  when 0 .. 2
    puts "baby"
  when 3 .. 6
    puts "little child"
  when 7 .. 12
    puts "child"
  when 13 .. 18
    puts "youth"
  else
    puts "adult"
  end
end

#unless... implementation
unless (b>11)
  puts 'inside unless anafafa d b is lesser'
else
  puts 'inside else aasdfafda nd b is greater'
end



(1..10).each do |n|
  puts n%2
  unless(n%2==0)
    puts n.to_s << " is a odd number"
  else
    puts n.to_s << " is a even number"
  end
  
  if(n%2==0)
    puts n.to_s << " is a odd number"
  else
    puts n.to_s << " is a even number"
  end
  
  if(n%2==0)
    puts n.to_s << " is a even number"
  else
    puts n.to_s << " is a odd number"
  end
  
end

@browser = nil
@ip = nil

unless((@browser.eql? nil)&&(@ip.eql? nil))
  puts 'In unless the condition ((@browser.eql? nil)&&(@ip.eql? nil)) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 1 executed'
else
  puts 'In unless the condition ((@browser.eql? nil)&&(@ip.eql? nil)) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 2 executed'
end

if((@browser.eql? nil)&&(@ip.eql? nil))
  puts 'In if the condition @browser.eql?(nil) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 1 executed'
else
  puts 'In if the condition @browser.eql?(nil) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 2 executed'
end

@ip = 'adfafa'
puts 'changing the @ip value to '+"#{@ip}"

unless((@browser.eql? nil)&&(@ip.eql? nil))
  puts 'In unless the condition ((@browser.eql? nil)&&(@ip.eql? nil)) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 1 executed'
else
  puts 'In unless the condition ((@browser.eql? nil)&&(@ip.eql? nil)) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 2 executed'
end

@ip = nil
puts 'changing the @ip value to '+"#{@ip}"

unless((@browser.eql? nil)&&(@ip.eql? nil))
  puts 'In unless the condition ((@browser.eql? nil)&&(@ip.eql? nil)) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 1 executed'
else
  puts 'In unless the condition ((@browser.eql? nil)&&(@ip.eql? nil)) becomes '+((@browser.eql? nil)&&(@ip.eql? nil)).to_s+'. So, block 2 executed'
end
