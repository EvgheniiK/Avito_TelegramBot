import com.google.gson.JsonObject;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriterToFile {




    public static void writeToJsonFile(JsonObject inputObj){
        try (FileOutputStream fos = new FileOutputStream("notes.json")) {
            byte[] buffer = inputObj.toString().getBytes();
            //запись в файл всего json-a
            fos.write(buffer, 0, buffer.length);
            System.out.println("Json записан в файл");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void writeHTMLFile(String inputObj){
        try (FileOutputStream fos = new FileOutputStream("notes.html")) {
            byte[] buffer = inputObj.getBytes();
            //запись в файл всего html
            fos.write(buffer, 0, buffer.length);
            System.out.println("html записан в файл");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



}
