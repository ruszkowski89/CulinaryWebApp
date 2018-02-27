import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ruszkowski89.springmvc.config.JpaConfig;
import ruszkowski89.springmvc.config.WebMvcConfig;
import ruszkowski89.springmvc.service.UserService;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    classes = {WebMvcConfig.class, JpaConfig.class},
    loader = AnnotationConfigContextLoader.class)
public class UserServiceImplTest {

    @Autowired
    @Qualifier("UserService")
    UserService userService;

    @Test
    public void test_getAllUsers_returns_10_users(){

    }

}
