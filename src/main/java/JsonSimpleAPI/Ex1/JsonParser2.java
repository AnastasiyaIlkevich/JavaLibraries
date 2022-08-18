package JsonSimpleAPI.Ex1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParser2 {


    private static final String TAG_NAME = "name";
    private static final String TAG_ID = "id";
    private static final String TAG_PRICE = "price";
    private static final String TAG_DATE = "date";


    public List<Yandex> parser() {
        JSONParser parser = new JSONParser();
        List<Yandex> yandexList = new ArrayList<>();
        try (FileReader fileReader = new FileReader("Yandex2.json")) {

            // Потом мы получаем массив объектов [{},{},{}]
            JSONArray jsonArray = (JSONArray) parser.parse(fileReader);


            for (Object o : jsonArray) {
                JSONObject jsonObjectYandex = (JSONObject) o;
                Yandex yandex = new Yandex((Long) jsonObjectYandex.get(TAG_ID),
                        (String) jsonObjectYandex.get(TAG_NAME),
                        (Long) jsonObjectYandex.get(TAG_PRICE),
                        (String) jsonObjectYandex.get(TAG_DATE));
                yandexList.add(yandex);
            }

        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }


        return yandexList;
    }


}
