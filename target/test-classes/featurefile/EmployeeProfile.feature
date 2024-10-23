
@tag
Feature: New HR App

 	@tag1
  Scenario Outline: Employee Add Manually only mandatory fields
    Given User will login the application
    When User will redirecting to EmployeeAddManually page 
    Then User starts filling all MandatoryFields in Primary Details section : "<Firstname>","<Lastname>","<Email>"
		And Navigate to EmployeeInfo Page and starts filling its Mandatory Fields : "<Additionalemail>"
    Then User fill all mandatory details of Wages section
    And Redirect to Absence page and starts filling all mandatory fields
    Then Navigate to Access and Document section to fill its mandatory fields
    Then user fill Assets and Qualification page mandatory fields section 
		And finally leads to Notes section and fill all details then employee profile created 
		
		
		 Examples: 
      | Firstname  | Lastname | Email														| Additionalemail  									|
      | name11		 |     last1| aditya.yaduwanshi2141@wenodo.com |aditya.yaduwanshi102141@wenodo.com	|
      | name22		 |     last2| aditya.yaduwanshi2151@wenodo.com |aditya.yaduwanshi102151@wenodo.com	|
      
      
      
#	@tag2
  #Scenario Outline: Title of your scenario outline
    #Then User starts filling all MandatoryFields in Primary Details section2
    #And Navigate to EmployeeInfo Page and starts filling its Mandatory Fields2
    #Then User fill all mandatory details of Wages section2
    #And Redirect to Absence page and starts filling all mandatory fields2
    #Then Navigate to Access and Document section to fill its mandatory fields2
    #Then user fill Assets and Qualification page mandatory fields section2
#		And finally leads to Notes section and fill all details then employee profile created2 


  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
