package ru.project.service;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import ru.project.model.Condition;
import ru.project.repository.ConditionRepository;

import java.util.Collection;

@Service
public class ConditionService {
    @NotNull
    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public Collection<Condition> getAllCondition() {
        return conditionRepository.findAll();
    }
}
