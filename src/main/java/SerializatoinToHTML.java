import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SerializatoinToHTML {

    /**
     * Get the JSON data formated in HTML
     */
    public static String getHtmlData(String strJsonData) {

        String heder = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
                "    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "\n" +
                "<style>\n" +
                "\n" +
                ".json_object { margin:1px;  }\n" +
                ".json_key { font-weight: bold; }\n" +
                "</style>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "<title>Avito Bot</title>\n" +
                "</head>\n" +
                "<body lang=\"EN-US\">\n" +
                "     \n" +
                "\n";
        String body = jsonToHtml(new JSONObject(strJsonData));
        String foter = "     \n" +
                "</body>\n" +
                "</html>";

        String out =heder +body+foter ;

        return out;

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



}


