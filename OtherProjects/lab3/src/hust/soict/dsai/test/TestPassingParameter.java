package OOPlab.lab2.Code.AimsProject;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc CinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, CinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + CinderellaDVD.getTitle());

        ChangeTitle(jungleDVD, CinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void ChangeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void swap1(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        o1.setTitle(o2.getTitle());
    }
}
