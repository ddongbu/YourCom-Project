package com.yourcom.project.project.controller;

import com.yourcom.project.project.entity.MachineEntity;
import com.yourcom.project.project.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MachineController {
    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping("/machines")
    public String saveMachine(MachineEntity machine) {
        machineService.saveMachine(machine);
        return "redirect:/estimate"; // Redirect to a success page or any other page as needed
    }


    @GetMapping("/MachineInsert")
    public String index(){
        return "MachineInsert";
    }

}
