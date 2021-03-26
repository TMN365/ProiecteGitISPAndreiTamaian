package Exercise1;
import org.junit.Before;

public class LionTest {
    private Lion lion;

    @Before
    //I won't test void methods as "huntSuccesfully", "huntFailed" or "eat"
    //I won't test getChancesToHuntSuccesfully() method, because it has an random element.
    public void initTest() {
        System.out.println("Initialize test");
        lion = new Lion("Lion1", 20);
    }

}
