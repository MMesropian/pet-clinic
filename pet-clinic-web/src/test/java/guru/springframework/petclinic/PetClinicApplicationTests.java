package guru.springframework.petclinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest(classes = springfarmework.petclinic.PetClinicApplication.class)
@ExtendWith(SpringExtension.class)
class PetClinicApplicationTests {

    @Test
    void contextLoads() {
    }

}
