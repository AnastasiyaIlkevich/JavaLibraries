package JsonSimpleAPI.Ex2;

public class Main {

    public static void main(String[] args) {
        JsonSimpleParser jsonSimpleParser = new JsonSimpleParser();
        Root root = jsonSimpleParser.parser();
        System.out.println(root.toString());
    }




}
