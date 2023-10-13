import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author filip
 */

public class Inventory {
    ArrayList<Book> books;
    ArrayList<DVD> dvds;
    ArrayList<CD> cds;

    public Inventory() {
        books = new ArrayList<>();
        dvds = new ArrayList<>();
        cds = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addDVD(DVD dvd) {
        dvds.add(dvd);
    }

    public void addCD(CD cd) {
        cds.add(cd);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<DVD> getDVDs() {
        return dvds;
    }

    public ArrayList<CD> getCDs() {
        return cds;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeDVD(DVD dvd) {
        dvds.remove(dvd);
    }

    public void removeCD(CD cd) {
        cds.remove(cd);
    }
}
