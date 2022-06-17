import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SerilizOld {

    JsonObjectBuilder empBuilder = Json.createObjectBuilder();
    JsonObjectBuilder contentBuilder = Json.createObjectBuilder();
    JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder();


    public SerilizOld() {
    }


    public void serilizationJson(String id, String text, String href, String img) throws FileNotFoundException {


        contentBuilder.add("text", text)
                .add("href", href)
                .add("img", img);
        empBuilder.add("id", id);
        empBuilder.add("content", contentBuilder);
        phoneNumBuilder.add(empBuilder);
        // JsonObject empJsonObject = empBuilder.build();
        JsonArray empJsonObject = phoneNumBuilder.build();
        //  System.out.println("JSON String\n"+empJsonObject);

        //write to file
        OutputStream os = new FileOutputStream("emp.json", true);
        JsonWriter jsonWriter = Json.createWriter(os);
        jsonWriter.writeArray(empJsonObject);
        jsonWriter.close();


    }

    //  public void closeJson(){jsonWriter.close();}
}

/*


    public static void main(String[] args) throws FileNotFoundException {

        Employee emp = createEmployee();

        JsonObjectBuilder empBuilder = Json.createObjectBuilder();
        JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
        JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder();

        for (long phone : emp.getPhoneNumbers()) {
            phoneNumBuilder.add(phone);
        }

        addressBuilder.add("street", emp.getAddress().getStreet())
                .add("city", emp.getAddress().getCity())
                .add("zipcode", emp.getAddress().getZipcode());

        empBuilder.add("id", emp.getId())
                .add("name", emp.getName())
                .add("permanent", emp.isPermanent())
                .add("role", emp.getRole());

        empBuilder.add("phoneNumbers", phoneNumBuilder);
        empBuilder.add("address", addressBuilder);

        JsonObject empJsonObject = empBuilder.build();

        System.out.println("Employee JSON String\n"+empJsonObject);

        //write to file
        OutputStream os = new FileOutputStream("emp2.txt");
        JsonWriter jsonWriter = Json.createWriter(os);
        */
/**
 * We can get JsonWriter from JsonWriterFactory also
 * JsonWriterFactory factory = Json.createWriterFactory(null);
 * jsonWriter = factory.createWriter(os);
 *//*

        jsonWriter.writeObject(empJsonObject);
        jsonWriter.close();
    }*/
