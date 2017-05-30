package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.group501.khaliullin.model.Discussion;
import ru.kpfu.itis.group501.khaliullin.model.Message;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByDiscussion(Discussion discussion, Pageable pageable);

    int countAllByDiscussion(Discussion discussion);
}
