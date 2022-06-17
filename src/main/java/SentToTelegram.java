import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SentToTelegram {
    private static HttpURLConnection con;
    private static String tgToken = "5004569575:AAFB67y36Il-d-rFWS2DrdiWNpLovGrxeg4";
    private static String  chatId = "350218053";
    private static String urlToken = "https://api.telegram.org/bot"+tgToken+"/sendMessage";

    public  void sentBot(String txt) throws IOException {
        //текст сообщения
       // String txt = "Нужный параметр изменился!";

        String urlParameters = "chat_id="+chatId+"&text="+txt;


        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        try {

            URL url = new URL(urlToken);
            con = (HttpURLConnection) url.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java upread.ru client");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }

            StringBuilder content;

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());

        } finally {
            con.disconnect();
        }
    }
}