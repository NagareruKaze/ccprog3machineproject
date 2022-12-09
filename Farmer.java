

public class Farmer extends FarmerType implements Registerable {
    public Farmer(String name, int levelReq, double bonusEarnings, int seedCostReduction, int waterBonusIncrease, int fertilizerBonusIncrease) {
        super(name, levelReq, bonusEarnings, seedCostReduction, waterBonusIncrease, fertilizerBonusIncrease, 0);
    }

    public boolean canRegister(Player player) {
        // Check if player meets level requirement
        if((int)(player.getExperience()/100) >= 5) {
            // Check if player can afford fee
            if(player.getObjectcoins() >= 200) {
                return true;
            }
        }
        return false;
    }

    public void upgrade(Player player) {
        // Player can register
        if(canRegister(player) == true) {
            player.removeObjectcoins(200);
            player.setFarmerType(new RegisteredFarmer("Registered Farmer", 5, 1, 1, 0, 0, 200));
        }
    }
}
