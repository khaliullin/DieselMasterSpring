package ru.kpfu.itis.group501.khaliullin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group501.khaliullin.model.Player;
import ru.kpfu.itis.group501.khaliullin.model.Team;

import java.util.List;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170522
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where p.team.id = :id")
    List<Player> getAllByTeamId(@Param("id") Long id, Pageable pageable);

    @Query("select p from Player p where p.team = :team and (LOWER(p.firstName) LIKE CONCAT('%',:name,'%') or lower(p.lastName) LIKE CONCAT('%',:name,'%'))")
    List<Player> getAllByTeamAndFirstNameAndLastName(@Param("team") Team team, @Param("name") String name);

    @Query("select p from Player p where p.team = :team and p.position = :position and (LOWER(p.firstName) LIKE CONCAT('%',:name,'%') or lower(p.lastName) LIKE CONCAT('%',:name,'%'))")
    List<Player> getAllByTeamAndFirstNameAndLastNameAndPosition(@Param("team") Team team, @Param("name") String name, @Param("position") Character position);
}
