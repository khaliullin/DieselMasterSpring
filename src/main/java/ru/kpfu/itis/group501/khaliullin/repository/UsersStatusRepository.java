package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.group501.khaliullin.model.UsersStatus;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface UsersStatusRepository extends JpaRepository<UsersStatus, Long> {
    List<UsersStatus> findAllStatusIdByUserId(Long id);

    List<UsersStatus> findAllByStatusId(Long id);
}
