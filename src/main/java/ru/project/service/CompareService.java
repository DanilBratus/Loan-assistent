package ru.project.service;

import com.sun.istack.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.project.model.Condition;
import ru.project.model.Request;
import ru.project.util.PeriodUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompareService {
    @NotNull
    private final ConditionService conditionService;
    @NotNull
    private final RequestService requestService;
    @NotNull
    private final UserService userService;

    public CompareService(ConditionService conditionService, RequestService requestService, UserService userService) {
        this.conditionService = conditionService;
        this.requestService = requestService;
        this.userService = userService;
    }

    public List<Condition> compareCondition(Request request) {
        String login = userService.getUserByLogin(getCurrentUsername()).getLogin();
        request.setLogin(login);
        requestService.save(request);
        Collection<Condition> conditions = conditionService.getAllCondition();
        List<Condition> conditionsList = conditions.stream()
               .filter(amount -> amount.getAmountCredit() < request.getAmountCredit() * PeriodUtil.maxPeriod &&
                       amount.getAmountCredit() > request.getAmountCredit() * PeriodUtil.minPeriod)
               .filter(rate -> rate.getRateCredit() < request.getRateCredit() * PeriodUtil.maxPeriod &&
                       rate.getRateCredit() > request.getRateCredit() * PeriodUtil.minPeriod)
               .filter(time -> time.getTermCredit() < request.getTermCredit() * PeriodUtil.maxPeriod &&
                       time.getTermCredit() > request.getTermCredit() * PeriodUtil.minPeriod)
               .collect(Collectors.toList());
        if (conditionsList.size() == 0) {
            requestService.deleteRequest(request);
        }
        return conditionsList;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
