package Exercise1;

import java.util.Random;

public class Simulator {
    private Jungle jungle;

    public Jungle getJungle() {
        return jungle;
    }

    Simulator(int items) {
        // There will be always one elk or one dear in herbivorous
        Random random = new Random();
        int dearsNumber = random.nextInt(items);
        int elkNumber = items - dearsNumber;
        Herbivorous[] herbivorous = new Herbivorous[items];
        for (int i = 0; i < herbivorous.length; i++) {
            if (dearsNumber != 0) {
                herbivorous[i] = new Dear("Dear" + i, random.nextInt(30));
                dearsNumber--;
            } else {
                herbivorous[i] = new Elk("Elk" + i, random.nextInt(30));
                elkNumber--;
            }
        }
        // There will be always one tiger or one lion in carnivorous
        int lionNumber = random.nextInt(items);
        int tigerNumber = items - lionNumber;
        Carnivorous[] carnivorous = new Carnivorous[items];
        for (int i = 0; i < carnivorous.length; i++) {
            if (lionNumber != 0) {
                carnivorous[i] = new Lion("Lion" + i, random.nextInt(35));
                lionNumber--;
            } else {
                carnivorous[i] = new Tiger("Tiger" + i, random.nextInt(35));
                tigerNumber--;
            }
        }
        this.jungle = new Jungle(herbivorous, carnivorous);
    }

    /**
     * Simulates the duel between a carnivore and a herbivore and compares getChancesToHuntSuccesfully of a Carnivorous
     * and getChancesToRunSuccesfully of a Herbivorous
     *
     * @param carnivorousDuelist
     * @param herbivorousDuelist
     * @return if getChancesToHuntSuccesfully = getChancesToRunSuccesfully returns "draw"
     * if getChancesToHuntSuccesfully > getChancesToRunSuccesfully returns "carnivore"
     * if getChancesToHuntSuccesfully < getChancesToRunSuccesfully returns "herbivore"
     */

    public String duel(Carnivorous carnivorousDuelist, Herbivorous herbivorousDuelist) {
        if (carnivorousDuelist.getChancesToHuntSuccesfully() == herbivorousDuelist.getChancesToRunSuccesfully()) {
            System.out.println("The fight between carnivore " + carnivorousDuelist.getName() + " with a chance of hunt of " + carnivorousDuelist.getChancesToHuntSuccesfully() + " ended in a draw with herbivore " + herbivorousDuelist.getName() + " with a chance of escape of " + herbivorousDuelist.getChancesToRunSuccesfully() + "!");
            return "draw";
        } else {
            if (carnivorousDuelist.getChancesToHuntSuccesfully() > herbivorousDuelist.getChancesToRunSuccesfully()) {
                carnivorousDuelist.huntSuccesfully();
                herbivorousDuelist.runFailed();
                System.out.println("Carnivore win!\n");
                return "carnivore";
            } else {
                herbivorousDuelist.runSuccesfully();
                carnivorousDuelist.huntFailed();
                System.out.println("Herbivore win!\n");
                return "herbivore";
            }
        }
    }

    /**
     * It tests if the fight will end in a draw.
     * If best Herbivorous' getChancesToRunSuccesfully is equal to best Carnivorous' getChancesToHuntSuccesfully it ends in a draw.
     *
     * @return true if it's a draw
     * false if it is not a draw
     */
    public boolean fullDraw() {
        if (jungle.getCarnivores() != null && jungle.getHerbivores() != null) {

            Herbivorous bestHerbivorous = jungle.getHerbivores()[0];
            for (int i = 1; i < jungle.getHerbivores().length; i++) {
                if (bestHerbivorous.getChancesToRunSuccesfully() < jungle.getHerbivores()[i].getChancesToRunSuccesfully())
                    bestHerbivorous = jungle.getHerbivores()[i];
            }

            Carnivorous bestCarnivorous = jungle.getCarnivores()[0];
            for (int i = 1; i < jungle.getCarnivores().length; i++) {
                if (bestCarnivorous.getChancesToHuntSuccesfully() < jungle.getCarnivores()[i].getChancesToHuntSuccesfully())
                    bestCarnivorous = jungle.getCarnivores()[i];
            }

            if (bestHerbivorous.getChancesToRunSuccesfully() == bestCarnivorous.getChancesToHuntSuccesfully()) {
                return true;
            }
        }
        return false;
    }

    public void Simulate() {
        Random random = new Random();
        int randomCarnivore;
        int randomHerbivore;

        while ((jungle.getHerbivores() != null && jungle.getCarnivores() != null) && !fullDraw()) {
            randomCarnivore = random.nextInt(jungle.getCarnivores().length);
            randomHerbivore = random.nextInt(jungle.getHerbivores().length);

            String result = duel(jungle.getCarnivores()[randomCarnivore], jungle.getHerbivores()[randomHerbivore]);

            if (result.matches("draw")) {
                System.out.println("It's a draw!\n");
            } else if (result.matches("carnivore")) {
                jungle.removeAnimalFromHerbivores(randomHerbivore);
            } else {
                jungle.removeAnimalFromCarnivores(randomCarnivore);
            }
        }

        if (jungle.getHerbivores() != null && jungle.getCarnivores() == null) {
            System.out.println("Herbivores have won!");
        } else if (jungle.getCarnivores() != null && jungle.getHerbivores() == null) {
            System.out.println("Carnivores have won!");
        } else if (jungle.getHerbivores().length == jungle.getCarnivores().length) {
            System.out.println("Simulation ends in a draw!");
        }
    }
}
