package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.project.model.Request;

public interface RequestRepository extends JpaRepository<Request, String> {
    @Query(value = "SELECT * FROM app_request WHERE login=?1 and status is null", nativeQuery = true)
    Request getRequestByStatus(String login);
}