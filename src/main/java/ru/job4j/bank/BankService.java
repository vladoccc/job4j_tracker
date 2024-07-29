package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * Класс должен выполнять следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * * @author VLAD
 * * @version 1.0
 */
public class BankService {

    /**
     * Хранение пользователей осуществляется в поле users
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * В методе происходит добавление пользователя в хранилище.
     * Благодаря методу putIfAbsent() код становится меньше. Данный метод
     * позволяет проверить, если ли такой ключ в карте или нет и если его нет, то произвести вставку данных.
     *
     * @param user пользователь который добавляется в хранилище users
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя из системы.
     *
     * @param passport - унифицированный параметр по которому удаляется пользователь из хранилища
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счёт пользователю.
     * Для начала пользователь ищется по passport.
     * После этого происходит проверка, что такого счёта еще нет у пользователя.
     * Если проверка прошла, добавляется новый счёт пользователю.
     *
     * @param passport - параметр поиска пользователя
     * @param account  - пврвметр содержащий счета пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> value = users.get(user);
            if (!value.contains(account)) {
                value.add(account);
            }
        }
    }

    /**
     * Данный метод ищет пользователя по паспорту, перебирает пользователей через цикл for-earch.
     * Метод users.keySet() - извлекает только ключ пользователя.
     * После чего идет проверка условия, где сравнивается переданное значение
     * с имеющимся значением паспорта у пользователя.
     *
     * @param passport - параметр поиска пользователя
     * @return если пользователь не найден - вернет null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет пользователя по реквизитам.
     * В начеле поиск пользователя происходит по паспорту.
     * После чего идет проверка, на наличие такого пользователя в системе.
     * После получается список счетов этого пользователя и в нем находится нужный счет.
     *
     * @param passport  - параметр поиска пользователя
     * @param requisite - параметр поиска счета
     * @return если пользователя нет в системе верется null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> value = users.get(user);
            for (Account user1 : value) {
                if (requisite.equals(user1.getRequisite())) {
                    return user1;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой.
     * В начале требуется наёти аккаунт с которого будут переводиться деньги
     * и аккаунт на который будут зачислены деньги.
     * Для этого требуется метод findByRequisite.
     *
     * @param sourcePassport       - параметр  для поиска счёта с которого переводят деньги
     * @param sourceRequisite      - параметр  для поиска счёта с которого переводят деньги
     * @param destinationPassport  - параметр  для поиска счёта на который переведены деньги
     * @param destinationRequisite - параметр  для поиска счёта на который переведены деньги
     * @param amount               - величина, которую переводя со счёта
     * @return - Если счёт не найден или не хватает денег на счёте с которого переводят,
     * то метод ворачивает false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceUser = findByRequisite(sourcePassport, sourceRequisite);
        Account destUser = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceUser != null && destUser != null && sourceUser.getBalance() >= amount) {
            sourceUser.setBalance(sourceUser.getBalance() - amount);
            destUser.setBalance(destUser.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}