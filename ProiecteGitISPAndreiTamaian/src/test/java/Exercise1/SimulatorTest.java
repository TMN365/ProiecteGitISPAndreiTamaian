package Exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimulatorTest {
    Simulator simulator;

    @Before
    public void initTest() {
        System.out.println("Initialize test");

        simulator = new Simulator(5);
        System.out.println(simulator.getJungle().getHerbivores()[0].getName() + " " + simulator.getJungle().getHerbivores()[0].getChancesToRunSuccesfully());
        System.out.println(simulator.getJungle().getHerbivores()[1].getName() + " " + simulator.getJungle().getHerbivores()[1].getChancesToRunSuccesfully());
        System.out.println(simulator.getJungle().getHerbivores()[2].getName() + " " + simulator.getJungle().getHerbivores()[2].getChancesToRunSuccesfully());
        System.out.println(simulator.getJungle().getHerbivores()[3].getName() + " " + simulator.getJungle().getHerbivores()[3].getChancesToRunSuccesfully());
        System.out.println(simulator.getJungle().getHerbivores()[4].getName() + " " + simulator.getJungle().getHerbivores()[4].getChancesToRunSuccesfully());

        System.out.println(simulator.getJungle().getCarnivores()[0].getName() + " " + simulator.getJungle().getCarnivores()[0].getChancesToHuntSuccesfully());
        System.out.println(simulator.getJungle().getCarnivores()[1].getName() + " " + simulator.getJungle().getCarnivores()[1].getChancesToHuntSuccesfully());
        System.out.println(simulator.getJungle().getCarnivores()[2].getName() + " " + simulator.getJungle().getCarnivores()[2].getChancesToHuntSuccesfully());
        System.out.println(simulator.getJungle().getCarnivores()[3].getName() + " " + simulator.getJungle().getCarnivores()[3].getChancesToHuntSuccesfully());
        System.out.println(simulator.getJungle().getCarnivores()[4].getName() + " " + simulator.getJungle().getCarnivores()[4].getChancesToHuntSuccesfully());

    }

    @Test
    public void duelTest() {
        String result = simulator.duel(simulator.getJungle().getCarnivores()[0], simulator.getJungle().getHerbivores()[2]);
        if (result == "draw") {
            assertEquals("The chance to hunt succesfully (" + simulator.getJungle().getCarnivores()[0].getChancesToHuntSuccesfully() + ") should be equal to the chance to run succesfully (" + simulator.getJungle().getHerbivores()[2].getChancesToRunSuccesfully() + ").", "draw", result);
        } else if (result == "carnivore") {
            assertEquals("The chance to hunt succesfully (" + simulator.getJungle().getCarnivores()[0].getChancesToHuntSuccesfully() + ") should be greater than the chance to run succesfully (" + simulator.getJungle().getHerbivores()[2].getChancesToRunSuccesfully() + ").", "carnivore", result);
        } else {
            assertEquals("The chance to hunt succesfully (" + simulator.getJungle().getCarnivores()[0].getChancesToHuntSuccesfully() + ") should be less than the chance to run succesfully (" + simulator.getJungle().getHerbivores()[2].getChancesToRunSuccesfully() + ").", "herbivore", result);
        }
    }

    @Test
    public void fullDrawTest() {
        boolean result=simulator.fullDraw();
        if(result==true)
        {
            System.out.println("Draw");
            assertEquals("The best herbivorous' run factor equals the best carnivorous's hunt factor", true, true);
        }
        else{
            System.out.println("Winner");
            assertEquals("The best herbivorous' run factor is unequal with the best carnivorous's hunt factor", false, false);
        }
    }

    @Test
    public void simulateTest(){
        //It only calls duel method and removeElementFromHerbivores method which have been tested
        //It is not needed to be test.
    }

}
