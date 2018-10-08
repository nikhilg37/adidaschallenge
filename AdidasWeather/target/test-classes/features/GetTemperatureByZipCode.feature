Feature: Get temprature by ZipCode
  
  Scenario: User calls web service to get a temprature by its ZipCode
		Given a ZipCode exists with an id of 94040
		When a user retrieves the temprature by ZipCode
		Then the status code for zip  200
		And response of zipcode includes the following in any order
		| sys.country					| US			|
		
  Scenario: User calls web service to get a temprature by its ZipCode
		Given a ZipCode exists with an id of 9404000
		When a user retrieves the temprature by ZipCode
		Then the status code for zip  404
		
	
		
	
		
	