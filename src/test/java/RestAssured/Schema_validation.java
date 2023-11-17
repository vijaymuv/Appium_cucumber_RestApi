package RestAssured;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class Schema_validation {
//    @Test
    void rest_Assured_schema_validation(){
        File f = new File("C:\\A_files\\schema.json");

        given()
                .baseUri("http://localhost:3000/")
                .header("Content-Type","application/json")
                .body(" {\n" +
                        "    \"id\": 430,\n" +
                        "    \"first_name\": \"Tailor S\",\n" +
                        "    \"last_name\": \"Wayne \",\n" +
                        "    \"email\": \"Tailor@codingthesmartway.com\"\n" +
                        "  }")
                .when()
                .post("employees")
                .then().body(JsonSchemaValidator.matchesJsonSchema("{\n" +
                        "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                        "  \"type\": \"object\",\n" +
                        "  \"properties\": {\n" +
                        "    \"id\": {\n" +
                        "      \"type\": \"integer\"\n" +
                        "    },\n" +
                        "    \"first_name\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"last_name\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"email\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"required\": [\n" +
                        "    \"id\",\n" +
                        "    \"first_name\",\n" +
                        "    \"last_name\",\n" +
                        "    \"email\"\n" +
                        "  ]\n" +
                        "}")).log().all();
//                .body(JsonSchemaValidator.matchesJsonSchema(f)).log().all();
//               .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json")).log().all();
    }
//    @Test
    void rest_Assured_schema_validationUsing_NetworkNT() throws IOException {
        ObjectMapper mapper= new ObjectMapper();
        JsonSchemaFactory factory= JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        File f = new File("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\PostJson.json");
        InputStream s = new FileInputStream("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\src\\test\\resources\\schemaForNetworkNt.json");
        JsonNode jsonNode = mapper.readTree(f);
        JsonSchema schema = factory.getSchema(s);
        Set<ValidationMessage> result = schema.validate(jsonNode);

        if(result.isEmpty()){
            System.out.println("no erros");
        }else{
            for (ValidationMessage msg:result) {
                System.out.println(msg);
            }
        }
    }
    @Test
    void hamcrestJson() throws IOException {
        File json = new File("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\PostJson.json");
        String js = FileUtils.readFileToString(json, "UTF-8");
        File schema = new File("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\src\\test\\resources\\schemaForNetworkNt.json");
        MatcherAssert.assertThat(js,JsonSchemaValidator.matchesJsonSchema(schema));
    }
}
