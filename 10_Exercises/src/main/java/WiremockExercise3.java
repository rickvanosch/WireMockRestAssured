/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.github.tomakehurst.wiremock.stubbing.Scenario;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author rickj
 */
public class WiremockExercise3 {

    /*
    * In some cases you might want to delay certain requests, in order to prevent overflooding for instance.
    Build a stub that responds to the get request with a delay of 1000 miliseconds. Make it listen to /delayRequest
    */
    public void getDelayedStub() {
        //todo 3.1
        stubFor(get("/delayRequest")
                .willReturn(aResponse()
                        .withFixedDelay(1000)));
    }

    /*
    * It is time for some more logic. Create a stub that listens at path /carExercise.
    * You will have to use scenarios to complete this exercise.
    The scenario is called occasion. Make sure all responses have a HTTP status code 200.
    1. Make sure a GET returns a body with 'No occasions at the dealer'
    2. A post with body 'New occasion:vw golf,black,diesel' returns a body 'Occasion added to dealer'
    3. A GET request should now return a body 'Occasions in stock'
    4. Another POST request with body 'Buy vw golf' should return body 'Purchased car succesfully'
    5. The 3rd and final GET request should return a body 'No occasions at the dealer'
    */
    public void ScenarioStub() {
        //todo 3.2
        stubFor(get("/carExercise").inScenario("occasion")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(aResponse()
                        .withBody("No occasions at the dealer")));

        stubFor(post("/carExercise").inScenario("occasion")
                .whenScenarioStateIs(Scenario.STARTED)
                .withRequestBody(containing("New occasion:vw golf,black,diesel"))
                .willReturn(aResponse()
                        .withBody("Occasion added to dealer"))
                .willSetStateTo("added"));

        stubFor(get("/carExercise").inScenario("occasion")
                .whenScenarioStateIs("added")
                .willReturn(aResponse()
                        .withBody("Occasions in stock")));

        stubFor(post("/carExercise").inScenario("occasion")
                .whenScenarioStateIs("added")
                .withRequestBody(containing("Buy vw golf"))
                .willSetStateTo(Scenario.STARTED)
                .willReturn(aResponse()
                        .withBody("Purchased car succesfully")));
    }
}
