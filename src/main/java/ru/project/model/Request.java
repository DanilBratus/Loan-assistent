package ru.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "app_request")
public class Request {
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    private String id_request = UUID.randomUUID().toString();
    @Column(name = "amountCredit", nullable = false)
    private Integer amountCredit;
    @Column(name = "rateCredit", nullable = false)
    private Double rateCredit;
    @Column(name = "termCredit", nullable = false)
    private Integer termCredit;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "secondName", nullable = false)
    private String secondName;
    @Column(name = "birthDay", nullable = false)
    private String birthDay;
    @Column(name = "status")
    private String status;
    @Column(name = "login")
    private String login;

    public Request() {
    }

    @Override
    public String toString() {
        return "Request{" +
                "amountCredit=" + amountCredit +
                ", rateCredit=" + rateCredit +
                ", termCredit=" + termCredit +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
