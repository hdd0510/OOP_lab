package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private int contentLength;
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, int contentLength, float cost) {
        super(title, category, cost);
        this.contentLength = contentLength;
    }

    public void removeAuthor(String authorName) {
        boolean check = false;
        for (String author : authors) {
            if (author == authorName) {
                System.out.println(authorName + " has been removed");
                authors.remove(authorName);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Cannot find the author named " + authorName);
        }
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author: " + authorName + "be added to the book");
        } else {
            System.out.println("Author: " + authorName + "is already associated to the book");
        }
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
