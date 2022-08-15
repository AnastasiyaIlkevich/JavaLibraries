package JsonSimpleAPI.Ex2;

public class People {

    private  String name;
    private Long age;

    public People(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
