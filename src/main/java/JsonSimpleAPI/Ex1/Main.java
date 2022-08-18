package JsonSimpleAPI.Ex1;

public class Main {
    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();
        System.out.println(jsonParser.parser());
        JsonParser2 jsonParser2 = new JsonParser2();
        System.out.println(jsonParser2.parser());
    }
}
