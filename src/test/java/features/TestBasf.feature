Feature: Automate BASF Digital Solutions

Scenario Outline: Test wrod is present in text
	Given User is in loginPage  
	Then I login with user "eduardogonzalezsanchez@gmail.com" and pwd "Lafragua2.0"
	Then i click on login button
	Given I see a message with title "QKnows Terms of Use"
	And I click on optional checkbox
	And I click on required checkbox
	And I click on Proceed to QKnows button
	Then Home Page with title "QKnows" is shown
	When I send text <word> in search area
	And I click on search button
	Then the top 3 results contains the word <word>
	
	Examples:
	|word	  |
	|water	  |
	|propylen |
	|pertonhge|
	
