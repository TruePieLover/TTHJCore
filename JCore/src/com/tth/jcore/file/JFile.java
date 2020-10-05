/*************************************
 *     TTHJPieCore vTTHDevBuild1.0
 * @author Pie
 * @module com.tth.jcore.file
 * @copyright: TTH2020
 * @version TTH Development Build 1.0
 * @data 9/25/2020
 * @description Handle TTHJC files/serializing data
 ************************************/
package com.tth.jcore.file;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * JFile.java:
 *  Main java class for our file manager using google gson serialization methods
 */
public class JFile {

    /* Fields for JSON parsing */
    public Gson m_gsonObj; // Global class var to our main GSON object used to read/write data

    public JFile() {

    }

    /* Initialize and create the json file */
    public void InitJsonFile()
    {
        try {
            // create a map
            Map<String, Object> map = new HashMap<>();
            map.put("name", "John Deo");
            map.put("email", "john.doe@example.com");
            map.put("roles", new String[]{"Member", "Admin"});
            map.put("admin", true);
            Writer writer = new FileWriter("user.json");
            new Gson().toJson(map, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ReadJsonFile()
    {
        m_gsonObj = new GsonBuilder().setPrettyPrinting().create();
        JData data = new JData("root","pass");
        String jsonObj = m_gsonObj.toJson(data);
        System.out.println(jsonObj);

    }



}
