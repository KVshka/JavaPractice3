import java.util.Random;

public abstract class Room {

    int Number;

    int MaxGuests;

    int Price;

    Boolean IsBooked;

    public Room(int Number, Prices price) {
        this.Number = Number;
        this.MaxGuests = generateMaxGuests();
        this.Price = price.getCost();
        this.IsBooked = false;
    }

    Random random = new Random();

    //Генерация числа гостей
    int generateMaxGuests(){
        return random.nextInt(1,7);
    }

    @Override
    public String toString() {
        return String.format("""
                Номер комнаты: %d
                Число гостей: %d
                Цена за 1 ночь: %d
                Занята: %b
                """, Number, MaxGuests, Price, IsBooked);
    }
}
