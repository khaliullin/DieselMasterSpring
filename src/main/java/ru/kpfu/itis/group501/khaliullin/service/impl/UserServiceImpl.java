package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Status;
import ru.kpfu.itis.group501.khaliullin.model.User;
import ru.kpfu.itis.group501.khaliullin.model.UsersStatus;
import ru.kpfu.itis.group501.khaliullin.repository.StatusRepository;
import ru.kpfu.itis.group501.khaliullin.repository.UserRepository;
import ru.kpfu.itis.group501.khaliullin.repository.UsersStatusRepository;
import ru.kpfu.itis.group501.khaliullin.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final UsersStatusRepository usersStatusRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, StatusRepository statusRepository, UsersStatusRepository usersStatusRepository) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.usersStatusRepository = usersStatusRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getAdmin() {
        Status status = statusRepository.findOneByName("ADMIN");
        List<UsersStatus> usersStatuses = usersStatusRepository.findAllByStatusId(status.getId());
        if (usersStatuses.size() != 0) {
            return usersStatuses.get(0).getUser();
        }
        return null;
    }

    @Override
    public List<Status> getStatus(User user) {
        List<Status> statuses = new ArrayList<>();
        List<UsersStatus> usersStatuses = usersStatusRepository.findAllStatusIdByUserId(user.getId());
        for (UsersStatus usersStatus : usersStatuses) {
            statuses.add(usersStatus.getStatus());
        }
        System.out.println("\n\n\n\n");
        System.out.println("public List<Status> getStatus(User user)");
        System.out.println(statuses.size());
        System.out.println("\n\n\n\n");
        return statuses;
    }

    @Override
    public boolean isAdmin(User user) {
        List<Status> statuses = getStatus(user);
        for (Status status : statuses) {
            if (status.getName().equals("ADMIN")) {
                return true;
            }
        }
        return false;
    }

}
