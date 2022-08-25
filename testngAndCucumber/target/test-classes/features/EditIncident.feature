Feature: Edit incident in serviceNow Application

Background: 
Given Enter the username as admin
And Enter the password as 5G0qJ$GLh%ut
When Click on Login button
Then Homepage should be displayed
And Click All Link
And Click Incidents

Scenario Outline: Edit incident 

Given Search existing incident number to edit
When click incident number to edit
And Enter caller by clearing the existing value <callerId>
And select Urgency and select <Urgency>
And select State and select <State>
And enter Short description as <ShortDescription>
Then click Update

Examples:
|callerId|Urgency|State|ShortDescription|
|Abel Tuter|1-High|In Progress|Edited Via Automation|



