package hust.soict.dsai.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.*;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Track length is invalid!");
        } else {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("length of track is: " + this.getLength());

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel p = new JPanel();
            JDialog d = new JDialog();
            JLabel l1 = new JLabel(" Playing: " + this.getTitle());
            JLabel l2 = new JLabel(" length of track is: " + this.getLength());

            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            l2.setAlignmentX(Component.CENTER_ALIGNMENT);
            d.setTitle("Media Player");
            p.add(Box.createVerticalGlue());
            p.add(l1);
            p.add(l2);
            p.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(250, 100);

            int w = d.getSize().width;
            int h = d.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;

            d.setLocation(x, y);
            d.setVisible(true);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }
}