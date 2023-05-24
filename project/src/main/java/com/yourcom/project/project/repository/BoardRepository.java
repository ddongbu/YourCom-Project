package com.yourcom.project.project.repository;

import com.yourcom.project.project.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {

    Page<Board> findByTitleContaining(String seachKeyword, Pageable pageable);


}
