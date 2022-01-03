package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class SpartanTestWithPath {
    @BeforeClass
    public void beforeclass(){
        baseURI="http://3.82.206.120:8000";
    }
   /*
   Given accept type is json
   And path param id is 10
   When user sends a get request to "api/spartans/{id}"
   Then status code is 200
   And content-type is "application/json;char"
   And response payload values match the following:
      id is 10,
      name is "Lorenza",
      gender s "Female",
      phone is 3312820936
   */
 @Test
    public void getOneSpartan_path(){
     Response response = given().accept(ContentType.JSON)
             .and().pathParam("id", 9)
             .when().get("/api/spartans/{id}");
     assertEquals(response.statusCode(),200);

     assertEquals(response.contentType(),"application/json");

     //print each key value in the json body/payload
     //response.prettyPrint();

     System.out.println(response.path("id").toString());
     System.out.println(response.path("name").toString());
     System.out.println(response.path("gender").toString());
     System.out.println(response.path("phone").toString());

     //save json key values
     int id=response.path("id");
     String name=response.path("name");
     String gender=response.path("gender");
     int phone =response.path("phone");

     System.out.println("id = " + id);
     System.out.println("name = " + name);
     System.out.println("gender = " + gender);
     System.out.println("phone = " + phone);

     //assert one by one
     assertEquals(id,9);
     assertEquals(name,"Florrie");
     assertEquals(gender,"Female");
     assertEquals(phone, 1702025787L);

 }
 @Test
    public void getAllspartanWithPath(){
     Response response = given().accept(ContentType.JSON)
             .when().get("/api/spartans");
     assertEquals(response.statusCode(),200);
     assertEquals(response.getHeader("Content-Type"),"application/json");
    // System.out.println(response.path("id[1]").toString());

     int firstId=response.path("id[0]");
     System.out.println("firstId = " + firstId);

     String firstName=response.path("name[0]");
     System.out.println("firstName = " + firstName);

     int lastId=response.path("id[-1]");
     System.out.println("lastId = " + lastId);

     String lastFirstName=response.path("name[-1]");
     System.out.println("lastFirstName = " + lastFirstName);

     //print all names of spartans
     List<String> names=response.path("name");
     System.out.println("names = " + names);

     List<Object> phones=response.path("phone");
     for(Object phone : phones) {
         System.out.println(phone);
     }




 }





}
