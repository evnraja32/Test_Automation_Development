class A
  
  attr_reader :rw
  attr_accessor :rwd
  def display
    puts "hello calling from class >> display()"
  end
end

puts A.new.rw
A.new.rwd = "alfjaf"
puts A.new.rwd