Feature: User login page
Scenario: Successful user login
	Given User launches the application and lands into login page
	Then User enters username
	And User enters password
	And User press Login Button
	Then User should landed into Home page
