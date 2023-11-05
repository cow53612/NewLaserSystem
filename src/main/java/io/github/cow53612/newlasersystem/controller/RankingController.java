package io.github.cow53612.newlasersystem.controller;

import io.github.cow53612.newlasersystem.records.ResultData;
import io.github.cow53612.newlasersystem.scoremanager.ResultManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class RankingController {

    @GetMapping(value="/ranking")
    public String ranking(Model model) {
        List<ResultData> ranking = new LinkedList<>();

        for (Map.Entry<Long, ResultData> entry : ResultManager.getMap().entrySet()) {
            ranking.add(entry.getValue());
        }

        ranking.sort((result1, result2) -> result2.score() - result1.score());

        model.addAttribute("ranking", ranking);
        return "ranking";
    }
    @GetMapping(value="/ranking-easy")
    public String rankingEasy(Model model) {
        List<ResultData> ranking = new LinkedList<>();

        for (Map.Entry<Long, ResultData> entry : ResultManager.getMap().entrySet()) {
            if (entry.getValue().type().equals("1")) {
                ranking.add(entry.getValue());
            }
        }

        ranking.sort((result1, result2) -> result2.score() - result1.score());

        model.addAttribute("ranking", ranking);
        return "ranking-easy";
    }

    @GetMapping(value="/ranking-normal")
    public String rankingNormal(Model model) {
        List<ResultData> ranking = new LinkedList<>();

        for (Map.Entry<Long, ResultData> entry : ResultManager.getMap().entrySet()) {
            if (entry.getValue().type().equals("2")) {
                ranking.add(entry.getValue());
            }
        }

        ranking.sort((result1, result2) -> result2.score() - result1.score());

        model.addAttribute("ranking", ranking);
        return "ranking-normal";
    }

    @GetMapping(value="/ranking-hard")
    public String rankingHard(Model model) {
        List<ResultData> ranking = new LinkedList<>();

        for (Map.Entry<Long, ResultData> entry : ResultManager.getMap().entrySet()) {
            if (entry.getValue().type().equals("3")) {
                ranking.add(entry.getValue());
            }
        }

        ranking.sort((result1, result2) -> result2.score() - result1.score());

        model.addAttribute("ranking", ranking);
        return "ranking-hard";
    }

}
