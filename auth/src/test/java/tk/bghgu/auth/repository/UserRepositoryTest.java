package tk.bghgu.auth.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.bghgu.auth.domain.USER;

import java.util.List;
import java.util.Optional;

/**
 * Created by ds on 2018-05-06.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        Optional<USER> user1 = userRepository.findById(1);
        if(user1.isPresent()) {
            logger.info(user1.get().toString());
        }else {
            logger.info("No USER");
        }
    }

    @Test
    public void testFindAll() {
        Iterable<USER> userList = userRepository.findAll();
    }
}