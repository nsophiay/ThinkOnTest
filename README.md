_Take-home exercise for ThinkOn application, October 14, 2024._

Beginning stages of development of persistence functionality can be found in the `jpa-hibernate` branch.

All other functionality is intact in the main branch, including:
* Creating new users (POST)
* Listing all available users (GET /users)
* Listing a single user (GET /users/{username})
* Updating an existing user (PUT /users/{username})
* Deleting an existing user (DELETE /users/{username})

An example POST request would be to http://localhost:8080/users with body:
`{
  "username": "default_user",
  "firstName": "default_first",
  "lastName": "default_last",
  "email": "default_email",
  "phone": "default_phone"
}`

The result is a message saying: `Successfully created user default_user.`

If we then want to list all users, send a GET request (http://localhost:8080/users), which returns:
`{
  "default_user": {
    "username": "default_user",
    "firstName": "default_first",
    "lastName": "default_last",
    "email": "default_email",
    "phone": "default_phone"
  }
}`
