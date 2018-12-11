import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import domain.Client;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class RTest {
//    @Test
    public void ggggson() {
        String json = "{\"carePlan\":\"kutzoooooi\",\"fullName\":\"Dirk-Jan de Beijer\",\"birthday\":\"Sat Dec 08 2018 00:00:00 GMT+0100 (Central European Standard Time)\",\"gender\":\"MALE\"}";
        Client client = new Gson().fromJson(json, Client.class);

    }

//    @Test
    public void ggggson2() throws IOException {
//        String json = "{\"year\":2018,\"month\":11,\"day\":8}";
        String json = "12 08 2018 00:00:00";
        Date date = new Gson().fromJson(json, Date.class);

        ObjectMapper objectMapper = new ObjectMapper();
//        Date date = objectMapper.readValue(json, Date.class);
    }

//    @Test
    public void ggggson3() {
        String json = "{\"year\":2018,\"month\":11,\"day\":8}";
        Timestamp date = new Gson().fromJson(json, Timestamp.class);

    }
}
