import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import ru.kpfu.itis.group501.khaliullin.model.Team;
import ru.kpfu.itis.group501.khaliullin.repository.MatchRepository;
import ru.kpfu.itis.group501.khaliullin.repository.TeamRepository;
import ru.kpfu.itis.group501.khaliullin.service.TeamService;
import ru.kpfu.itis.group501.khaliullin.service.impl.TeamServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170531
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class TeamServiceTest {
    @Mock
    private TeamService teamService;

    @Before
    public void setup() {
        ArrayList<Team> teams = new ArrayList<Team>();
        Team team1 = new Team();
        Team team2 = new Team();
        team1.setId(1L);
        team1.setId(2L);
        team1.setName("Team");
        team1.setName("Team2");
        teams.add(team1);
        teams.add(team2);
        Mockito.when(teamService.get(1L)).thenReturn(team1);
        Mockito.when(teamService.getAllTeams()).thenReturn(teams);
    }

    @Test
    public void testGetOneTeamSuccess() throws Exception {
        Team team = teamService.get(1L);
        assertEquals("Team2", team.getName());
    }

    @Test
    public void testGetAllTeamsSuccess() throws Exception {
        List<Team> teams = teamService.getAllTeams();
        assertEquals(teams.toArray().length, 2);
    }

    @Configuration
    static class NewsServiceTestContextConfiguration {
        @Bean
        public TeamService teamService() {
            return new TeamServiceImpl(teamRepository(), matchRepository());
        }

        @Bean
        public TeamRepository teamRepository() {
            return Mockito.mock(TeamRepository.class);
        }

        @Bean
        public MatchRepository matchRepository() {
            return Mockito.mock(MatchRepository.class);
        }
    }
}