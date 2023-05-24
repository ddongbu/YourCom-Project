package com.yourcom.project.project.controller;

import com.yourcom.project.project.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private MachineService machineService;

    @Autowired
    public HomeController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/AfterMain")
    public String AfterMain(){
        return "AfterMain";
    }

    @GetMapping("/estimate")
    public String getMachine(Model model, Integer id) {
        List<String> cpus = machineService.getAllCpu();
        model.addAttribute("cpus", cpus);

        List<String> mainboards = machineService.getAllMainboard();
        model.addAttribute("mainboards", mainboards);

        List<String> ssds = machineService.getAllSsd();
        model.addAttribute("ssds", ssds);

        List<String> gpus = machineService.getAllGpu();
        model.addAttribute("gpus", gpus);

        List<String> powers = machineService.getAllPower();
        model.addAttribute("powers", powers);
        return "estimate";
    }
}
