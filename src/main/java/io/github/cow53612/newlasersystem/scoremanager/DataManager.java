package io.github.cow53612.newlasersystem.scoremanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cow53612.newlasersystem.records.ResultData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DataManager {

    private static File file;
    private static ObjectMapper mapper;
    private static HashMap<String, ResultData> data;

    private DataManager() {}

    public static void addScore(String name, ResultData result) {
        try {
            FileWriter fileWriter;
            if (!data.containsKey(name)) {
                data.put(name, result);
                fileWriter = new FileWriter(file);
                fileWriter.write(mapper.writeValueAsString(data));
                fileWriter.close();

            } else if (data.get(name).score() < result.score()) {
                data.put(name, result);
                fileWriter = new FileWriter(file);
                fileWriter.write(mapper.writeValueAsString(data));
                fileWriter.close();
            }

        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void deleteScore(String name) {
        try {
            FileWriter fileWriter;
            if (data.containsKey(name)) {
                data.remove(name);
                fileWriter = new FileWriter(file);
                fileWriter.write(mapper.writeValueAsString(data));
                fileWriter.close();
            }

        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(String name) {
        return data.containsKey(name);
    }

    public static int getSize() {
        return data.size();
    }

    static {
        try {
            file = new File("data.json");
            mapper = new ObjectMapper();
            data = new HashMap<>();

            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fileReader = new FileReader(file);
            if (file.length() != 0) {
                data = mapper.readValue(fileReader, data.getClass());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
