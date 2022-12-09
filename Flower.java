public class Flower extends Crop {
    public Flower(Seed seed, int currentDay) {
        super(seed, currentDay);
    }

    public double computeHarvestPrice(double harvestTotal, double waterBonus, double fertilizerBonus) {
        double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

        return finalHarvestPrice * 1.1;
    }

}
