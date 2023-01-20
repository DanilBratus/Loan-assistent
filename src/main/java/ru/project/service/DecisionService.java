package ru.project.service;

import com.sun.istack.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.project.model.Condition;
import ru.project.model.Request;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DecisionService {
    @NotNull
    private final RequestService requestService;
    @NotNull
    private final CompareService compareService;
    @NotNull
    private final UserService userService;

    public DecisionService(RequestService requestService, CompareService compareService, UserService userService) {
        this.requestService = requestService;
        this.compareService = compareService;
        this.userService = userService;
    }

    public List<String> decisionBank(List<String> bankNames) {
        Request request = requestService.getRequest(userService.getUserByLogin(getCurrentUsername()));
        List<Condition> conditionList = compareService.compareCondition(request).stream().filter(con -> bankNames.contains(con.getBankName()))
                .collect(Collectors.toList());
        LocalDate currentDate = LocalDate.now();
        LocalDate berthYear = LocalDate.parse(request.getBirthDay());
        List<String> decisionList = new ArrayList<>();

        long age = ChronoUnit.YEARS.between(berthYear, currentDate);
        for (Condition con: conditionList) {
            if (age < con.getMaxAge() && age > con.getMinAge()) {
                requestService.deleteRequest(request);
                decisionList.add(getStringDecision(con.getBankName()));
            } else {
                requestService.deleteRequest(request);
                decisionList.add(getStringRefusal(con.getBankName()));
            }
        }
        return decisionList;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    private String getStringDecision(String bankName) {
        return "\t\t\t\t\tВам одобрено!\n" +
                "Свяжитесь с банком " + bankName + " по телефону 8-800-XXX-XX-XX или придите в отделение банка.";
    }

    private String getStringRefusal(String bankName) {
        return "\t\t\t\t\tИзвините в " + bankName + " вам отказано";
    }
}