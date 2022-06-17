import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Jo7 {


    //  public static void main(String[] args) {


    /**
     * Get the JSON data formated in HTML
     */
    public static String getHtmlData(String strJsonData) {
        return jsonToHtml(new JSONObject(strJsonData));
    }

    /**
     * convert json Data to structured Html text
     *
     * @param //json
     * @return string
     */
    private static String jsonToHtml(Object obj) {
        StringBuilder html = new StringBuilder();

        try {
            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;
                String[] keys = JSONObject.getNames(jsonObject);

                html.append("<div class=\"json_object\">");

                if (keys.length > 0) {
                    for (String key : keys) {
                        // print the key and open a DIV
                        html.append("<div><span class=\"json_key\">")
                                .append(key).append("</span> : ");

                        Object val = jsonObject.get(key);
                        // recursive call
                        String img = "img";
                        String href = "href";
                        if (key.equals(img)) {

                            html.append("<img src=\" " + jsonToHtml(val) + "\"> ");
                        } else if (key.equals(href)) {
                            html.append("<a href=\"" + jsonToHtml(val) + "\"  target=\"_blank\">Посмотреть</a> <hr>");

                        } else {

                            html.append(jsonToHtml(val));
                            // close the div
                            html.append("</div>");
                        }

                    }
                }

                html.append("</div>");

            } else if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                for (int i = 0; i < array.length(); i++) {
                    // recursive call
                    html.append(jsonToHtml(array.get(i)));
                }
            } else {
                // print the value
                html.append(obj);
            }
        } catch (JSONException e) {
            return e.getLocalizedMessage();
        }

        return html.toString();
    }


    // }
}
//   FileWriter(String fileName, boolean append) ;
// FileWriter
//        try (BufferedReader br = new BufferedReader(new FileReader("notes.json"))){
//
//            String   json2 = br.lines().collect(Collectors.joining());
//            Pattern pattern = Pattern.compile("Java");
//            Matcher matcher = pattern.matcher(json2);
//            if (json2.contains("241643062")) {
//                System.out.println("+++++");}
//
//          //  System.out.println(json2);
//          //  JsonObject json3 = JsonParser.parseString(json2).getAsJsonObject();
//          //  JSONObject JsonObj = new JSONObject(json3); //JSONObject is an unordered collection of name/value pairs
//
//          //  System.out.println("Check if key \"lat\" exists : " +
//                  //  Jo6.checkIfKeyExists(json2, "results"));
//
////            if (JsonObj.has("lat") && !JsonObj.isNull("lat")) {
////                //Checking address Key Present or not
////                String get_address = JsonObj.getString("lat"); // Present Key
////                System.out.println("--------------");
////                System.out.println(get_address);
////                System.out.println("--------------");
////            }else {
////                System.out.println("++++");
////            }
//        }catch (Exception c){
//            System.out.println(c);
//        }

//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//
//
//public class AddJson {
//
//    public static void main(String[] args) {
//        String json = "{\"results\":[{\"lat\":\"value\",\"lon\":\"value\" }, { \"lat\":\"value\", \"lon\":\"value\"}]}";
//        Gson gson = new Gson();
//        JsonObject inputObj  = gson.fromJson(json, JsonObject.class);
//        JsonObject newObject = new JsonObject() ;
//        newObject.addProperty("lat", "newValue");
//        newObject.addProperty("lon", "newValue");
//        inputObj.get("results").getAsJsonArray().add(newObject);
//        System.out.println(inputObj);
//    }
//
//}