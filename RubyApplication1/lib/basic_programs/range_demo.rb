# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

(1..5).each do |n|
  print n,' '
end

puts ''

(1...5).each do |n|
  print n,' '
end

(1..5).each do |n|
  (1...n).each do |m|
    print m,' '
  end
  puts ''
end

(5..1).each do |n|
  (n-1..1).each do |m|
    print m,' '
  end
  puts ''
end