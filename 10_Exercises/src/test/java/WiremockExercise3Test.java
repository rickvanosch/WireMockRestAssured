/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Test;
import org.junit.Rule;

/**
 *
 * @author rickj
 */
public class WiremockExercise3Test {
    
     WiremockExercise3 wm3 = new WiremockExercise3();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9876);

    
    @Test
    public void testGetDelayedStub(){
        wm3.getDelayedStub();
      
	    given().
	    when().
	        get("http://localhost:9876/delayRequest").
	    then().
	        assertThat().
	        time(greaterThan(2000L));
    }
    
    @Test
    public void testScenarioStub(){
        
        wm3.ScenarioStub();
	         
	    given().
	    when().
	        get("http://localhost:9876/carExercise").
	    then().
	    	assertThat().
	    	statusCode(200).
	    and().
	    	body(equalTo("No occasions at the dealer"));
	    
	    given().
	    	body("New occasion:vw golf,black,diesel").
	    when().
	        post("http://localhost:9876/carExercise").
	    then().
	    	assertThat().
	    	statusCode(200).
	    and().
	    	body(equalTo("Occasion added to dealer"));
	    
	    given().
	    when().
	        get("http://localhost:9876/carExercise").
	    then().
	    	assertThat().
	    	statusCode(200).
	    and().
	    	body(equalTo("Occasions in stock"));
	    
	    given().
	    	body("Buy vw golf").
	    when().
	        post("http://localhost:9876/carExercise").
	    then().
	    	assertThat().
	    	statusCode(200).
	    and().
	    	body(equalTo("Purchased car succesfully"));
	    
	    given().
	    when().
	        get("http://localhost:9876/carExercise").
	    then().
	    	assertThat().
	    	statusCode(200).
	    and().
	    	body(equalTo("No occasions at the dealer"));
    }
}
