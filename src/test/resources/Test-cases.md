Test Case ID: TC_001
Description: Search and add a product to the cart
Preconditions: User is logged in to the system
Test Steps:
Search for "laptop".
Select the first product.
Add the product to the cart.
Expected Result: The product should be added to the cart successfully.
Actual Result: The product is added to the cart, and a confirmation message "Added to Cart" is displayed.
Status: Pass

Test Case ID: TC_002
Description: Proceed to checkout after adding a product to the cart
Preconditions: A product is added to the cart, and the user is logged in.
Test Steps:
Go to the cart.
Click on "Proceed to Checkout".
Continue through the checkout process.
Expected Result: The user should be redirected to the checkout page.
Actual Result: After clicking "Proceed to Checkout", the user is redirected to the login page if not logged in or to the checkout page if already logged in.
Status: Pass

Test Case ID: TC_003
Description: Login with valid credentials
Preconditions: User has valid login credentials.
Test Steps:
Open the login page.
Enter valid email and password.
Click on "Login".
Expected Result: The user should be successfully logged in and redirected to the homepage.
Actual Result: The user is successfully logged in, and the homepage is displayed.
Status: Pass

Test Case ID: TC_004
Description: Login with invalid credentials
Preconditions: None
Test Steps:
Open the login page.
Enter invalid email or password.
Click on "Login".
Expected Result: An error message should be displayed indicating invalid credentials.
Actual Result: An error message "Your email or password was incorrect" is displayed.
Status: Pass

Test Case ID: TC_005
Description: Verify the presence of key UI elements on the homepage
Preconditions: None
Test Steps:
Open the homepage.
Check for the presence of the search bar.
Check for the presence of the navigation menu.
Check for the presence of the footer.
Expected Result: All key UI elements (search bar, navigation menu, footer) should be present and functional.
Actual Result: Search bar, navigation menu, and footer are present and functional.
Status: Pass

Test Case ID: TC_006
Description: Form validation for account creation
Preconditions: None
Test Steps:
Open the account creation form.
Enter invalid email (e.g., missing "@" symbol).
Enter a weak password (e.g., less than 6 characters).
Attempt to submit the form.
Expected Result: Error messages should appear for invalid email and weak password.
Actual Result: Appropriate error messages for invalid email and weak password are displayed.
Status: Pass

Test Case ID: TC_007
Description: Verify cart update after changing quantity
Preconditions: A product is added to the cart.
Test Steps:
Go to the cart.
Change the quantity of the product.
Verify that the total price is updated accordingly.
Expected Result: The cart should update the total price based on the new quantity.
Actual Result: The cart quantity and total price are updated correctly.
Status: Pass

Test Case ID: TC_008
Description: Remove an item from the cart
Preconditions: A product is added to the cart.
Test Steps:
Go to the cart.
Click on "Remove" next to the product.
Verify that the cart is empty after the item is removed.
Expected Result: The item should be removed from the cart, and the cart should be empty.
Actual Result: The item is successfully removed, and a confirmation message is displayed indicating that the cart is empty.
Status: Pass

Test Case ID: TC_009
Description: Search for a product with no results
Preconditions: None
Test Steps:
Enter a search term for a product that does not exist (e.g., "xyzproduct").
Click on "Search".
Expected Result: A message should be displayed indicating that no results were found.
Actual Result: "No results found" message is displayed for the invalid search term.
Status: Pass

Test Case ID: TC_010
Description: Logout from the account
Preconditions: The user is logged in.
Test Steps:
Click on the account menu.
Select "Sign Out".
Expected Result: The user should be logged out and redirected to the homepage.
Actual Result: The user is successfully logged out and redirected to the homepage.
Status: Pass
