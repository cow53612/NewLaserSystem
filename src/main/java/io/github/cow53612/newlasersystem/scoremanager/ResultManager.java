package io.github.cow53612.newlasersystem.scoremanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cow53612.newlasersystem.records.ResultData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultManager {

    private static File file;
    private static ObjectMapper mapper;
    private static Map<Long, ResultData> data;

    private ResultManager() {}

    public static void addScore(long hash, ResultData result) {
        try {
            FileWriter fileWriter;

            data.put(hash, result);
            fileWriter = new FileWriter(file);
            fileWriter.write(mapper.writeValueAsString(data));
            fileWriter.close();
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void deleteScore(long hash) {
        try {
            FileWriter fileWriter;
            if (data.containsKey(hash)) {
                data.remove(hash);
                fileWriter = new FileWriter(file);
                fileWriter.write(mapper.writeValueAsString(data));
                fileWriter.close();
            }

        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static boolean isExist(long hash) {
        return data.containsKey(hash);
    }

    public static Map<Long, ResultData> getMap() {
        return data;
    }

    static {
        try {
            file = new File("data.json");
            mapper = new ObjectMapper();
            data = new LinkedHashMap<>();

            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fileReader = new FileReader(file);
            if (file.length() != 0) {
                Map<Long, Map<String, Object>> preData = mapper.readValue(fileReader, new TypeReference<>(){});

                for (Map.Entry<Long, Map<String, Object>> entry : preData.entrySet()) {
                    data.put(entry.getKey(), new ResultData(entry.getValue().get("name").toString(), (int) entry.getValue().get("score")));
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
