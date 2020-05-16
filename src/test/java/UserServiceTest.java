import com.spingweb.Main;
import com.spingweb.Service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Main.class)
public class UserServiceTest
{
    @Autowired
    public UserServiceImpl userService;

    @Test
    public void TestAddUser()
    {
        String input = userService.addUser("Budah","Bless");
        assertThat(input).isEqualTo("Budah");
    }

    @Test
    public void cacheTest()
    {

            String name1 = userService.cachedUser("Budah");
            String name2 = userService.cachedUser("Budah");
            String name3 = userService.cachedUser("Budah");
            System.out.println(name1+" "+name2+" "+name3);

    }
}
