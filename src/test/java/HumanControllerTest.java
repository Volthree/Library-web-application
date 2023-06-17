import application.library.config.MySpringMVCDispatcherServletInit;
import application.library.config.SpringConfig;
import application.library.dao.HumanDAO;
import application.library.models.Human;
import application.library.util.HumanValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import java.util.List;

public class HumanControllerTest {
    @Mock
    MySpringMVCDispatcherServletInit mySpringMVCDispatcherServletInit;
    @Mock
    SpringConfig springConfig;
    @Mock
    HumanDAO humanDAO;
    @Mock
    HumanValidator humanValidator;
    @Mock
    Model model;

    @Test
    public void showAllHumanTest(){

        humanDAO = new HumanDAO(new JdbcTemplate(springConfig.dataSource()));
        List<Human> humanList = humanDAO.getAllHumans();
        System.out.println(humanList);
    }

}
