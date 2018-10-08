Feature: Get temprature by CITYID
  
  Scenario: User calls web service to get a temprature by its CITYID
		Given a CityId exists with an id of 2643743
		When a user retrieves the temprature by id
		Then the status code for res  200
		And response of city includes the following in any order
		| sys.country					| GB			|
		
  Scenario: User calls web service to get a temprature by its CITYID
		Given a CityId exists with an id of 264374000
		When a user retrieves the temprature by id
		Then the status code for res  404
		
	Scenario: User calls web service to get a temprature by its CITYID
		Given a CityId exists with an id of 264374000000000000000
		When a user retrieves the temprature by id
		Then the status code for res  400
		
		
	