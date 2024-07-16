package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {

    @Test
    void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestDuplicate() {
        Citizen citizen = new Citizen("7787", "Petr Arsentev");
        Citizen citizen1 = new Citizen("7787", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        assertThat(office.get(citizen1.getPassport())).isEqualTo(citizen);
    }
}