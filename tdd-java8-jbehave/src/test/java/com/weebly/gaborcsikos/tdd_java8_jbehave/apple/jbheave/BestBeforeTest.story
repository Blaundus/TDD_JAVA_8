Best Befor Story

Narrative:
In order to test the Best before date
As a Health Inspector
I want to see that all apples are good for a week
					 
Scenario:  All apples was packaged On October 1
Given The 100 initial apples packed on October 1
When I check the best before date 
Then I see all type is good till October 8
					 
Scenario:  The idared apples where packed october 1 but the other tyőes october 2
Given The 100 initial apples, the redchief apples were packed october 1, and other types october 2
When I check the best before date 
Then I see that the redchief apples are good till Octbober 8, the grannysmith October 9, the idared october 9 


Scenario:  The idared apples where packed october 1 but the green october 2
Given The 100 initial apples, the redchief apples were packed october 1, the idared apples October 2, the grannysmith October 3
When I check the best before date 
Then I see that the redchief apples are good till Octbober 8, the idared October 9, the grannysmith October 10