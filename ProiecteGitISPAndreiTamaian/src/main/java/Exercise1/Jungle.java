package Exercise1;

public class Jungle {
    private Herbivorous[] herbivores;
    private Carnivorous[] carnivores;



    Jungle(Herbivorous[] herbivorouses, Carnivorous[] carnivoruses) {
        this.herbivores = herbivorouses;
        this.carnivores = carnivoruses;
    }

    /**
     * Removes a element at position "index" from array
     *
     * @param herbivores The array in which will be deleted an element
     * @param index      The index of herbivores which element will be deleted
     * @return the new array without the deleted element
     */

    private Herbivorous[] removeElementHerbivores(Herbivorous[] herbivores, int index) {
        if (herbivores == null || index < 0 || index >= herbivores.length) {
            return herbivores;
        }

        Herbivorous[] herbivor = new Herbivorous[herbivores.length - 1];
        System.arraycopy(herbivores, 0, herbivor, 0, index);
        System.arraycopy(herbivores, index + 1, herbivor, index, herbivores.length - index - 1);

        if (herbivor.length == 0) {
            return null;
        }
        return herbivor;
    }

    /**
     * Removes a element at position "index" from array
     *
     * @param carnivores The array in which will be deleted an element
     * @param index      The index of herbivores which element will be deleted
     * @return the new array without the deleted element
     */

    private Carnivorous[] removeElementCarnivores(Carnivorous[] carnivores, int index) {
        if (carnivores == null || index < 0 || index >= carnivores.length) {
            return carnivores;
        }

        Carnivorous[] carnivor = new Carnivorous[carnivores.length - 1];
        System.arraycopy(carnivores, 0, carnivor, 0, index);
        System.arraycopy(carnivores, index + 1, carnivor, index, carnivores.length - index - 1);

        if (carnivor.length == 0) {
            return null;
        }
        return carnivor;
    }

    public void removeAnimalFromHerbivores(int index) {
        this.herbivores = removeElementHerbivores(this.herbivores, index);
        //this.herbivores.length--;
    }

    public void removeAnimalFromCarnivores(int index) {
        this.carnivores = removeElementCarnivores(this.carnivores, index);
    }

    public Herbivorous[] getHerbivores() {
        return this.herbivores;
    }

    public Carnivorous[] getCarnivores() {
        return this.carnivores;
    }
}
