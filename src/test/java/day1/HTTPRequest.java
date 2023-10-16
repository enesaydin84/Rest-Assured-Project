package day1;

/*
given()---->Content Type,set cookies,add auth, add param, set header info etc.   PREREQUISTIES
 */

/*
when()------>get.post,put,delete req. urls.                                     REQUEST
 */

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


/*
then()------>
validate status code,extract response,extract headers cookies etc,response body   VALIDATION
*/
public class HTTPRequest {
    int id;
   @Test(priority = 1)
    void getUsers(){


                when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();

    }

    @Test(priority = 2)
    void createUser(){
        HashMap hm=new HashMap();
        hm.put("name","Ali");
        hm.put("job","Engineer");
        id=given()
                .contentType("application/json")
                .body(hm)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

                //.then()
                //.statusCode(201)
                //.log().all();
    }
    @Test(priority = 3,dependsOnMethods = {"createUser"})
    void updateUser(){
        HashMap hm=new HashMap();
        hm.put("name","Veli");
        hm.put("job","Teacherqw");
        given()
                .contentType("application/json")
                .body(hm)

                .when()
                .post("https://reqres.in/api/users/"+id)


                .then()
                .statusCode(201)
                .log().all();

    }
    @Test(priority = 4)
    void deleteUser(){
       given()
               .when()
               .delete("https://reqres.in/api/users?page="+id)


               .then()
               .statusCode(204)
               .log().all();
    }

}
