package Ex1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        YandexJsonParser jsonParser = new YandexJsonParser();
        List<Yandex> yandexList = jsonParser.parser();
        List<String[]> strings = jsonParser.read();
        System.out.println(yandexList);
        for (String[] string : strings) {
            System.out.println(Arrays.toString(string));
        }

        String[] strings2 = strings.get(0);
        int price = Integer.parseInt(strings2[1]);

        String[] strings3 = strings.get(3);
        int price2 = Integer.parseInt(strings3[1]);

        String[] strings1 = strings.get(2);
        String name = strings1[1];

        Iterator<Yandex> iterator = yandexList.iterator();
        while (iterator.hasNext()) {
            Yandex next = iterator.next();

            if (next.getName().contains(name)&&next.getPrice()<=price&&next.getPrice()>=price2){
                System.out.println(next);
            }
        }
    }
}


class Yandex {

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


    public String getName() {
        return name;
    }


    public Long getPrice() {
        return price;
    }

}



class YandexJsonParser {

    private static final String TAG_NAME = "name";
    private static final String TAG_ID = "id";
    private static final String TAG_PRICE = "price";
    private static final String TAG_DATE = "date";

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public List<Yandex> parser() throws IOException {
        JSONParser parser = new JSONParser();
        List<Yandex> yandexList = new ArrayList<>();

        String str =bufferedReader.readLine();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (Object o : jsonArray) {
            JSONObject jsonObjectYandex = (JSONObject) o;
            Yandex yandex = new Yandex((Long) jsonObjectYandex.get(TAG_ID),
                    (String) jsonObjectYandex.get(TAG_NAME),
                    (Long) jsonObjectYandex.get(TAG_PRICE),
                    (String) jsonObjectYandex.get(TAG_DATE));
            yandexList.add(yandex);
        }
        return yandexList;
    }

    public List<String[]> read() throws IOException {
        List<String[]>strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(bufferedReader.readLine().split(" "));
        }
        return strings;
    }
}
