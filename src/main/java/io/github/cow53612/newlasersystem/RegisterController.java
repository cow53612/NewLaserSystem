package io.github.cow53612.newlasersystem;

import io.github.cow53612.newlasersystem.records.ActionStatus;
import io.github.cow53612.newlasersystem.scoremanager.PreResultManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @GetMapping("/register")
    public ActionStatus register(@RequestParam(value = "hash") long hash, @RequestParam(value = "score") int score) {
        if (score < 0) {
            return new ActionStatus("FAILED", "SCORE_INVALID");
        } else if (PreResultManager.exists(hash)) {
            return new ActionStatus("FAILED", "ALREADY_REGISTERED");
        } else {
            PreResultManager.addPreData(hash, score);
            return new ActionStatus("SUCCESS", "NONE");
        }
    }

}
