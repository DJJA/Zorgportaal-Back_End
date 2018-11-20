package util;

import com.google.gson.Gson;
import com.google.protobuf.Type;

public class JSONConverter {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

//    public static Type fromJson(String json, Type type) {
//        return new Gson().fromJson(json, type);
//    }
}
