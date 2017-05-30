package ru.kpfu.itis.group501.khaliullin.service;

import ru.kpfu.itis.group501.khaliullin.model.Status;
import ru.kpfu.itis.group501.khaliullin.model.User;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface UserService {
    void save(User user);

    User getUser(String login);

    User getUser(Long id);

    User findOne(Long id);

    User getAdmin();

    List<Status> getStatus(User user);

    boolean isAdmin(User user);

}
