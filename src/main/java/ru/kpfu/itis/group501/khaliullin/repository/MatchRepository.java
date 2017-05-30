package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group501.khaliullin.model.Match;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query("select m from Match m where m.played = true and (m.firstTeam.id = :id or m.secondTeam.id = :id)")
    List<Match> getAllPlayed(@Param("id") Long id, Pageable pageable);

    @Query("select m from Match m where m.played = false and (m.firstTeam.id = :id or m.secondTeam.id = :id)")
    List<Match> getAllFuture(@Param("id") Long id, Pageable pageable);

    @Query("select count(m) from Match m where m.played = true and (m.firstTeam.id = :id or m.secondTeam.id = :id)")
    Integer countGames(@Param("id") Long id);

    @Query("select count(m) from Match m where (m.firstTeam.id = :id and m.firstTeamScore > m.secondTeamScore) or (m.secondTeam.id = :id and m.secondTeamScore > m.firstTeamScore)")
    Integer countWins(@Param("id") Long id);

    @Query("select count(m) from Match m where played = :played and (m.firstTeam.id = :id) or (m.secondTeam.id = :id)")
    Integer countByTeamAndPlayed(@Param("id") Long id, @Param("played") boolean played);

}
