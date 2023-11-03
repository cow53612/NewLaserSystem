package io.github.cow53612.newlasersystem.controller;

import io.github.cow53612.newlasersystem.model.Name;
import io.github.cow53612.newlasersystem.records.ResultData;
import io.github.cow53612.newlasersystem.scoremanager.ResultManager;
import io.github.cow53612.newlasersystem.scoremanager.PreResultManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterNameController {

    @GetMapping("/registername")
    public String registerForm(@RequestParam(value = "hash", required = false) Long hash, Model model) {
        if (hash == null){
            return "invalidparam";
        }
        else if (!PreResultManager.exists(hash)) {
            return "invalidhash";
        } else if (ResultManager.isExist(hash)) {
            return "alreadyregistered";
        } else {
            model.addAttribute("name", new Name());
            model.addAttribute("hash", hash);
            return "registername";
        }
    }

    @PostMapping("/registername")
    public String registerSubmit(@RequestParam(value = "hash") long hash, @ModelAttribute Name name, Model model) {
        ResultManager.addScore(hash, new ResultData(name.getName(), PreResultManager.getScore(hash)));

        model.addAttribute("name", name);
        model.addAttribute("hash", hash);
        return "result";
    }

}
