package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.exception.NonExistingItemException;

public class Book extends Media {
    private int contentLength;
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, int contentLength, float cost) {
        super(title, category, cost);
        this.contentLength = contentLength;
    }

    public void addAuthor(String authorName) throws DupplicatedItemException {
        for (String name : this.authors) {
            if (name.toLowerCase().equals(authorName.toLowerCase())) {
                throw new DupplicatedItemException(name + " is already in the list of authors.");
            }
        }
        this.authors.add(authorName);
        System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
    }

    public void removeAuthor(String authorName) throws NonExistingItemException {
        for (String name : this.authors) {
            if (name.toLowerCase().equals(authorName.toLowerCase())) {
                this.authors.remove(name);
                System.out.println(name + " has been removed from the " + this.getTitle() + " list of authors.");
                return;
            }
        }
        throw new NonExistingItemException(authorName + " is not in the list of authors.");
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return super.toString() + ", the author is: " + this.getAuthors() + ", the length is: "
                + this.getContentLength();
    }
}
