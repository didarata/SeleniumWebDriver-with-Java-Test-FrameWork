package com.gfk.saucedemo.vault;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class Jsonreader {
    public static String jsonUser(String item) throws IOException, ParseException {
        JSONParser jsonparse = new JSONParser();
        JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader("src/main/java/com/gfk/saucedemo/vault/database.json"));
        String jsonString = (String) jsonobject.get(item);
        return jsonString;
    }
}
