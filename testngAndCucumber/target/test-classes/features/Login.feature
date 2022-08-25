Feature: Login to the serviceNow application

@smoke
Scenario Outline: Login with positive credential

Given Enter the username as <username>
And Enter the password as <password>
When Click on Login button
Then Homepage should be displayed
And Click All Link
And Click Incidents

Examples:
|username|password|
|admin|5G0qJ$GLh%ut|


