public class Jo4 {
    //это рабочий метод

    public static void main(String[] args) {


//        try (BufferedReader br2 = new BufferedReader(new FileReader("notes.json"))) {
//
////если файл пустой запиши строку, она нужна для входа в массив
//            if (br2.readLine() == null) {
//                String json = "{\"content\":[]}";
//                try (FileOutputStream fos = new FileOutputStream("notes.json")) {
//                    // перевод строки в байты
//                    byte[] buffer = json.toString().getBytes();
//
//                    fos.write(buffer, 0, buffer.length);
//                    System.out.println("в пустой файл записан базовый массив");
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//
//            }
//        } catch (Exception e) {
//        }

        //ид для проверки на наличие
        String id = "0241643062205520";
        String text = "Galaxy S20 FE 128gb Синий в идеале Оригинал\n26 500 ₽\nПродам ";
        String href=  "https://www.avito.ru";
        String img ="https://50.img.avito.st/image/1/1.k5K2oraBP3vAB819nNSqtlwBO30UBz99c2I7fcAHzX0ABTN_AAM_Pw.-PqvQejaU5O5lxmuBFgKdIHXhMkc1Hz9qaXiAP5_ib4";
        // try (BufferedReader br = new BufferedReader(new FileReader("notes.json"))) {
        //проверка существования ид
        //   String json2 = br.lines().collect(Collectors.joining());
        //  if (!json2.contains(id)) {
        //если ид существует то делай
        //    System.out.println("Такого ид нет в файле");

        MySerilization.isFileEmpty();

        if (MySerilization.checkId(id)) {
            MySerilization.serializationJson(id,text,href,img);

//            try (BufferedReader br3 = new BufferedReader(new FileReader("notes.json"))) {
//                //чтение построчно
//                String json = br3.lines().collect(Collectors.joining());
//
//                System.out.println(json);
//                Gson gson = new Gson();
//                JsonObject inputObj = gson.fromJson(json, JsonObject.class);
//                //создание json объекта
//                JsonObject newObject = new JsonObject();
//                newObject.addProperty("id", "2416430622");
//                newObject.addProperty("text", "Galaxy S20 FE 128gb Синий в идеале Оригинал\n26 500 ₽\nПродам ");
//                newObject.addProperty("href", "https://www.avito.0622");
//                newObject.addProperty("img", "https://06.img.avito.stjo");
//                //запись в массив "results"
//                inputObj.get("content").getAsJsonArray().add(newObject);
//                System.out.println(inputObj);
//
//                try (FileOutputStream fos = new FileOutputStream("notes.json")) {
//                    byte[] buffer = inputObj.toString().getBytes();
//                    //запись в файл всего json-a
//                    fos.write(buffer, 0, buffer.length);
//                    System.out.println("Json записан в файл");
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//
//
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
        }


        //  } catch (Exception c) {  System.out.println(c.getMessage()); }


    }

}



