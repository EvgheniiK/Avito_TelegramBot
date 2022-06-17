import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class MySerilization {

    public MySerilization() {
    }

    //проверка существования ид
    public static boolean checkId(String id) {

        boolean isEnable = false;

        try (BufferedReader br = new BufferedReader(new FileReader("notes.json"))) {

            String json = br.lines().collect(Collectors.joining());

            if (!json.contains(id)) {

                System.out.println("Такого ид нет в notes.json  " + id);
                isEnable = true;

            } else {
                System.out.println("Такой ИД уже есть в notes.json  " +id);
            }
        } catch (Exception d) {
        }

        return isEnable;
    }


    public static void isFileEmpty() {
        try (BufferedReader br2 = new BufferedReader(new FileReader("notes.json"))) {

//если файл пустой запиши строку, она нужна для входа в массив
            if (br2.readLine() == null) {
                String json = "{\"content\":[]}";
                try (FileOutputStream fos = new FileOutputStream("notes.json")) {
                    // перевод строки в байты
                    byte[] buffer = json.toString().getBytes();

                    fos.write(buffer, 0, buffer.length);
                    System.out.println("в пустой файл записан базовый массив");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        } catch (Exception e) {
        }

    }


    public static void serializationJson(String id, String text, String href, String img) {

        try (BufferedReader br3 = new BufferedReader(new FileReader("notes.json"))) {
            //чтение построчно
            String json = br3.lines().collect(Collectors.joining());

            Gson gson = new Gson();
            JsonObject inputObj = gson.fromJson(json, JsonObject.class);
            //создание json объекта
            JsonObject newObject = new JsonObject();
            newObject.addProperty("id", id);
            newObject.addProperty("text", text);
            newObject.addProperty("href", href);
            newObject.addProperty("img", img);
            //запись в массив "results"
            inputObj.get("content").getAsJsonArray().add(newObject);
            //запись в json файл
            WriterToFile.writeToJsonFile(inputObj);
            //запись в html файл
            WriterToFile.writeHTMLFile(SerializatoinToHTML.getHtmlData(inputObj.toString()));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
