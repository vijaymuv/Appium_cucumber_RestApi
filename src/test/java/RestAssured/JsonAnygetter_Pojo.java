package RestAssured;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class JsonAnygetter_Pojo {

    @JsonAnyGetter
    public Map<String, Object> getJson() {
        return json;
    }

    public void setJson(Map<String, Object> json) {
        this.json = json;
    }

    private Map<String,Object> json;
}
