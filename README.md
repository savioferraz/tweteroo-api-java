# Tweteroo API
This is a RESTful API for a social media platform called Tweteroo, built using Java and Spring Framework with MVC architecture pattern. The API allows users to register, login, create tweets, and retrieve tweets.

## Table of Contents
- Installation
- Usage
- API Documentation
- Technologies Used
- Licence

## Installation
To get started with the API, clone the repository and import the project into your IDE. Make sure you have Java and Maven installed on your system. You can also run the API using the command line by navigating to the project directory and running mvn spring-boot:run.

## Usage
You can use a tool like Thunderclient to test the API endpoints. The base URL for the API is http://localhost:8080.

## API Documentation
### Authentication

|Method |	Endpoint |	Description |
|-------|----------|--------------|
|POST	| /sign-up |	Register a new user |

### Tweets
|Method |	Endpoint |	Description |
|-------|----------|--------------|
|POST	| /tweet |	Create a new Tweet |
| GET	| /tweets/?page |	Get last 10 tweets on their respective page |
| GET	| /tweets/user:username	| Get all tweets for a specific user|

## Technologies Used
- Java
- Spring Boot
- Maven

## License
This project is licensed under the MIT License. See the LICENSE file for more information.
