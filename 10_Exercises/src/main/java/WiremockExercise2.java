import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author rickj
 */
public class WiremockExercise2 {

    /*
    * In this method you will create a stub that only responds to GET requests to /getVehicle
    * which do NOT contain the header 'vehicletype', but do have a header
    * 'color' with value 'black'.
    * You will respond with a body that is 'valid get request'.
    * Hint: absent()
    */
    public void absentStub() {
        //todo 2.1
        stubFor(get("/getVehicle")
            .withHeader("vehicletype", absent())
                .withHeader("color", equalTo("black"))
                .willReturn(aResponse()
                    .withBody("valid get request")));
    }


    /*
    * Here you are going to create 2 stubs that overlap.
    * One stub will listen to GET requests to all the endpoints starting with /motorbikes/ and will return a 401 status.
    * The second stub should override the first one and only listen to /motorbikes/yamaha and respond with a 200 status.
    */
    public void motorbikesStub() {
        //todo 2.2
        //Catch-all case
        stubFor(get(urlMatching("/motorbikes/.*"))
                .willReturn(aResponse()
                    .withStatus(401)));

        //Specific case
        stubFor(get("/motorbikes/yamaha")
                .willReturn(aResponse()
                        .withStatus(200)));
    }

    /*
    * In this stub you'll be responding to a GET request to /getAllCars.
    * You'll answer with a HTTP status code 200 and a response that contains a header.
    * This header will specify that the Content-Type is 'application/json'.
     */
    public void getAllCarsStub() {
        //todo 2.3
        stubFor(get("/getAllCars")
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withStatus(200)));
    }

    /*
    * Authentication time! In this stub, make sure all GET requests to /authenticateMe are
    * accompanied by basic authentication. The username is wiremock and the password
    * should be restassured. Respond with a body equal to 'successfully authenticated' only if the authentication is valid.
    */
    public void authenticationStub() {
        //todo 2.4
        stubFor(get("/authenticateMe")
            .withBasicAuth("wiremock", "restassured")
            .willReturn(aResponse()
                .withBody("successfully authenticated")));
    }

    /*
    * Time to check for cookies! Make sure the GET request in this stub comes with a cookie called Country.
    * The value should be Netherlands.
    Respond with a body equal to "Get Succeeded". Let the stub listen to /cookieTime
    */
    public void cookieStub() {
        //todo 2.5
        stubFor(get("/cookieTime")
            .withCookie("Country", equalTo("Netherlands"))
            .willReturn(aResponse()
                .withBody("Get Succeeded")));
    }
}
