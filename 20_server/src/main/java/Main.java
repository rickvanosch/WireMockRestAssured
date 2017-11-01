import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.stubbing.Scenario.STARTED;

public class Main {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(wireMockServer::shutdown));

        SimpleTests.stub(wireMockServer);
        AuthTests.stub(wireMockServer);

    }
}