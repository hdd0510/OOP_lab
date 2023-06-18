package hust.soict.dsai.aims.media;

import java.util.ArrayList;

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

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists in the CD.");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist in the CD.");
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
    public void play() {
        System.out.println("Playing Compact Disc:");
        System.out.println("Title: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total Length: " + getLength() + " seconds");
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + ", Artist: " + this.artist + ", Title: " + this.getTitle() + ", Category: "
                + this.getCategory() + ", Cost: " + this.getCost() + ", Length of tracks: " + this.getLength();
    }
}
