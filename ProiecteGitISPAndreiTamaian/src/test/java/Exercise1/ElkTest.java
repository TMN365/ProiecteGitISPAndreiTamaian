package Exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElkTest {
    private Elk elk;

    @Before
    public void initTest() {
        System.out.println("Initialize test");
        elk = new Elk("Elk1", 20);
    }

    @Test
    //I won't test this method at Lion, Tiger, or Dear classes.
    public void getChancesToRunSuccesfullyTest() {
        int chancesToRunSuccesfully = elk.getChancesToRunSuccesfully();
        System.out.println(chancesToRunSuccesfully);
        if (chancesToRunSuccesfully >= 0 && chancesToRunSuccesfully <= 100) {
            assertEquals("chancesToRunSuccesfully has good parameters.", true, true);
        } else {
            assertEquals("chancesToRunSuccesfully has not good parameters.", false, false);
        }
    }

    @Test
    //I won't test void methods as "runSuccesfully", "runFailed" or "eat"
    public void runSuccesfullyTest() {
    }

}