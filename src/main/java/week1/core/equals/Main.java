package week1.core.equals;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       // scenario1();
        scenario2();


    }

    private static void scenario2() {
        Set<User> users = new HashSet<>();
        User user1 = new User(1L, "1@1.ru");
        users.add(user1);
        user1.setEmail("2@2.ru");
        System.out.println(users.contains(user1));  // false

        /*
            тут пользователь добавлен с email 1@1.ru, т.к. email изменен, то он не может его найти
         */
    }

    public static void scenario1() {
        Set<User> users = new HashSet<>();

        User user1 = new User(1L, "1@1.ru");
        User user2 = new User(2L, "1@1.ru");

        users.add(user1);
        users.add(user2);

        /* Добавлены оба объекта, т.к. hashcode() не переопределен. Используется hashcode() из
        класса Object. Из-за этого у объектов разный hash и HashSet оба их добавил.

        HashSet - это HashMap (типа map, но ключи (корзины) - это hash), только с уникальными значениями.
        Внутри каждой корзины Node<K, V>.
         */
        System.out.println(users.contains(user1));
        System.out.println(users.contains(user2));
        System.out.println(users.size());
    }
}
