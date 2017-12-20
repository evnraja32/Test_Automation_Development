=begin
END Block is the something that executes at last.
This is similar to the @AfterMethod in TestNG.
=end

END{
  
  print <<EOF
  
Here multiple lines string will be printed first.
This call comes from the END 23 Block.
EOF
  
}

puts "\nAfter completion of BEGIN block, here comes this line. "+
  "next END block will be executed\n"



BEGIN{
  
  print <<EOF
  
Here multiple lines string will be printed first.
This call comes from the BEGIN Block.
EOF
  
}

END{
  
  print <<EOF
  
Here multiple lines string will be printed first.
This call comes from the END Block.
EOF
  
}



END{
  
  print <<EOF
  
Here multiple lines string will be printed first.
This call comes from the END 2 Block.
EOF
  
}