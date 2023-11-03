package io.github.cow53612.newlasersystem.controller;

import io.github.cow53612.newlasersystem.records.ActionStatus;
import io.github.cow53612.newlasersystem.scoremanager.ResultManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteNameController {

    @GetMapping("/deletename")
    public ActionStatus deleteResult(@RequestParam long hash) {
        if (!ResultManager.isExist(hash)) {
            return new ActionStatus("FAILED", "NOT_EXIST");
        } else {
            ResultManager.deleteScore(hash);
            return new ActionStatus("SUCCESS", "NONE");
        }
    }

}
