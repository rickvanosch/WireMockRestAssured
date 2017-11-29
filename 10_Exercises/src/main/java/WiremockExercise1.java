import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

/**
 * @author rickj
 */
public class WiremockExercise1 {

    /*
    * Here you are going to create your first stub.
    * Make sure the stub listens to /cars/all. Don't forget the / in front of the URL.
    * The stub should respond to all GET request with a 200 HTTP status code.
    */
    public void getCarsStub() {
        //todo 1.1
    }

    /*
    * Here you will be making a stub that listens
    * to /cars/25-BB-83 and responds to GET requests with the following body
    * 'brand: lamborghini' as a simple string.
    */
    public void getSpecificCarStub(){
        //todo 1.2
    }

    /*
    * Now it is time to create a stub that also returns a 200 HTTP response for GET requests.
    * This time it should have a status message which is 'valid response'.
    * Make sure it listens to /occasions.
    */
    public void getOccasionsStub(){
        //todo 1.3
    }

    /*
    * Mock the endpoint /cars/new which listens to POST requests and only to requests containing a body
    * that is 'brand: audi, color: black, license: 22-AA-33' as simple string.
    * You'll respond with a status 200 and body 'car inserted'
    * HINT: containing("...")
    */
    public void postNewCar() {
        //todo 1.4
    }
}
