package com.yourcom.project.project.service;

import com.yourcom.project.project.entity.MachineEntity;
import com.yourcom.project.project.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    private final MachineRepository machineRepository;

    @Autowired
    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public MachineEntity saveMachine(MachineEntity machine) {
        return machineRepository.save(machine);
    }

    public MachineEntity getMachineById(Integer id) {
        return machineRepository.findById(id).orElse(null);
    }

    public List<MachineEntity> getAllMachines() {
        return machineRepository.findAll();
    }

    // You can add more methods for additional operations on the machines

    public String getCpuById(Integer id) {
        return machineRepository.findCpuById(id);
    }
    public List<String> getAllCpu() {
        return machineRepository.findAllCpu();
    }
    public List<String> getAllMainboard() {
        return machineRepository.findAllMainboard();
    }
    public List<String> getAllSsd() {
        return machineRepository.findAllSsd();
    }
    public List<String> getAllGpu() {
        return machineRepository.findAllGpu();
    }
    public List<String> getAllPower() {
        return machineRepository.findAllPower();
    }
}
