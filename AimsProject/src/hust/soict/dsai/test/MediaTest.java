package hust.soict.dsai.test;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.*;

public class MediaTest {
    public static void main(String[] args) {

        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("Phim con heo", "adult", "Dinh Dung", "dinzdzun", 100.123f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Sherlock Holmes", "Detective", 420, 5f);
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}