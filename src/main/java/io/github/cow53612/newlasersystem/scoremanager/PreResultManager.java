package io.github.cow53612.newlasersystem.scoremanager;

import io.github.cow53612.newlasersystem.records.ResultData;

import java.util.HashMap;
import java.util.Map;

public class PreResultManager {

    private static final Map<Long, Integer> preData = new HashMap<>();

    public static void addPreData(long hash, int score) {
        preData.put(hash, score);
    }

    public static ResultData getPreData(long hash) {
        return new ResultData(hash, preData.get(hash));
    }

    public static boolean exists(long hash) {
        return preData.containsKey(hash);
    }

}
