public enum Prices {
    ECONOMY(2000),
    STANDART(3000),
    LUX(5000),
    ULTRALUX(6000);

    private final int cost;

    Prices(int cost) {
        this.cost = cost;
    }

    public int getCost() { return cost; }
}
