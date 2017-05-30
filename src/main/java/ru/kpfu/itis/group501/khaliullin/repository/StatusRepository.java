package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.group501.khaliullin.model.Status;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findOneByName(String statusName);
}
