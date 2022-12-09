public abstract class Tool {
    private final double cost;
    private final double experience;

    public Tool(double cost, double experience) {
        this.cost = cost;
        this.experience = experience;
    }

    public double getCost() {
        return this.cost;
    }

    public double getExperience() {
        return this.experience;
    }
}
