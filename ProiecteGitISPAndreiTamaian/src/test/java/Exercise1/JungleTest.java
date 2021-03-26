package Exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JungleTest {
    private Herbivorous[] herbivores;
    private Carnivorous[] carnivores;
    private Dear dear1;
    private Dear dear2;
    private Dear dear3;
    private Elk elk1;
    private Elk elk2;
    private Lion lion1;
    private Lion lion2;
    private Lion lion3;
    private Tiger tiger1;
    private Tiger tiger2;
    private Jungle jungle;

    @Before
    public void initTest() {
        System.out.println("Initialize test");

        dear1 = new Dear("Dear1", 30);
        dear2 = new Dear("Dear2", 30);
        dear3 = new Dear("Dear3", 30);
        elk1 = new Elk("Elk1", 30);
        elk2 = new Elk("Elk2", 30);
        lion1 = new Lion("Lion1", 30);
        lion2 = new Lion("Lion2", 30);
        lion3 = new Lion("Lion3", 30);
        tiger1 = new Tiger("Tiger1", 30);
        tiger2 = new Tiger("Tiger2", 30);


        herbivores = new Herbivorous[]{dear1, dear2, elk1, dear3, elk2};
        carnivores = new Carnivorous[]{lion1, lion2, tiger1, tiger2, lion3};
        jungle = new Jungle(herbivores, carnivores);
        System.out.println("***********************");
    }

    @Test
    public void removeElementHerbivoresTest() {
        jungle.removeAnimalFromHerbivores(2);
        Herbivorous[] expectedOutput = new Herbivorous[]{dear1, dear2, dear3, elk2};
        assertArrayEquals("Remaining should be dear1, dear2,dear3 and elk2.", expectedOutput, jungle.getHerbivores());
    }

    @Test
    public void removeElementCarnivoresTest() {
        jungle.removeAnimalFromCarnivores(0);
        Carnivorous[] expectedOutput = new Carnivorous[]{lion2, tiger1, tiger2, lion3};
        assertArrayEquals("Remaining should be lion2, tiger1, tiger2 and lion3.", expectedOutput, jungle.getCarnivores());
    }
}
