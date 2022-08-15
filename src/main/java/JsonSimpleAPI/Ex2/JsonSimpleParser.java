package JsonSimpleAPI.Ex2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonSimpleParser {

    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_PEOPLE = "people";
    private static final String TAG_NAME = "name";
    private static final String TAG_AGE = "age";


    public Root parser() {

        Root root = new Root();


        JSONParser parser = new JSONParser(); //инструмент для парсинга.
        try (FileReader fileReader = new FileReader("test.json");) {//Считыватель с файла.

            JSONObject rootJSONObject = (JSONObject) parser.parse(fileReader);
            String name = (String) rootJSONObject.get(TAG_NAME_MAIN);

            JSONArray peopleJSONArray = (JSONArray)rootJSONObject.get(TAG_PEOPLE);

            List<People> peopleList= new ArrayList<>();
            for (Object o : peopleJSONArray){
                JSONObject peopleJsonObject = (JSONObject) o;

                String peopleName = (String)peopleJsonObject.get(TAG_NAME);
                Long age = (Long) peopleJsonObject.get(TAG_AGE);
                People people = new People(peopleName,age);
                peopleList.add(people);
            }


            root.setName(name);
            root.setPeople(peopleList);
            return root;


        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }


        return null;

    }
}
