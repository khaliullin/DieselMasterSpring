//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import ru.kpfu.itis.group501.khaliullin.controller.DiscussionController;
//import ru.kpfu.itis.group501.khaliullin.service.DiscussionService;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
///**
// * Created by Sagit Khaliullin
// * group 11-501
// * 20170531
// */
//@RunWith(MockitoJUnitRunner.class)
//public class DiscussionControllerTest {
//    @Mock
//    private DiscussionService discussionService;
//    @InjectMocks
//    private DiscussionController discussionController;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        when(discussionService.getAll(0)).thenReturn(new ArrayList<>());
//        mockMvc = MockMvcBuilders.standaloneSetup(discussionController).build();
//    }
//
//    @Test
//    public void testGetCommentController() throws Exception {
//        mockMvc.perform(get("/discussions/0"))
//                .andExpect(view().name("discussionsList"));
//    }
//
//    @Test
//    public void testGetContactsController() throws Exception {
//        mockMvc.perform(get("/discussion/1/0"))
//                .andExpect(view().name("discussion"));
//    }
//}
