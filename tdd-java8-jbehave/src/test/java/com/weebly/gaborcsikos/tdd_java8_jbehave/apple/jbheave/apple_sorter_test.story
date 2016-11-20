Apple Sorter Story

Narrative:
In order to packege the apples
As a factory worker
I want to package them in 10 piece of packaging
					 
Scenario:  I want to package the red apples
Given The initial 100 apples
When I select the red_apple mix
Then I get 3 bags.

Scenario:  I want to create an automn mix with 6 yellow and 4 red apples 
Given The initial 100 apples
When I select the automn mix
Then I get 5 bags.

Scenario:  I want to create an anti doctor apple mix with 8 green and 2 red apples.
Given The initial 100 apples
When I select the anti_doctor mix
Then I get 4 bags.