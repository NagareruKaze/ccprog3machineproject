public class Seed {
    private final String name;
    private final int harvestTime;
    private final int waterNeeds;
    private final int waterBonus;
    private final int fertilizerNeeds;
    private final int fertilizerBonus;
    private final int produceMin;
    private final int produceMax;
    private final double cost;
    private final double sellPrice;
    private final double expYield;

    public Seed(String name, int harvestTime, int waterNeeds, int waterBonus, int fertilizerNeeds, int fertilizerBonus, int produceMin, double cost, double sellPrice, double expYield) {
        this.name = name;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonus = waterBonus;
        this.fertilizerNeeds = fertilizerNeeds;
        this.fertilizerBonus = fertilizerBonus;
        this.produceMin = produceMin;
        this.produceMax = produceMin;
        this.cost = cost;
        this.sellPrice = sellPrice;
        this.expYield = expYield;
    }

    public Seed(String name, int harvestTime, int waterNeeds, int waterBonus, int fertilizerNeeds, int fertilizerBonus, int produceMin, int produceMax, double cost, double sellPrice, double expYield) {
        this.name = name;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonus = waterBonus;
        this.fertilizerNeeds = fertilizerNeeds;
        this.fertilizerBonus = fertilizerBonus;
        this.produceMin = produceMin;
        this.produceMax = produceMax;
        this.cost = cost;
        this.sellPrice = sellPrice;
        this.expYield = expYield;
    }

    public String getName() {
        return this.name;
    }

    public int getHarvestTime() {
        return this.harvestTime;
    }
    
    public int getWaterNeeds() {
        return this.waterNeeds;
    }

    public int getWaterBonus() {
        return this.waterBonus;
    }

    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;
    }

    public int getFertilizerBonus() {
        return this.fertilizerBonus;
    }

    public int getProduceMin() {
        return this.produceMin;
    }

    public int getProduceMax() {
        return this.produceMax;
    }

    public double getCost() {
        return this.cost;
    }

    public double getSellPrice() {
        return this.sellPrice;
    }

    public double getExperienceYield() {
        return this.expYield;
    }
}
