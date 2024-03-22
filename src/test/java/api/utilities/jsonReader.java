package api.utilities;
import api.payload.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class jsonReader {

    @DataProvider(name="JsonData")
    public static <T> T readJson(String fileName, Class<T> clazz){
        try (FileReader reader = new FileReader(fileName)) {
            // Create Gson object
            Gson gson = new Gson();
            // Deserialize JSON data into a Java object
            Type type = TypeToken.getParameterized(clazz).getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
