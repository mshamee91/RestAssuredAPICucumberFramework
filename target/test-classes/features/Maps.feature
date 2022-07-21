@All
Feature: Verify Maps API

@smoke @AddPlace @Regression
Scenario Outline: verify Add Place API
Given Add Place API with "<name>" and "<address>"
When user calls "AddPlace" API with "POST" http request
Then user gets response with status code as 200
And response shows "status" as "OK"
And response shows "scope" as "APP"
Examples:
|name				| address 									|
|API house	| 306, side layout, cohen 09|

@GetPlace @Regression
Scenario Outline: verify get place api
Given Get Place API
When user calls "GetPlace" API with "GET" http request
Then user gets response with status code as 200
And response shows "address" as "<address>"
Examples:
|address 									 |
|306, side layout, cohen 09|

@DeletePlace @Regression
Scenario: verify delete place api
Given Delete Place API
When user calls "DeletePlace" API with "POST" http request
Then user gets response with status code as 200
And response shows "status" as "OK"
