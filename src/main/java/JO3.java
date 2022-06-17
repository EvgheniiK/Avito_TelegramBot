import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class JO3 {

    public static void main(String[] args) throws IOException {

        String jsonData = "{\"results\":[{\"lat\":\"value\",\"lon\":\"value\" }]}";
        System.out.println(jsonData);
        try {
            JSONArray result = new JSONObject(jsonData).getJSONArray("results");
            result.getJSONObject(0).put("city","Singapore");
            jsonData = "{\"results\":"+result.toString()+"}";
            System.out.println(jsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }


//        JsonFactory factory = new JsonFactory();
//        ObjectMapper mapper = new ObjectMapper(factory);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString("car.json");
//        ObjectNode node = (ObjectNode) mapper.readTree(json);
//        node.putPOJO("new Key","new value");


//        try {
//            File file = new File("test.json");
//            FileWriter fileWriter = new FileWriter(file, true);
//
//            ObjectMapper mapper = new ObjectMapper();
//
//            SequenceWriter seqWriter = mapper.writerWithDefaultPrettyPrinter().writeValuesAsArray(fileWriter);

//            seqWriter.write("new  20");
//           // seqWriter.write(new Person("Bar", 30));
//            seqWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


}}
