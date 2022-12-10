/**
 * This is the Registerable interface for the farming simulator game for MCO2.
 * <p>
 * This marks the classes that have the {@link Farmer#canRegister(Player) canRegister} 
 * and {@link Farmer#upgrade(Player) upgrade} methods.
 */

public interface Registerable {
    public boolean canRegister(Player player);
    public void upgrade(Player player);
}
