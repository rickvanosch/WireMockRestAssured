import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.iterableWithSize;

public class TestSimpleRequests {

    /**
     * Perform a GET request on localhost:8080/cars and verify the status code is 200
     * and the response header 'Content-Type' is 'application/json'.
     */
    @Test
    public void testSimpleGet() {

    }

    /**
     * Perform a GET request on localhost:8080/car/1 and verify the request is successful and
     * the response body has an 'id' field with value '1'.
     */
    @Test
    public void testGetAndVerifyObject() {

    }

    /**
     * Perform a POST request to localhost:8080/students with an object containing an `id`
     * of 1 and a `name` of Bob.
     * Make sure the request header 'Content-Type' is 'application/json'.
     * Perform a GET request to that same endpoint and verify you get an object with a property 'students'
     * which is an array of size 2.
     * <p>
     * Afterwards,
     * Perform a DELETE request to localhost:8080/student/1.
     * Confirm afterwards that the object is actually gone by performing another GET.
     */
    @Test
    public void testStudentAPI() {
        given()
                .body("{\"id\": 1, \"name\":\"Bob\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/students")
                .then()
                .statusCode(201);

        given()
                .get("/students")
                .then()
                .body("students", iterableWithSize(1));

        given()
                .when()
                .delete("/students");

        given()
                .when()
                .get("/students")
                .then()
                .body("students", Matchers.emptyIterable());
    }
}