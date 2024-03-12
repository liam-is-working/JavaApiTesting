import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class RestAssurePractice {
    @BeforeAll
    static void setUp(){
//        RestAssured.baseURI
        RestAssured.port = 8080;
    }

    @Test
    void helloWorldShouldResponse200(){
        RestAssured.get("/helloWorld").then().statusCode(200);
    }
    @Test
    void helloWeCampShouldResponseGreeting(){
        get("/helloWeCamp").then().body("greet", equalTo("Hello we are WeCampers"));
    }
    @Test
    void storeShouldReturnValidBooks(){
                get("/store").
                then().
                body("store.book.findAll { it.price > 10 }.title", hasItems("Sayings of the Century", "Moby Dick"));
    }

}
