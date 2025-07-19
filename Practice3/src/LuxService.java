public class LuxService implements RoomService<Room>, LuxRoomService<LuxRoom>{

    @Override
    public void clean(Room room) {
        if (room.IsBooked == false) {
            System.out.println("Комната №" + room.Number + " почищена");
        } else {
            System.out.println("Комната должна быть освобождена перед чисткой");
        }
    }

    @Override
    public void reserve(Room room) {
        if (room.IsBooked == false){
            room.IsBooked = true;
            System.out.println("Комната №" + room.Number + " успешно забронирована");
        } else {
            throw new RoomIsBookedException("Данная комната уже забронирована");
        }

    }

    @Override
    public void free(Room room) {
        if (room.IsBooked == true){
            room.IsBooked = false;
            System.out.println("Комната №" + room.Number + " теперь свободна");
        } else {
            System.out.println("Комната №" + room.Number + " уже свободна");
        }



    }

    @Override
    public void foodDelivery(LuxRoom luxRoom) {
        if (luxRoom.IsBooked == true){
            System.out.println("Заказ успешно оформлен! Ожидайте доставки");
        } else {
            System.out.println("Невозможно заказать еду из пустой комнаты");
        }
    }
}
