package JsonSimpleAPI.Ex2;

import java.util.List;

public class Root {
    private String name;
    private List<People> people;

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setPeople(List<People> people) {
        this.people = people;
    }
}
