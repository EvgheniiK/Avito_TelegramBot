import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Jo1 {


    public Jo1() throws IOException {
    }

    public static void main(String[] args) throws IOException {




//        Collection<String> ff = null;
//        ff.add("fff");
//        ff.add("fff555");

        JsonObjectBuilder builder = Json.createObjectBuilder();
       // JsonArrayBuilder builder2 = Json.createArrayBuilder(ff);
        builder.add("Item", "item");
        builder.add("Choice 1", "idchoice1");
        builder.add("Choice 2", "idchoice2");
        builder.add("Choice 3", "idchoice3");
        JsonObject jo = builder.build();

        try {
            Map<String, Object> properties = new HashMap<>(1);
            properties.put(JsonGenerator.PRETTY_PRINTING, true);
            FileWriter fw = new FileWriter("SelectedChoice.json", true);
            JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
            JsonWriter jsonWriter = writerFactory.createWriter(fw);
            jsonWriter.writeObject(jo);
            jsonWriter.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//
//    String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
//
//    String apiToken = "my_bot_api_token";
//    String chatId = "@my_channel_name";
//    String text = "Hello world!";
//
//    urlString = String.format(urlString, apiToken, chatId, text);
//
//    URL url = new URL(urlString);
//    URLConnection conn = url.openConnection();
//
//    StringBuilder sb = new StringBuilder();
//    InputStream is = new BufferedInputStream(conn.getInputStream());
//    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//    String inputLine = "";
//while ((inputLine = br.readLine()) != null) {
//        sb.append(inputLine);
//    }
//    String response = sb.toString();
//// Do what you want with response

}
