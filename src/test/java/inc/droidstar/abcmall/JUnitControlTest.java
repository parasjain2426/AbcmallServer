package inc.droidstar.abcmall;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JUnitControlTest {

    @Test
    public void fnTest(){
        AbcmallController abc = new AbcmallController();
        abcMessage msg = abc.hello("Hello Sir");
        assertEquals("Hii I received", msg.getMessage());
    }

    @Test
    public void putTest(){
        AbcmallController abc = new AbcmallController();
        abcMessage msg = abc.updatepass("Droidstar", "jain@123");
        assertEquals("Updated Successfully", msg.getMessage());
    }
    
}