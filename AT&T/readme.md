# How to run

1. Download zip file
2. Unzip the zip file
3. Open in preferred IDE 
3. Program is in src/Solution
4. Run Solution.java to test program

Input comes from src/input.txt 

There should be no line breaks in between books in input.txt

# Comments and clarifications

The description of the assignment was very vague and did not outline a lot of cases. I did this assignment on Saturday, so I was not able to contact anyone for clarifications. 

Statements I did not understand were "Allow for up to 100 pieces of data to be input simultaneously" and "Accepts from the user at runtime multiple BOOKS". These two statements seemed to be contradicting one another, so I could not determine how I should accept the input because if I accept a users input line by line I would also need to take in a integer of how many books they would enter and that was not outlined as a step. Because of no clear direction I chose to read from txt file as it easier to work with and still tests the main objective of the assignment.

# Cases I were not sure how you wanted me to handle

* Which author I should choose if tie break for same count
* Which book I should choose if tie break for oldest date
* What to return if books are all invalid(not valid author) or empty
* Do I have to check if author is valid(I did check)
* Do I have to check for duplicate books