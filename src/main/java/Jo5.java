import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Jo5 {



    public static void main(String[] args) {
        try {
            JSONObject dataset = new JSONObject();
            dataset.put("genre_id", 1);
            dataset.put("genre_parent_id", JSONObject.NULL);
            dataset.put("genre_title", "International");
            // use the accumulate function to add to an existing value. The value
            // will now be converted to a list
            dataset.accumulate("genre_title", "Pop");
            // append to the key
            dataset.append("genre_title", "slow");
            dataset.put("genre_handle", "International");
            dataset.put("genre_color", "#CC3300");
            // get the json array for a string
            System.out.println(dataset.getJSONArray("genre_title"));
            // prints ["International","Pop","slow"]
            // increment a number by 1
            dataset.increment("genre_id");
            // quote a string allowing the json to be delivered within html
            System.out.println(JSONObject.quote(dataset.toString()));
            System.out.println("\n\nWrite to the file:\n\n");
            System.out.println(dataset.toString());

            FileWriter fw = new FileWriter(new File("myJsonObj.json"));
            fw.write(dataset.toString());
            fw.close();

            // prints
            // "{\"genre_color\":\"#CC3300\",\"genre_title\":[\"International\",\"Pop\",\"slow\"],
            // \"genre_handle\":\"International\",\"genre_parent_id\":null,\"genre_id\":2}"
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
