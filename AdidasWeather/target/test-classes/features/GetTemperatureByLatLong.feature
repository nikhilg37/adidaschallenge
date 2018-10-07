Feature: Get temprature by Lat Long
Scenario: User calls web service to get a temprature by its LAT and LONG 
		  Given a City exists with an lat of lat and long of long
		  When a user retrieves the temprature by name
		  Then the status code  200