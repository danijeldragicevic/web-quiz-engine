# Web Quiz Engine
Service who is able to create and manage quizzes by the authenticated users. <br>
Application is able to:
- create new users,
- create new quizzes,
- retrieve quizzes by their id,
- retrieve all quizzes paginated,
- place solutions on quizzes,
- retrieve all solutions paginated and
- delete quizzes by their id.

Application use embedded H2 database and Basic authentication.

# Technology
- Java 11
- Spring Boot 2.7.10 (Spring Web MVC, Spring REST, Spring Data Jpa, Spring Security, Spring Validation, Project Lombok, H2 database, Pagination, Native Query)
- Gradle 7.4

# To run application:
Navigate to the project root directory and run **./gradlew bootRun**

# Exposed endpoints:
By default, service will run on **http://localhost:8889** <br/>
Following endpoints will be exposed:

| Methods | Urls                          | Action                                                   | Access                      |
|---------|-------------------------------|----------------------------------------------------------|-----------------------------|
| GET     | /h2                           | Access to the local database (username: sa, no password) | No authentication needed    |
| POST    | /api/register                 | Register new user                                        | No authentication needed    |
|         |                               |                                                          |                             |
| POST    | /api/quizzes                  | Create new quiz                                          | Authenticated user required |
| GET     | /api/quizzes/{id}             | Get quiz by it's id                                      | Authenticated user required |
| GET     | /api/quizzes?page=0           | Get all quizzes, paginated (5 records per page)          | Authenticated user required |
| POST    | /api/quizzes/{id}/solve       | Place solution for the quiz                              | Authenticated user required |
| GET     | /api/quizzes/completed?page=0 | Get completed quizzes, paginated (5 records per page)    | Authenticated user required |
| DELETE  | /api/quizzes/{id}             | Delete quiz by it's id                                   | Authenticated user required |

# Examples
### API calls
**Example 1:** Registering a new user with a valid request body: <br>
Request: `POST /api/register` <br>
Request body: <br>
```
{
  "email": "test@mail.org",
  "password": "strongpassword"
}
```
Response code: `200 OK`
```
{
  "message": "User successfully created."
}
```

**Example 2:** Registering a new user with a valid request body but the email address is already taken: <br>
Request: `POST /api/register` <br>
Request body: <br>
```
{
  "email": "test@mail.org",
  "password": "strongpassword"
}
```
Response code: `400 BAD REQUEST` <br>

**Example 3:** Registering a new user with an invalid email: <br>
Request: `POST /api/register` <br>
Request body: <br>
```
{
  "email": "test@mailorg",
  "password": "strongpassword"
}
```
Response code: `400 BAD REQUEST` <br>

**Example 4:** Registering a new user with a too short password: <br>
Request: `POST /api/register` <br>
Request body: <br>
```
{
  "email": "test@mail.org",
  "password": "1234"
}
```
Response code: `400 BAD REQUEST` <br>

#### Requesting all other endpoints without valid username and password will return response code `401 UNAUTHORIZED`. <br>

**Example 5:** Creating a new quiz: <br>
Request: `POST /api/quizzes` <br>
Request body: <br>
```
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
  "answers": [2]
}
```
Response code: `200 OK` <br>
Response body: <br>
```
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

**Example 6:** Getting an existing quiz by id: <br>
Request: `GET /api/quizzes/1` <br>
Response code: `200 OK` <br>
Response body: <br>
```
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

**Example 7:** Getting a non-existing quiz by id: <br>
Request: `GET /api/quizzes/15` <br>
Response code: `404 NOT FOUND` <br>

**Example 8:** Getting the first page of the total list of all quizzes created: <br>
Request: `GET /api/quizzes?page=0` <br>
Response code: `200 OK` <br>
Response body: <br>
```
[
  {
    "id": 1,
    "title": "The Java Logo",
    "text": "What is depicted on the Java logo?",
    "options": ["Robot", "Tea leaf", "Cup of coffee", "Bug"]
  },
  {
    "id": 2,
    "title": "The Ultimate Question",
    "text": "What is the answer to the Ultimate Question of Life, the Universe and Everything?",
    "options": ["Everything goes right", "42", "2+2=4", "11011100"]
  },
  {
    "id": 3,
    "title": "The biggest planet",
    "text": "Who is the biggest planet in the solar system?",
    "options": [ "Venus", "Uranus", "Earth", "Jupiter"]
  }
]
```

**Example 9:** Solving an existing quiz with a correct answer: <br>
Request: `POST /api/quizzes/1/solve` <br>
Request body: <br>
```
{
  "answers": [2]
}
```
Response code: `200 OK` <br>
Response body: <br>
```
{
  "success": "true",
  "feedback": "Congratulations, you're right!"
}
```

**Example 10:** Solving an existing quiz with a wrong answer: <br>
Request: `POST /api/quizzes/1/solve` <br>
Request body: <br>
```
{
  "answers": [2, 3]
}
```
Response code: `200 OK` <br>
Response body: <br>
```
{
  "success": "false",
  "feedback": "Wrong answer! Please, try again."
}
```

**Example 11:** Solving an non-existing quiz: <br>
Request: `POST /api/quizzes/15/solve` <br>
Request body: <br>
```
{
  "answers": [2, 3]
}
```
Response code: `404 NOT FOUND` <br>

**Example 12:** Getting the first page of the total list of completed quizzes, for the authenticated user: <br>
Request: `GET /api/quizzes/completed?page=0` <br>
Response code: `200 OK` <br>
Response body: <br>
```
{
  "content": [
    { "id": 1, "completedAt": "2023-04-20T14:15:04.421949" },
    { "id": 2, "completedAt": "2023-04-20T14:14:55.776697" },
    { "id": 3, "completedAt": "2023-04-20T14:14:43.296623" },
    { "id": 1, "completedAt": "2023-04-20T14:13:17.517454" },
    { "id": 3, "completedAt": "2023-04-20T14:13:01.900892" }
  ]
}
```

**Example 13:** Delete quiz by id, authenticated as user who did create it: <br>
Request: `DELETE /api/quizzes/1` <br>
Response code: `200 OK` <br>
Response body: <br>
```
{
  "message": "Quiz successfully deleted."
}
```

**Example 14:** Delete quiz by id, authenticated as user who did not create it: <br>
Request: `DELETE /api/quizzes/2` <br>
Response code: `403 FORBIDDEN`

# Licence
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
