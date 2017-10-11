import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

public class TestSimpleRequests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void testSimpleGets() {
        /*
        Perform a GET request on localhost:8080/cars and verify the status code is 200
        and the header 'Content-Type' is 'application/json'.
         */


        /*
        Perform a GET request on localhost:8080/car/1 and verify the request is successful and
        the response body has an 'id' field with value '1'.
         */

        /*
        Perform a GET request on localhost:8080/cars again and verify you get a list with a
        size of 2.
         */
    }

    @Test
    public void testPostAndGet() {
        /*
        Perform a POST request to localhost:8080/students with an object containing an `id` and a `name`.
         */

        /*
        Perform a GET request to that same endpoint and verify you get the same object.
         */
    }

    @Test
    public void testSimpleDelete() {
        /*
        Perform a DELETE request to localhost:8080/student/:id. Use the same id that you POSTed earlier.
        Confirm afterwards that the object is actually gone.
         */
    }
}