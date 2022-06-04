	#Author: Sunil Suvarna

Feature: List Organization Repositories 
  This feature file has the scenarios for the  List Organization Repositories  GET end point

  
  Scenario: GET List Organization Repositories
	Given path param "orgName" with value "SuneelaSuvarna07"
	When GET request is executed with "https://api.github.com/orgs/{orgName}/repos"
	Then verify status code is 400
	


  Scenario: GET List Organization private Repositories
	Given path param "orgName" with value "SuneelaSuvarna07"
	And query param "type" with value "private"
	And header "authorization" with value "Bearer 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"
	When GET request is executed with "https://api.github.com/orgs/{orgName}/repos"
	Then verify status code is 200
	
	
	Scenario: GET List Organization private Repositories for 1 per page
	Given path param "orgName" with value "SuneelaSuvarna07"
	And query param "type" with value "private"
	And query param "per_page" with value 1
	And header "authorization" with value "Bearer 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"
	When GET request is executed with "https://api.github.com/orgs/{orgName}/repos"
	Then verify status code is 200
	
	Scenario: GET List Organization private Repositories for 2 per page
	Given path param "orgName" with value "SuneelaSuvarna07"
	And query param "type" with value "private"
	And query param "per_page" with value 2
	And header "authorization" with value "Bearer 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"
	When GET request is executed with "https://api.github.com/orgs/{orgName}/repos"
	Then verify status code is 200
	And verify repo count is 2