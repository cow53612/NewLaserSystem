package io.github.cow53612.newlasersystem;

import io.github.cow53612.newlasersystem.model.RegisterName;
import io.github.cow53612.newlasersystem.scoremanager.DataManager;
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
    public String registerForm(@RequestParam(value = "hash") long hash, Model model) {
        if (!PreResultManager.exists(hash)) {
            return "invalidhash";
        } else {
            model.addAttribute("registername", new RegisterName());
            model.addAttribute("hash", hash);
            return "registername";
        }
    }

    @PostMapping("/registername")
    public String registerSubmit(@RequestParam(value = "hash") long hash, @ModelAttribute RegisterName registerName, Model model) {
        DataManager.addScore(registerName.getName(), PreResultManager.getPreData(hash));

        model.addAttribute("registername", registerName);
        model.addAttribute("hash", hash);
        return "result";
    }

}
