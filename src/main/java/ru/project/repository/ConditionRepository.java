package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.model.Condition;

public interface ConditionRepository extends JpaRepository<Condition, String> {
}