package ru.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    private String id_user = UUID.randomUUID().toString();
    @Column(name = "password", nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String login;
    private String role;

    public User() {
    }
}