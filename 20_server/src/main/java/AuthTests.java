import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

public class AuthTests {
    public static void stub(WireMockServer wireMockServer) {
        stubFor(get("/secureapi")
                .withBasicAuth("admin", "admin")
                .willReturn(aResponse()
                .withStatus(200))
        );


    }
}
