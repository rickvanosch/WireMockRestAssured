import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testAuthorization {

    /**
     * There is an api endpoint /secureapi that only lets you GET stuff with the proper
     * authorization. This one uses a preemptive BasicAuth to authorize users.
     * The credentials are username 'admin' and password 'admin'.
     * Perform this GET request and verify the status code is 200.
     */
    @Test
    public void testBasicAuth() {
        given()
                .auth()
                .preemptive()
                .basic("admin", "admin")
                .when()
                .get("/secureapi")
                .then()
                .statusCode(200);
    }

    /**
     * There are two api endpoints /tokenapi and /input. /input only lets you POST stuff
     * with the proper access token that can be GET from /tokenapi. This endpoint requires the username
     * 'giveme' and password 'atoken'.
     * The /tokenapi endpoint will return a token in a JSON object. Parse this token
     * and use it in the request body to the /input endpoint. Verify both status codes correctly.
     */
    @Test
    public void testTokenAuth() {
        String token =
                given()
                        .auth()
                        .preemptive()
                        .basic("giveme", "atoken")
                        .when()
                        .get("/tokenapi")
                        .then()
                        .extract()
                        .jsonPath()
                        .get("token")
                        .toString();

        given()
                .contentType("application/json")
                .body("{\"token\": " + token + "}")
                .when()
                .post("/input")
                .then()
                .statusCode(200);
    }
}
