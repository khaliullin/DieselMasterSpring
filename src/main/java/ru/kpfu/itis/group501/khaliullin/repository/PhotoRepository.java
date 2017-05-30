package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group501.khaliullin.model.Match;
import ru.kpfu.itis.group501.khaliullin.model.Photo;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    @Query("select p from Photo p where p.match = :match")
    List<Photo> findAllByMatch(@Param("match") Match match, Pageable pageable);

    int countAllByMatch(Match match);
}
