import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        List<LuxRoom> luxRooms = new ArrayList<>();

        rooms.add(new EconomyRoom(25));
        rooms.add(new StandartRoom(31));
        rooms.add(new LuxRoom(58));
        rooms.add(new UltraLuxRoom(60));

        RoomService<Room> roomService  = new Service();
        LuxRoomService<LuxRoom> luxRoomService  = new LuxService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("""
                    Меню:
                    1. Показать все комнаты
                    2. Забронировать комнату
                    3. Освободить комнату
                    4. Почистить комнату
                    5. Заказать доставку еды в комнату (только для люксовых!)
                    0. Выход
                    Выберите пункт: """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Информация о комнатах:");
                    System.out.println(rooms);
                    break;

                case 2:
                    System.out.print("Введите номер комнаты: ");
                    Optional<Room> FindFreeRoom = getRoom(scanner, rooms);
                    if (FindFreeRoom.isPresent()) {
                        roomService.reserve(FindFreeRoom.get());
                    } else {
                        System.out.println("Комнаты с указанным номером нет");
                    }
                    break;

                case 3:
                    System.out.print("Введите номер комнаты: ");
                    Optional<Room> FindReservedRoom = getRoom(scanner, rooms);
                    if (FindReservedRoom.isPresent()) {
                        roomService.free(FindReservedRoom.get());
                    } else {
                        System.out.println("Комнаты с указанным номером нет");
                    }
                    break;

                case 4:
                    System.out.print("Введите номер комнаты: ");
                    Optional<Room> FindRoomToClean = getRoom(scanner, rooms);
                    if (FindRoomToClean.isPresent()) {
                        roomService.clean(FindRoomToClean.get());
                    } else {
                        System.out.println("Комнаты с указанным номером нет");
                    }
                    break;
                case 5:
                    System.out.print("Введите номер комнаты: ");
                    Optional<Room> FindLuxRoom = getRoom(scanner, rooms);
                    if (FindLuxRoom.isPresent()) {
                        luxRoomService.foodDelivery((LuxRoom) FindLuxRoom.get());
                    } else {
                        System.out.println("Комнаты с указанным номером нет");
                    }
                    break;

                case 0:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
    private static Optional<Room> getRoom(Scanner scanner, List<Room> rooms){
        int n = scanner.nextInt();
        Optional<Room> findRoom = rooms.stream().filter(m -> m.Number == n).findFirst();
        return findRoom;
    }

}
