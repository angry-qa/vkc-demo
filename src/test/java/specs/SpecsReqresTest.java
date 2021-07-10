package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static helpers.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static java.sql.Types.NULL;
import static org.hamcrest.Matchers.not;

public class SpecsReqresTest {
    public static RequestSpecification request = with()
            .baseUri("https://api.vk.com")
            .basePath("/method")
            .filter(customLogFilter().withCustomTemplates())
            .contentType(ContentType.JSON)
            .queryParam("v", "5.21")
            .queryParam("client_id", "7854129")
            .queryParam("access_token", "60d8d74674be791e687676cda71a07e7688d5eddc7b7739979bfe2aadabfd66d4f35ab7d3bfaf552ddc59");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(not(NULL))
            .build();
}
