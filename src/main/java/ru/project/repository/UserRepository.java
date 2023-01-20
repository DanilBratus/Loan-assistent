package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.project.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM app_user WHERE login=?1", nativeQuery = true)
    User getUserByLogin(String login);
}