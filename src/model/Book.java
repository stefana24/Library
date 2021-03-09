package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int number;

    public Book(int id, String title, String author, int number) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.number = number;
    }

    public Book(){}
    public Book(String title, String author, int number) {
        this.title = title;
        this.author = author;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", number=" + number +
                '}';
    }
}
