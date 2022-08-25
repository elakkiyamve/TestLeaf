Feature: Delete incident in serviceNow Application

Background: 
Given Enter the username as admin
And Enter the password as 5G0qJ$GLh%ut
When Click on Login button
Then Homepage should be displayed
And Click All Link
And Click Incidents

Scenario: Create incident 

Given Enter Incident number in search box
When click incident number to delete
And Click Delete Button
Then Verify the Delete incident with number 


