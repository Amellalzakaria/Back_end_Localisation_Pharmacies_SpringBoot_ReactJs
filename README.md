# PharmacyLocator_application_SpringBoot 

## The Pharmacy Locator Application is a web application that allows users to easily find pharmacies in their city or area and filter them by opening hours. The application offers the following features:

- Search for pharmacies by city or area
- Filter pharmacies by opening hours (day or night)
- Display a list of found pharmacies
- Display detailed information about a pharmacy
- Display directions to a pharmacy

The project will be developed using Agile methodology with short iterations to ensure a good responsiveness to client requests. Unit and integration tests will be performed regularly throughout development to ensure code quality. Development will take place in a separate environment from the production environment.

## APIs to be implemented for the next session:

- Get all cities:  GET /api/villes    
This API returns a list of all cities available in the database.
- Get all zones for a given city:
GET /api/villes/ville/zones   
This API takes the name of the city as a parameter and returns a list of all zones available for that city.
- Get all pharmacies for a given zone: GET /api/cities/city/zones/zone/pharmacies.  
This API takes the name of the city and the name of the zone as parameters and returns a list of all pharmacies available for that zone.  
- Get all pharmacies on duty for a given zone and period:
 GET /api/villes/ville/zones/zone/pharmacies/garde?periode=periode    
This API takes the name of the city, the name of the zone, and the period (day or night) as parameters and returns a list of all pharmacies on duty available for that zone and period.  
- Get details of a pharmacy:
 GET /api/pharmacies/id   
This API takes the ID of the pharmacy as a parameter and returns all details of the pharmacy, including its address, opening hours, and geographical coordinates.  
- Get directions to a pharmacy:
 GET /api/pharmacies/id/itineraire?depart=depart    
This API takes the ID of the pharmacy and the starting address as parameters and returns directions to the pharmacy.
# Technologies used:  
Postman for testing, Eclipse, MySQL, Maven, and Spring Boot.

## To run the application, follow these steps:

1. Clone the repository.
2. Open the project in Eclipse.
3. Run the application using Maven.
4. Test the APIs using Postman.  


Please refer to the documentation for more information about the APIs and how to use them.
