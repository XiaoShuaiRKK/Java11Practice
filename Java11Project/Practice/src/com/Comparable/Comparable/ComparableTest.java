package com.Comparable.Comparable;

import com.Comparable.POJO.Account;
import com.Comparable.POJO.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>(List.of(new Account("Aom", 38, 1000), new Account("Bom", 67, 5000)
                , new Account("Com", 67, 6000), new Account("Dom", 22, 2300)
                , new Account("Eom", 32, 3200), new Account("Fom", 50, 5000)));
        Collections.sort(accounts);
        accounts.forEach(System.out::println);
        List<User> users = new ArrayList<>(List.of(new User("Asan",58,2300),new User("Bsan",18,5800)
                ,new User("Csan",46,4682),new User("Dsan",85,9800)
                ,new User("Esan",79,3200),new User("Fsan",35,7800)));
        users.forEach(System.out::println);
        System.out.println("===== before ==== after =====");
        users.sort((o1, o2) -> {
            int tmp = o1.getAge() - o2.getAge();
            if (tmp == 0)
                return o1.getMoney() - o2.getMoney();
            return tmp;
        });
        users.forEach(System.out::println);
    }
}
