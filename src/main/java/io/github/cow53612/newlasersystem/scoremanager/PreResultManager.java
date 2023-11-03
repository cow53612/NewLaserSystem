package io.github.cow53612.newlasersystem.scoremanager;

import java.util.HashMap;
import java.util.Map;

public class PreResultManager {

    private static final Map<Long, Integer> preData = new HashMap<>();

    public static void addPreData(long hash, int score) {
        preData.put(hash, score);
    }

    public static int getScore(long hash) {
        return preData.get(hash);
    }

    public static boolean exists(long hash) {
        return preData.containsKey(hash);
    }

    static {
        preData.put(114514L, 810);
        preData.put(114515L, 114514191);
        preData.put(114516L, 5);
    }

}
