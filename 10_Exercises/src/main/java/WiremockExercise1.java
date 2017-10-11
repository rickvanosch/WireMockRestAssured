import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 *
 * @author rickj
 */
public class WiremockExercise1 {
    
    /*
    * Here you are going to create your first stub
    * Make sure the stub listens to /cars/all
    * The stub should respond to all GET request with a 200 HTTP status code
    */
    public void getCarsStub(){

    }
    
    /*
    * Here you will be making a stub that listens
    * to /cars/25-BB-83 and responds to get requests with 
    * a body 'brand: lamborghini'
    */
    public void getSpecificCarStub(){
        
    }
    
    /*
    * Now it is time to create a stub that once again returns a 200 HTTP response
    * this time it should have a status message containing 'valid response'
    * make sure it listens to /occasions
    */
    public void getOccasionsStub(){
        
    }
    
    /*
    * Mock a response to a post request on /cars/new/ with a body
    * that contains 'brand: audi, color: black, license:22-AA-33'.
    * You'll respond with a status 200 and body 'car inserted'
    */
    public void postNewCar(){
//        stubFor(post(urlEqualTo("/cars/new")).inScenario("Light bulb")
//				.withRequestBody(equalTo("brand: audi, color: black, license:22-AA-33"))
//				.willReturn(aResponse()
//						.withStatus(200)
//						.withBody("car inserted")
//				));
    }
}
