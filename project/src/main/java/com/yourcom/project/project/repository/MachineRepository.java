package com.yourcom.project.project.repository;

import com.yourcom.project.project.entity.MachineEntity;
import com.yourcom.project.project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Integer> {
    String findCpuById(Integer id);

    @Query("SELECT m.cpu FROM MachineEntity m")
    List<String> findAllCpu();
    @Query("SELECT m.mainboard FROM MachineEntity m where m.mainboard is not null")
    List<String> findAllMainboard();
    @Query("SELECT m.ssd FROM MachineEntity m where m.ssd is not null")
    List<String> findAllSsd();
    @Query("SELECT m.gpu FROM MachineEntity m where m.gpu is not null")
    List<String> findAllGpu();
    @Query("SELECT m.power FROM MachineEntity m where m.power is not null")
    List<String> findAllPower();
}

