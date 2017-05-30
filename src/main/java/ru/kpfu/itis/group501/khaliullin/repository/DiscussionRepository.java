package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.group501.khaliullin.model.Discussion;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {

    @Query("select d from Discussion d")
    List<Discussion> getAll(Pageable pageable);

    @Query("select count(d) from Discussion d")
    int countAll();
}
