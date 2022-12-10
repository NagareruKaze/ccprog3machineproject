/**
 * This is the DistinguishedFarmer subclass under {@link FarmerType} 
 * for the farming simulator game for MCO2.
 * <p>
 * Additional methods include checking whether the Player is able to register
 * to the subsequent farmer type and upgrading the Player to that farmer type.
 */

public class DistinguishedFarmer extends FarmerType implements Registerable {

    /**
     * {@inheritDoc}
     *
     */
    public DistinguishedFarmer(String name, int levelReq, double bonusEarnings, int seedCostReduction, int waterBonusIncrease, int fertilizerBonusIncrease, double registrationFee) {
        super(name, levelReq, bonusEarnings, seedCostReduction, waterBonusIncrease, fertilizerBonusIncrease, registrationFee);
    }

    /**
     * Checks whether the Player can register to the subsequent farmer type. 
     *
     * @return true if the player can register to the subsequent farmer type, otherwise false
     */
    public boolean canRegister(Player player) {
        // Check if player meets level requirement
        if((int)(player.getExperience()/100) >= super.getLevelReq() + 5) {
            // Check if player can afford the fee
            if(player.getObjectcoins() >= super.getRegistrationFee() + 100) {
                return true;
            }
        }
        return false;
    }

    /**
     * Upgrades the Player's farmer type to the subsequent farmer type. 
     *
     */
    public void upgrade(Player player) {
        // Player can register
        if(canRegister(player) == true) {
            player.removeObjectcoins(super.getRegistrationFee() + 100);
            player.setFarmerType(new LegendaryFarmer("Legendary Farmer", 15, 4, 3, 2, 1, 400));
        }
    }
}
