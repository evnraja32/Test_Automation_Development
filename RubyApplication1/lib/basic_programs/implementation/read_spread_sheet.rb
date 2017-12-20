# Read and write spreadsheets with ruby using the spreadsheet gem
# Full Docs: http://spreadsheet.rubyforge.org/GUIDE_txt.html

require 'spreadsheet'

# Open data spreadsheet
workbook = Spreadsheet.open 'data.xls'

# READ

# Specify a single worksheet by index
sheet1 = workbook.worksheet 0
sheet1.each do |row|
  puts "#{row[0]} - #{row[1]} - #{row[2]}"
end

# Specify a single worksheet by name
sheet2 = workbook.worksheet 'Sheet1'
sheet2.each do |row|
  puts "#{row[0]} - #{row[1]} - #{row[2]}"
end

# Loop over each worksheet
workbook.worksheets.each do |sheet|
  sheet.each do |row|
    puts "#{sheet.name} --> #{row[0]} - #{row[1]} - #{row[2]}"
  end
end

# WRITE

# Modify each worksheet (in memory)
workbook.worksheets.each do |sheet|
  sheet.each do |row|
    row[0] = 'foo'
    row[1] = 'bar'
  end
end

# Write (changes) to destination spreadsheet
workbook.write 'destination.xls'

