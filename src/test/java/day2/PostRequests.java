package day2;
/*
1-Using HashMap
2-Using org.json
3-Using POJO
4-Using external json data file
*/
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
public class PostRequests {

    //1-Post Request Using HashMap
   // @Test(priority = 1)
    void testPostUsingHashmap(){
        HashMap data=new HashMap();
        data.put("name","Selman");
        data.put("location","Konya");
        data.put("phone","5367181665");
        String courseArr[]={"Arduino","Scratch"};
        data.put("courses",courseArr);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Selman"))
                .body("location",equalTo("Konya"))
                .body("phone",equalTo("5367181665"))
                .body("courses[0]",equalTo("Arduino"))
                .body("courses[1]",equalTo("Scratch"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }

    //2-Post Request Using org.json
    //@Test(priority = 1)
    void testPostUsingOrgJson(){
        JSONObject data=new JSONObject();
        data.put("name","Selman");
        data.put("location","Konya");
        data.put("phone","235625115");
        String courses[]={"C++","C#"};
        data.put("courses",courses);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Selman"))
                .body("location",equalTo("Konya"))
                .body("phone",equalTo("235625115"))
                .body("courses[0]",equalTo("C++"))
                .body("courses[1]",equalTo("C#"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }

    //3-Post Request Using POJO
    @Test(priority = 1)
    void testPostUsingPOJO(){
        Pojo_Post_Request data=new Pojo_Post_Request();
        data.setName("Selman");
        data.setLocation("Konya");
        data.setPhone("5648515151");
        String courses[]={"a","b"};
        data.setCourses(courses);


        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Selman"))
                .body("location",equalTo("Konya"))
                .body("phone",equalTo("5648515151"))
                .body("courses[0]",equalTo("a"))
                .body("courses[1]",equalTo("b"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();
    }

   @Test(priority = 2)
    void deleteReq(){
        given()
                .when()
                .delete("http://localhost:3000/students/4")
                .then()
                .statusCode(200);
    }




}
