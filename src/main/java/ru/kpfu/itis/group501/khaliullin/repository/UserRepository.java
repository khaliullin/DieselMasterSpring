package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group501.khaliullin.model.Status;
import ru.kpfu.itis.group501.khaliullin.model.User;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login = :login")
    User findOneByLogin(@Param("login") String login);

    @Query("select distinct u from User u, UsersStatus us where us.user = u and us.status = :status")
    List<User> findAllByStatus(@Param("status") Status status);

}
