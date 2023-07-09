package ru.netology;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class TicketTest {
    Ticket ticket1 = new Ticket("MSK", "BGD", 2000, 7, 9); //2-1
    Ticket ticket2 = new Ticket("MSK", "SPB", 5500, 10, 6);//4
    Ticket ticket3 = new Ticket("MSK", "BGD", 16000, 5, 10);//5-4
    Ticket ticket4 = new Ticket("MSK", "BGD", 3000, 15, 18);//3-2
    Ticket ticket5 = new Ticket("MSK", "BGD", 17000, 7, 19);//12-6
    Ticket ticket6 = new Ticket("MSK", "BGD", 5000, 10, 18);//8-5
    Ticket ticket7 = new Ticket("SPB", "UFA", 20000, 15, 18);//3-2
    Ticket ticket8 = new Ticket("SPB", "BGD", 22000, 7, 19);//12-6
    Ticket ticket9 = new Ticket("UFA", "BGD", 21000, 10, 18);//8-5

    @Test
    public void testComparator1() {
        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket4, ticket3, ticket6, ticket5};
        Ticket[] actual = repo.searchCompo("MSK", "BGD", comparator);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparator2() {
        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket9};
        Ticket[] actual = repo.searchCompo("UFA", "BGD", comparator);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparator3() {
        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = repo.searchCompo("SGT", "BGD", comparator);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareTo() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Ticket[] expected = {ticket1, ticket4, ticket6, ticket3, ticket5};
        Ticket[] actual = repo.search("MSK", "BGD");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareTo1() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = repo.search("SGT", "SPB");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareTo2() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Ticket[] expected = {ticket7};
        Ticket[] actual = repo.search("SPB", "UFA");
        Assert.assertArrayEquals(expected, actual);
    }
}