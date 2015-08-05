Feature: Calculator 

Scenario Outline: Regression Test
Given user enters <input1>
Then result should be <result>

Examples:
|input1	|result	|
|"2,4,/"|"0.5"	|