@Regression 
Feature: Test the Restful services to get and search countries 

Background: 
	Given I reset the baseURI 
	Then I reset the basePath 
	
Scenario: Test the happy path for get all 

	Given I setup the request with baseURI "http://services.groupkt.com" 
	When I setup the request with basePath "country" 
	And I set the request with content type "JSON" 
	And I set the request with action "get" with its value as "all" 
	Then I get the response 
	And I validate response is successfull 
	
Scenario: Search country by 2 character alphanumeric ISO code 

	Given I setup the request with baseURI "http://services.groupkt.com" 
	When I setup the request with basePath "country" 
	And I set the request with content type "JSON" 
	And I set the request with action "get" with its value as "iso2code" 
	And I set the iso2Code as "IU" 
	Then I get the response 
	And I validate response is successfull 
	And I validate the error message is "No matching country found for requested code [IU]." 
	
Scenario: Search country by 3 character alphanumeric ISO code 

	Given I setup the request with baseURI "http://services.groupkt.com" 
	When I setup the request with basePath "country" 
	And I set the request with content type "JSON" 
	And I set the request with action "get" with its value as "iso3code" 
	And I set the iso3Code as "IND" 
	Then I get the response 
	And I validate response is not successfull 