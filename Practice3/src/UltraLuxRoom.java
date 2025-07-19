public class UltraLuxRoom extends LuxRoom{
    public UltraLuxRoom(int Number) {
        super(Number);
        this.Price = Prices.ULTRALUX.getCost();
    }
}
