/**
 * @author rickj
 */
public class WiremockExercise2 {

    /*
    * In this method you will create a stub that only responds on GET requests
    * which do not contain a header element 'vehicletype', but do have a header 
    * element 'color' with value 'black'. If this request is correct,
    * you'll respond with a body equal to 'valid get request'
    * make sure you listen at path '/getVehicle'
    * a small hint: absent()
    */
    public void absentStub() {
        //todo 2.1

    }


    /*
    * Here you are going to create 2 stubs. The first one shall respond to all get requests on '/motorbikes/.*'
    * The second stub shall rspond to get requests at '/motorbikes/yamaha'. 
    * Please make sure the first one respons a 401 status, while the latter returns a 200 HTTP status.
    * A small hint: atPriority(int x)
     */
    public void motorbikesStub() {
        //todo 2.2
        //Catch-all case

        //Specific case

    }

    /*
    * In this stub you'll be responding to a GET request on /getAllCars. 
    * You'll answer with a HTTP status code 200 and a reponse that contains a header.
    * This header will specify that the content-type is of application/json
     */
    public void getAllCarsStub() {
        //todo 2.3

    }

    /*
    * Authentication time! In this stub, make sure the GET request is 
    * accompanied by basic authentication. The username is wiremock and the password
    * should be restassured. Respond with a body equal to 'successfully authenticated'
    * The stub should listen to /authenticateMe
    */
    public void authenticationStub() {
        //todo 2.4

    }

    /*
    * Time to check for cookies! Make sure the GET request in this stub comes with a cookie called Country. The value should be Netherlands.
    Respond with a body equal to "Get Succeeded". Please let the stub listen to /cookieTime
    */
    public void cookieStub() {
        //todo 2.5

    }
}
