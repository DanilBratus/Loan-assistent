package ru.project.service;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import ru.project.model.Request;
import ru.project.model.User;
import ru.project.repository.RequestRepository;

@Service
public class RequestService {
    @NotNull
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request getRequest(User user) {
        return requestRepository.getRequestByStatus(user.getLogin());
    }

    public Request save(Request request) {
        requestRepository.save(request);
        return request;
    }

    public void deleteRequest(Request request) {
        requestRepository.delete(request);
    }
}
