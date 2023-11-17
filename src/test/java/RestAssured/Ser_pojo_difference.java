package RestAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ser_pojo_difference {
    @Test
    void serilize() throws JsonProcessingException {
        PojoJson js = new PojoJson();
        js.setName("ThanosKing");
        js.setEmail("ThanosKing@gmail.com");
        js.setAge("200");
        js.setSkills(Arrays.asList("powerstone","spacestone"));
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(js);
        System.out.println(s);

    }
    @Test
    void AnyJsonGetterPojo() throws JsonProcessingException {
       JsonAnygetter_Pojo JsonAnygetter_Pojo = new JsonAnygetter_Pojo();
        Map<String,Object> json=new HashMap<>();
        json.put("name","tony");
        json.put("email","tony@gmail.com");
        json.put("age","200");
        json.put("Skills",Arrays.asList("Ai","knowledge"));
        JsonAnygetter_Pojo.setJson(json);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(JsonAnygetter_Pojo);
        System.out.println(s);

    }



}
