package specs;

import config.CredentialConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static helpers.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static java.sql.Types.NULL;
import static org.hamcrest.Matchers.not;

public class SpecsReqresTest {

    static CredentialConfig credentialConfig = ConfigFactory.create(CredentialConfig.class);

    public static RequestSpecification request = with()
            .baseUri("https://api.vk.com")
            .basePath("/method")
            .filter(customLogFilter().withCustomTemplates())
            .contentType(ContentType.JSON)
            .queryParam("v", "5.21")
            .queryParam("client_id", credentialConfig.vkClientId())
            .queryParam("access_token", credentialConfig.vkUserToken());

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(not(NULL))
            .build();
}
