## Foursquare Integration demo

This goal of this project is to demonstrate how to integrate with Foursquare API.

All requirements are defined here [https://github.com/whitbread-eos/product-developer-test]

### Technology Stack

For this project I decided to us following technologies:

* Java 8
* Spring Boot
* Maven

### Different approaches to Foursquare integration

At first I tried to use [https://github.com/wallabyfinancial/foursquare-api-java]. It defines easy to use java API to interact with Foursquare.
But for some reason _venuesExplore_ does not tak _near_ as parameter, and we need to supply ll instead.
Also I came across some Json mapping problems, and quick search on Google showed that many people are complaining about this.

I decided to interact with Foursquare by making direct HTTP requests. It is well documented here [https://developer.foursquare.com/start/search].

### How to build, start and use application

##### To build 

Type following command in the root of the project
 
 `mvn clean install`
 
 This will download all required libraries and produce so called fat (self-contained) jar
 
##### To start 

We can ether use maven spring plugin (no initial build needed)

`mvn spring-boot:run`

Or execute self-contained jar produced by build

`java -jar target/foursquare-integration-demo-0.0.1-SNAPSHOT.jar`

Application will start on port 8080. It is powered by embedded Tomcat Servlet container.

##### To Use

Just open [http://localhost:8080/explore.html] in any browser.

Type area you want to explore into input field and click on Search button.

If Foursquare will be able to recognize location you entered, table of recommended places will appear.
Every place will be identified by name, and its category (park, restaurant, cinema, etc).

To explore different area type it inti search box and click search button, page will be reloaded with new data.
