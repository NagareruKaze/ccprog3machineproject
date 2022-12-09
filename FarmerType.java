public abstract class FarmerType {
    private final String name;
    private final int levelReq;
    private final double bonusEarnings;
    private final double seedCostReduction;
    private final int waterBonusIncrease;
    private final int fertilizerBonusIncrease;
    private final double registrationFee;

    public FarmerType(String name, int levelReq, double bonusEarnings, int seedCostReduction, int waterBonusIncrease, int fertilizerBonusIncrease, double registrationFee) {
        this.name = name;
        this.levelReq = levelReq;
        this.bonusEarnings = bonusEarnings;
        this.seedCostReduction = seedCostReduction;
        this.waterBonusIncrease = waterBonusIncrease;
        this.fertilizerBonusIncrease = fertilizerBonusIncrease;
        this.registrationFee = registrationFee;
    }

    public String getName() {
        return this.name;
    }

    public int getLevelReq() {
        return this.levelReq;
    }

    public double getBonusEarnings() {
        return this.bonusEarnings;
    }
    
    public double getSeedCostReduction() {
        return this.seedCostReduction;
    }

    public int getWaterBonusIncrease() {
        return this.waterBonusIncrease;
    }

    public int getFertilizerBonusIncrease() {
        return this.fertilizerBonusIncrease;
    }

    public double getRegistrationFee() {
        return this.registrationFee;
    }
}
