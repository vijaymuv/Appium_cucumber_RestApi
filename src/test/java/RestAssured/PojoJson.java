package RestAssured;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;

//@Getter
//@Setter
public class PojoJson {
    private String name;
    private String email;
    private String age;

    private List skills;

    @JsonGetter(value="stones")
    public List getSkills() {
        System.out.println("getter "+skills);
        return skills;
    }

    public void setSkills(List skills) {
        System.out.println("setter "+skills);
        this.skills = skills;

    }

    public String getName() {
        System.out.println("getname"+name);
        return name;
    }

    public void setName(String name) {
        System.out.println("setname"+name);
        this.name = name;
    }

    public String getEmail() {
        System.out.println("get email"+email);
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setemail"+email);
        this.email = email;
    }

    public String getAge() {
        System.out.println("getage"+age);
        return age;
    }

    public void setAge(String age) {
        System.out.println("setage"+age);
        this.age = age;
    }

}
