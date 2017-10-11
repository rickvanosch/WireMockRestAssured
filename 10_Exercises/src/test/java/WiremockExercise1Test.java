
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

/**
 *
 * @author rickj
 */
public class WiremockExercise1Test {

    WiremockExercise1 wm1 = new WiremockExercise1();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9876);

    @Test
    public void testGetCarsStub() {
        wm1.getCarsStub();

        given().
                when().
                get("http://localhost:9876/cars/all").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testGetSpecificCarStub() {
        wm1.getSpecificCarStub();

        given().when().get("http://localhost:9876/cars/25-BB-83").
                then().
                assertThat().
                statusCode(200).
                body(equalTo("brand: lamborghini"));
    }

    @Test
    public void testGetOccasionsStubStub() {
        wm1.getOccasionsStub();

        given().when().get("http://localhost:9876/occasions").
                then().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 valid response");
    }
    
    @Test
    public void testPostNewCar(){
        wm1.postNewCar();
        
        given().body("brand: audi, color: black, license:22-AA-33").when().post("http://localhost:9876/cars/new").
                then().
                assertThat().
                statusCode(200).
                body(equalTo("car inserted"));
    }
}
