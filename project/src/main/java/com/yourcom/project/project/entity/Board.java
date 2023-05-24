package com.yourcom.project.project.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //DB에 있는 테이블을 의미함
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY는 마리아디비
    private Integer id;
    private String title;
    private String content;
    private String filename;
    private String filepath;

    @Column(name = "regdate")
    @CreationTimestamp //INSERT 시 자동으로 값을 채워줌
    private LocalDateTime regdate = LocalDateTime.now();

    @Column(name = "updatedate")
    @UpdateTimestamp // UPDATE 시 자동으로 값을 채워줌
    private LocalDateTime updatedate = LocalDateTime.now();
}
