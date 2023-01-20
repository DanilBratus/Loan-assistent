package ru.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "condition_credit")
public class Condition {
    @Id
    @Column(name = "id_condition")
    private Integer id;
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "amount_credit", nullable = false)
    private Integer amountCredit;
    @Column(name = "rate_credit", nullable = false)
    private Double rateCredit;
    @Column(name = "term_credit", nullable = false)
    private Integer termCredit;
    @Column(name = "min_age")
    private Integer minAge;
    @Column(name = "max_age")
    private Integer maxAge;

    public Condition() {
    }

    @Override
    public String toString() {
        return "Condition{" +
                "bankName='" + bankName + '\'' +
                ", amountCredit=" + amountCredit +
                ", rateCredit=" + rateCredit +
                ", termCredit=" + termCredit +
                '}';
    }
}
