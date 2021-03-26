package Exercise1;


import org.junit.Before;

public class TigerTest {
    private Tiger tiger;

    @Before
    //I won't test void methods as "huntSuccesfully", "huntFailed" or "eat"
    //I won't test getChancesToHuntSuccesfully() method, because it has an random element.

    public void initTest() {
        System.out.println("Initialize test");
        tiger = new Tiger("Tiger1", 20);
    }

}
