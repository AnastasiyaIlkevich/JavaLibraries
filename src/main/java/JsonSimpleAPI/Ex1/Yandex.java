package JsonSimpleAPI.Ex1;

public class Yandex {

    private Long id;
    private String name;
    private Long price;
    private String date;

    public Yandex(Long id, String name, Long price, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Yandex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
