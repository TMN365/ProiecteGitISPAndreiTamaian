package Exercise1;

import org.junit.Before;

public class DearTest {
    private Dear dear;

    @Before
    //I won't test void methods as "runSuccesfully", "runFailed" or "eat"
    //I won't test getChancesToRunSuccesfully() method, because it has an random element and I tested it in ElkTest
    public void initTest() {
        System.out.println("Initialize test");
        dear = new Dear("Dear1", 20);
    }


}
