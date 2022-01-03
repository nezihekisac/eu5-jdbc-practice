package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class  simpleGetRequest {

    String hrurl = "http://3.235.93.120:1000/ords/hr/regions";

    @Test
    public void test1() {

        Response response = get(hrurl);

        //print the status code
        System.out.println(response.statusCode());

        response.prettyPrint();
    }
        /*
        Given accept type is json
        When user sends get request to regions endpoint
        Then response status code must be 200
        and body is json format
         */

    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                .when().get(hrurl);

        //verify response status code is 200
        Assert.assertEquals(response.statusCode(), 200);


        System.out.println(response.contentType());

        //verify content-type is application/json
        Assert.assertEquals(response.contentType(), "application/json");

    }

    //we are doing the same test  with different way
    @Test
    public void test3() {
        given().accept(ContentType.JSON)
                .when().get(hrurl).then()
                .assertThat().statusCode(200)
                .and().contentType("application/json");
    }

    /*
    Given accept type is json
    When user sends get request to regions/2
    Then response status code must be 200
    and body is json format
    and response body contains Americas
     */

    @Test
    public void Test4() {
        Response response = given().accept(ContentType.JSON)
                .when().get(hrurl + "/2");
        //verify status code

        Assert.assertEquals(response.getStatusCode(),200);

        //verify content type
        Assert.assertEquals(response.contentType(),"application/json");

        //verify body contains Americas

        Assert.assertTrue(response.body().asString().contains("Americas"));


    }

}














