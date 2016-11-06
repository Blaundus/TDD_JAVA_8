Apple Factory tester

Narrative:
In order to test the sorting and date part of the application 
As a developer
I want to use generate 100 distributed apples
					 
Scenario:  Generate 100 Apples with 34 red apples
Given The initial 100 apples
When I count select the red Apples
Then I get 34 red apples
When I select the jonathan types 
Then I get 20 apples
When I select the redchief types
Then I get 14 apples
When I select the grannysmith types
Then I get 0 apples

Scenario:  Generate 100 Apples with 33 green apples
Given The initial 100 apples
When I count select the green Apples
Then I get 33 green apples
When I select the Idared types 
Then I get 0 apples
When I select the Redchief types
Then I get 0 apples
When I select the Grannysmith types
Then I get 33 apples

Scenario:  Generate 100 Apples with 33 yellow apples
Given The initial 100 apples
When I count select the yellow Apples
Then I get 33 yellow apples
When I select the Idared types 
Then I get 33 apples
When I select the Redchief types
Then I get 0 apples
When I select the Grannysmith types
Then I get 0 apples