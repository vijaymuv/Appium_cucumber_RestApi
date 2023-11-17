package RestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class Pojo_Runner {
    public static void main(String[] args) throws JsonProcessingException {
        PojoJson json = new PojoJson();
        json.setAge("200");
        json.setName("wayne");
        json.setEmail("wayne2@gmail.com");
        json.setSkills(Arrays.asList("RestApi","postman"));

        System.out.println(json.getAge());
        System.out.println(json.getEmail());
        System.out.println(json.getName());
        System.out.println(json.getSkills());

        ObjectMapper mapper = new ObjectMapper();
        String objJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        System.out.println(objJson);
    }
}
