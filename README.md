# VinylProjectFinal - Collection Tracker

Owen Cornock
Test Coverage: 97.9% 
## Introduction:

For this project it was given an MVP to generate a hobby project with the CRUD application which was studied during the training. During the project the following practices were used:
* Project Management - Jira was used to map the progress of the application with fully expanded user stories, VCS was used to have clean code practices
* Database - MySQL was used to have a relational database 
* Java SE & Spring Boot - Application backend completed through Spring Boot following OOP
* HTML, CSS, JS - Fronted completed with integrated API for fully functioning website
* Testing - Testing of backend using integrated test suite

### Overview
The application was completed whilst keeping track using jira. This allowed for the project to be tracked whilst also keeping targets in place of what needs to be completed. A sprint was completed during the application in which user stories where made which included; tasks, epics, story points, success criteria and priorities. An example of jira is shown below:

![Imgur](https://imgur.com/3KfIxFp)

!(documentation\Jira2 Proj2.png)

For the project it was required to have a functioning front and backend application that accepts CRUD functionality whilst connecting to a database. For my project I decieded to create a vinyl collection. This allowed the user to add, update, delete and read. The read function allows the user to read by id, artist, album and size of the vinyl.

Before starting the project a risk assessment was completed with a shown risk assessment matrix. This allowed for any risks to be identified prior to starting the project and the solutions to be found. The Risk assessment can be found within the documentation folder. The following is the risk assessment matrix.

!(documentation\Risk matrix proj2.png)

#### Prerequisites

To run the application the following is required:

1. [**Git**](https://gitforwindows.org/)
2. [**MySQL**](https://dev.mysql.com/downloads/windows/installer/8.0.html)
3. [**Java**](https://www.oracle.com/java/technologies/downloads/#java17)
4. [**Springboot**](https://spring.io/projects/spring-boot)
5. [**VS Code**](https://code.visualstudio.com/)
6. [**Jira**](https://www.atlassian.com/software/jira)
7. [**GitHub**](https://github.com/)

### Databases

MySQL was used to store the data that is provided by the user. Columns for artist, albums and size were used. These inputs were tested during the inital phase via postman.

!(documentation\Postman proj2.png)

### Backend + Testing

The backend of the application was completed using a springboot framework ensuring the code followed oop practices. Backend was completed first which gave the application functionality to give CRUD to the Vinyl Collection.

Once the backend was completed a integrated test suite was set up. This test was used to test the classes of the backend with a final coverage of 97.9%. An example of the test is shown with the final coverage.

```
	@Test
	void testCreate() throws Exception {
		Vinyl testVinyl = new Vinyl (null, "X Ambassadors", "VHS", 12);
		String testVinylAsJSON = this.mapper.writeValueAsString(testVinyl);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testVinylAsJSON);
		
		Vinyl testCreatedVinyl = new Vinyl(3, "X Ambassadors", "VHS", 12);
		String testCreatedVinylAsJSON = this.mapper.writeValueAsString(testCreatedVinyl);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedVinylAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
```

The backend of the application can be run through the fat Jar which is available on the github page. This allows for the user to interact with the applicatin on the frontend.

A UML has been produced for the backend to show the relationships between the classes. This can be seen as follows.

!(documentation\UML Proj2.png)

### Frontend

For the frontend of the application, HTML, CSS and javascript were implemented. A nav bar was utilised from bootsrap, this allowed for multiple html pages to be accessed for the different functions of the application. 

CSS styles for the background and styling of the application were used to give an animated background. This was achieved through keyframes and gradients.

JS allowed for the connection with the API which was simplified with axios.

Examples of the pages are shown below: 

!(documentation\HomePageProj2.png)

!(documentation\CreateProj2.png)

### Built With

* Git
* MySQL
* Java
* SpringBoot
* HTML
* CSS
* JS
* MockMVC

### Authors

* Owen Cornock - Project Completed 
