import application.library.config.MySpringMVCDispatcherServletInit;
import application.library.config.SpringConfig;
import application.library.controllers.HumanController;
import application.library.dao.HumanDAO;
import application.library.models.Human;
import application.library.util.HumanValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
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
    public void showAllHumanReturnsEmptyList() {
        HumanController humanController = new HumanController(humanDAO, humanValidator);

        ExtendedModelMap model1 = new ExtendedModelMap();

        humanController.getAllHuman(model1);

        assertThat(model1.getAttribute("allHuman")).isEqualTo(Collections.emptyList());
    }

    @Test
    public void showAllHumanReturnsListOfOneHuman() {
        List<Human> humanList = List.of(new Human());
        when(humanDAO.getAllHumans()).thenReturn(humanList);

        HumanController humanController = new HumanController(humanDAO, humanValidator);

        ExtendedModelMap model1 = new ExtendedModelMap();
        humanController.getAllHuman(model1);

        assertThat(model1.getAttribute("allHuman")).isEqualTo(humanList);
    }

}
