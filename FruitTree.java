public class FruitTree extends Crop implements Randomizable {
    public FruitTree(Seed seed, int currentDay) {
        super(seed, currentDay);
    }

    public int generateProduce() {
        int min = super.getSeed().getProduceMin();
        return (int)(Math.random()*(super.getSeed().getProduceMax()-min+1)+min);
    }

    public double computeHarvestPrice(double harvestTotal, double waterBonus, double fertilizerBonus) {
        return harvestTotal + waterBonus + fertilizerBonus;
    }
}
