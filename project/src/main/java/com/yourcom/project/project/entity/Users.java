package com.yourcom.project.project.entity;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public Users(Long id,String name,String email,String password,Role role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }
    public Users update(String name){
        this. name = name;
        return this;

    }
    public String getRoleKey(){
        return this.role.getKey();
    }
}
