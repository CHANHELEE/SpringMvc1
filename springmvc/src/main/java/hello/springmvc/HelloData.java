package hello.springmvc;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HelloData {
    private  String username;
    private  int age;

    public HelloData(String name, int age) {
        this.username = name;
        this.age = age;
    }

    public  HelloData(){}
}
