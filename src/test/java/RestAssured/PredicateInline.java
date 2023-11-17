package RestAssured;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PredicateInline {
//    @Test
    void inlinePredicate() throws IOException {
        File f = new File("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\src\\test\\resources\\Jayway_jsonFile.json");
        List<Object> ids = JsonPath.parse(f).read("$.employees.employee[?(@.age>200 || @.work=='it')]");
        //$.employees.employee[?(@.age>200 || @.work=='it')]
        //$.employees.employee[?(!(@.age>200 || @.work=='it'))]
        //"$.employees.employee[?(@.age>200)]");
        System.out.println(ids);
    }
//    @Test
    void filterApi_Predicate() throws IOException {
        File f = new File("C:\\Users\\Friday\\IdeaProjects\\Api_TestNg\\src\\test\\resources\\Jayway_jsonFile.json");
         Filter ageLessThan200 = Filter.filter(Criteria.where("age").lt(200));
         Object age=  JsonPath.parse(f).read("$.employees.employee[?]",ageLessThan200);
        System.out.println(age);

        //using and operator

        Filter ageAndWork = Filter.filter(Criteria.where("age").gt(90).and("work").is("it"));
        //List<Object> age_and_work =JsonPath.parse(f).read("$.employees.employee[?]",ageAndWork);
        List<Map<String,Object>> age_and_work =JsonPath.parse(f).read("$.employees.employee[?]",ageAndWork);
        System.out.println(age_and_work.get(0).get("age"));
         //
        Filter filter = Filter.filter(Criteria.where("age").gte(90).and("work").is("bpo"));
        List<Map<String,Object>>  read = JsonPath.parse(f).read("$.employees.employee[?]", filter);
        System.out.println(read);

    }

    @Test
    void custom_Predicate(){

        Predicate pre   = new Predicate() {
            @Override
            public boolean apply(PredicateContext predicateContext) {
                return false;
            }
        };

    }
}
