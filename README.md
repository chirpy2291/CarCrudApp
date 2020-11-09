Car CRUD App - Spring Boot

<b>PROBLEM STATEMENT</b>

Implement Microservice using Spring Boot & RestFul Architecture style.

For below Bean class, with following fields
public class Car {
       private String carName;
       private Integer carId;
       private double price;
                             private String model;
private Integer yearOfManufacture;
private String fuelType; (possible values PETROL/DIESEL/ELECTRIC)
}


1.	Microservice with CRUD operations to create Car.
2.	Create appropriate layers.
3.	Write custom validations such that
a)	car name should not contain spaces and special characters.
b)	car should not be more than 15 years old
4.	Enable Caching at Service Layer and demonstrate it for the same Car Service Layer
5.	Get car review from `. Add circuit breaker pattern
6.	Add JUnit Test cases including integration tests

**********************************************************


<b>HOW TO USE:</b>

Build the application by skipping test cases(<b>jUnits are yet to be completed due to technical error</b>), as there are  bugs in JUnits ,need to be fixed<EntityManagerFactory issue>.
Run the application and once the initialisation is complete,use postman/terminal to Use the API's as decribed below.
This App also implements hystrix circuit breaker and caching enabled at service layer as described below.
This app uses H2 database (packaged dependecy with the project),for storing and retrieving the data.

<b>API description:</b>

1)POST

URL:http://localhost:8080/cars
Body:
    {
    "carid": "1",
    "carname": "Jazz",
    "price": "1000000",
    "model": "XUV",
    "yearOfManufacture" : "2020",
    "fuelType":"PETROL"
  }
ContentType:json

Output: Returns the carid on succesful insertion

2)GET 
  To get all cars:
  
  URL:http://localhost:8080/car
  
  Output: List of Cars
  
      {{
          "carid": "1",
          "carname": "Jazz",
          "price": "1000000",
          "model": "XUV",
          "yearOfManufacture" : "2020",
          "fuelType":"PETROL"
      },
      {}}
      
   To get a specific Car by ID:
   
   URL:http://localhost:8080/car/1
   
   Output: Car Description By ID
  
      {
          "carid": "1",
          "carname": "Jazz",
          "price": "1000000",
          "model": "XUV",
          "yearOfManufacture" : "2020",
          "fuelType":"PETROL"
      }
      
   
   
  4)UPDATE(PUT):
  used same as POST
  
  5)DELETE:
  
  URL:http://localhost:8080/car/1
  
  
  
************************************************
  
<b>HOW TO TEST CACHING:</b>

This APP has enabled caching at getAllCars service.

************************************************

@Cacheable("allCars")
	public List<Cars> getAllCars() {
		List<Cars> cars = new ArrayList<Cars>();......
  
************************************************  
  
  
 AND Cache evicts once there is an update or New entry:
 
 
************************************************
 
 
 @CacheEvict(allEntries = true)
	public void saveOrUpdate(Cars cars) {

		carsRepository.save(cars);

	}....
  
  @CacheEvict(allEntries = true)
	public void update(Cars cars, int carid) {.....
  
  
  *************************************************

<b>Thread.sleep has been implemented for 5 seconds to demonstrate cache working.Once for first time data is retrieved from database<application waits for 5 seconds>.
Post that same data would be retrieved from cache.</b>


************************************************


<b>HOW TO TEST HYSTRIX:</b>

Try fetching some data that does nnot exist.You should get a null object.

GET: http://localhost:8080/car/5

Output:
{
    "carid": 0,
    "carname": null,
    "price": 0.0,
    "model": null,
    "yearOfManufacture": null,
    "fuelType": null
}
  
  
