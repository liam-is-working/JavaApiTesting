import com.github.tomakehurst.wiremock.WireMockServer;

public class MockServer {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
    }
}
