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

}
