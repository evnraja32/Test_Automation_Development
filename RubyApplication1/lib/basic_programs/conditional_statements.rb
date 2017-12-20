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