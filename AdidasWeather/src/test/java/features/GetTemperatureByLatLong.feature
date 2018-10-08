Feature: Get temprature by LatLong
  
  Scenario: User calls web service to get a temprature by its LatLong
		Given a LatLong exists with an lat of 35 and long of 139
		When a user retrieves the temprature by LatLong
		Then the status code for LatLong  200
		And response of latlong includes the following in any order
		| sys.country					| JP			|
		
   Scenario: User calls web service to get a temprature by its LatLong
		Given a LatLong exists with an lat of 50000000000 and long of 500000000000
		When a user retrieves the temprature by LatLong
		Then the status code for LatLong  400
		
		
	
		
	