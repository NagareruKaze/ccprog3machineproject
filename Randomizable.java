/**
 * This is the Randomizable interface for the farming simulator game for MCO2.
 * <p>
 * This marks the classes that have the {@link #generateProduce} method.
 */

public interface Randomizable {

    /**
     * Generates the crop's number of produce.
     * 
     * @return this crop's number of produce
     */
    public int generateProduce();
}