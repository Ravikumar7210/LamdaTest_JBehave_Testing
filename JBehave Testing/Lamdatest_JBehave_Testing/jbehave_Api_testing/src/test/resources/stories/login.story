Scenario: Valid login and profile fetch
Given the user is on the login page
When the user enters valid credentials
Then the user should see the dashboard
Then the user profile API should return valid data