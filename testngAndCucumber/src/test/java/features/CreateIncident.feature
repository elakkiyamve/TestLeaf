Feature: Create a new incident in serviceNow Application

Background: 

Given Enter the username as admin
And Enter the password as 5G0qJ$GLh%ut
When Click on Login button
Then Homepage should be displayed
And Click All Link
And Click Incidents

Scenario Outline: Create incident 

Given Click New
When Type the short_description as <shortDescription>
And Click Submit Button
Then Verify the create incident with number 
  
Examples:
|shortDescription|
|'Created via Automation'|

