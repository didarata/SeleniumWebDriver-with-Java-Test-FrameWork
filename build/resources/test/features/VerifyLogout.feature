Feature: Verify Logout

 Scenario: Verify logout after login with valid credentials

   Given User is on login page
   When User enters username, passwords and clicks on login button
   And User is redirected to Inventory Page
   And User clicks on product image
   Then User logs out


 Scenario: Verify footer and three social media icons

   Given User is on login page
   And User enters username, passwords and clicks on login button
   And User is redirected to Inventory Page
   When User verifies Twitter, Facebook, Linkedin and Privacy text are in Footer
   And User clicks on product name
   And User verifies he is on Item Detail Page
   And User verifies Twitter, Facebook, Linkedin and Privacy text are in Footer
   Then User logs out