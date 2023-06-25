package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.*;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}

	public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist,
			ArrayList<Track> tracks) {
		super(id, title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) throws DupplicatedItemException {
		if (this.tracks.contains(track)) {
			throw new DupplicatedItemException(
					"The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
		} else {
			this.tracks.add(track);
			System.out.println(
					"The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
		}
	}

	public void removeTrack(Track track) throws NonExistingItemException {
		if (this.tracks.remove(track)) {
			System.out.println(
					"The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
		} else {
			throw new NonExistingItemException(
					"The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
		}
	}

	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive!");
		} else {
			System.out.println("Playing CD: " + this.getTitle());

			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel p = new JPanel();
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Now playing: " + this.getTitle());
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			l1.setAlignmentX(Component.CENTER_ALIGNMENT);
			d.setTitle("Media Player");
			p.add(Box.createVerticalGlue());
			p.add(l1);
			p.add(Box.createVerticalGlue());
			d.add(p);
			d.setSize(250, 100);
			int w = d.getSize().width;
			int h = d.getSize().height;
			int x = (dim.width - w) / 2;
			int y = (dim.height - h) / 2;
			d.setLocation(x, y);
			d.setVisible(true);

			for (Track track : this.tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + ", Artist: " + this.artist + ", Title: " + this.getTitle() + ", Category: "
				+ this.getCategory() + ", Cost: " + this.getCost() + ", Length of tracks: " + this.getLength();
	}
}
