package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.print.Pageable;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("name");
        helloLombok.setAge(20);

        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
