package ru.kpfu.itis.group501.khaliullin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group501.khaliullin.model.Status;
import ru.kpfu.itis.group501.khaliullin.repository.StatusRepository;
import ru.kpfu.itis.group501.khaliullin.service.StatusService;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status getStatus(String statusName) {
        return statusRepository.findOneByName(String.valueOf(statusName));
    }
}
