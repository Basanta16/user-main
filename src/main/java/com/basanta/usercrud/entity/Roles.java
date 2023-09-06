package com.basanta.usercrud.entity;

import com.basanta.usercrud.Enum.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(length = 15)
    private RoleName roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRoles> userRoles = new HashSet<>();
}
