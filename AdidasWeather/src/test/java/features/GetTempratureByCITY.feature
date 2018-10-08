Feature: Get temprature by CITY NAME
  
  Scenario: User calls web service to get a temprature by its CITY
		Given a City exists with an name of bangalore
		When a user retrieves the temprature by name
		Then the status code  200
		And response includes the following in any order
		| sys.country					| IN			|
		
	Scenario: User calls web service to get a temprature by its Wrong CITY
		Given a City exists with an name of hbhalli
		When a user retrieves the temprature by name
		Then the status code  404
		
		
	
		
	