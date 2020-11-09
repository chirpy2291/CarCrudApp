Car CRUD App - Spring Boot

HOW TO USE:

Build the application by skipping test cases(jUnits are yet to be completed), as there are some bugs in JUnits ,need to be fixed<EntityManagerFactory issue>.
Run the application and once the initialisation is complete,use postman/terminal to Use the API's as decribed below.
This App also implements hystrix circuit breaker and caching enabled at service layer as described below.
This app uses H2 database (packaged dependecy with the project),for storing and retrieving the data.

API description:

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
  
  
HOW TO TEST CACHING:

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

Thread.sleep has been implemented for 5 seconds to show cahce working.Once for first time data is retrieved from database<application waits for 5 secinds>.
Post that same data would be retrieved from cache.


HOW TO TEST HYSTRIX:

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
  
