import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jo6 {

    public static void main(String[] args) {

        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("name", "john paul");
        jsonObj.addProperty("age", "35");
        jsonObj.addProperty("city", "Irvine");

        System.out.println("Json Object: " + jsonObj);

        System.out.println("Check if key \"city\" exists : " +
                checkIfKeyExists(jsonObj.toString(), "city"));

        System.out.println("Check if key \"state\" exists : " +
                checkIfKeyExists(jsonObj.toString(), "state"));


        /////

        String jsonString = "{ \"name\":\"John\"}";

        JsonObject jsonObjectAlt = JsonParser.parseString(jsonString).getAsJsonObject();
        // Shows deprecated warning for new JsonParser() and parse(jsonString)
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
       // jsonObject.
//
//        assertTrue(jsonObjectAlt.equals(jsonObject));

//обёртка для строки в jsonObject
        //  JsonObject jsonObject2 = JsonParser.parseString(jsonString).getAsJsonObject();
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java");
        Matcher matcher = pattern.matcher(input);
        boolean ff;
        if (input.contains("ava")) {
            System.out.println("+++++");
        }
        if (matcher.find()) {
            ff = true;
            System.out.println(matcher.group());
            System.out.println(ff);
        }

    }

    public static JsonElement checkIfKeyExists(String response, String key) {
        //  JsonParser parser = new JsonParser();
        //  JsonObject jsonObject = parser.parse(response).getAsJsonObject();
        //  JsonArray jsonArray = JsonParser.parseString(response).getAsJsonArray();
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        // return  jsonArray.getAsString();

        return jsonObject.get(key);

    }


}
