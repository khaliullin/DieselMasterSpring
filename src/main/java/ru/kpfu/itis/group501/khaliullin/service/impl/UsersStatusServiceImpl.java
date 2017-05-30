package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.UsersStatus;
import ru.kpfu.itis.group501.khaliullin.repository.UsersStatusRepository;
import ru.kpfu.itis.group501.khaliullin.service.UsersStatusService;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170529
 */
@Service
public class UsersStatusServiceImpl implements UsersStatusService {
    private final UsersStatusRepository usersStatusRepository;

    @Autowired
    public UsersStatusServiceImpl(UsersStatusRepository usersStatusRepository) {
        this.usersStatusRepository = usersStatusRepository;
    }

    @Override
    public void save(UsersStatus userStatus) {
        usersStatusRepository.save(userStatus);
    }
}
