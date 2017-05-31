import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import ru.kpfu.itis.group501.khaliullin.model.Discussion;
import ru.kpfu.itis.group501.khaliullin.model.User;
import ru.kpfu.itis.group501.khaliullin.repository.DiscussionRepository;
import ru.kpfu.itis.group501.khaliullin.service.DiscussionService;
import ru.kpfu.itis.group501.khaliullin.service.impl.DiscussionServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sagit Khaliullin
 * group 11-501
 * 20170531
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class DiscussionServiceTest {
    @Mock
    private DiscussionService discussionService;

    @Before
    public void setup() {
        ArrayList<Discussion> discussions = new ArrayList<Discussion>();
        Discussion discussion1 = new Discussion(new User(), "Name", "Content", new Date());
        Discussion discussion2 = new Discussion(new User(), "Name2", "Content2", new Date());
        discussion1.setId(1L);
        discussion2.setId(2L);
        discussions.add(discussion1);
        discussions.add(discussion2);
        Mockito.when(discussionService.getAll(0)).thenReturn(discussions);
        Mockito.when(discussionService.getDiscussion(1L)).thenReturn(discussion1);
    }

    @Test
    public void testGetDiscussionSuccess() throws Exception {
        Discussion discussion = discussionService.getDiscussion(1L);
        assertEquals("Name", discussion.getName());
    }

    @Test
    public void testGetDiscussionByPageSuccess() throws Exception {
        List<Discussion> discussions = discussionService.getAll(0);
        assertEquals(discussions.toArray().length, 2);
    }

    @Configuration
    static class NewsServiceTestContextConfiguration {
        @Bean
        public DiscussionService discussionService() {
            return new DiscussionServiceImpl(discussionRepository());
        }

        @Bean
        public DiscussionRepository discussionRepository() {
            return Mockito.mock(DiscussionRepository.class);
        }
    }
}