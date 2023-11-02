package io.github.cow53612.newlasersystem;

import io.github.cow53612.newlasersystem.records.ActionStatus;
import io.github.cow53612.newlasersystem.scoremanager.DataManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteResultController {

    @GetMapping("/deleteresult")
    public ActionStatus deleteResult(@RequestParam String name) {
        if (!DataManager.isExist(name)) {
            return new ActionStatus("FAILED", "NOT_EXIST");
        } else {
            DataManager.deleteScore(name);
            return new ActionStatus("SUCCESS", "NONE");
        }
    }

}
