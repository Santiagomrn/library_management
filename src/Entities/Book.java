package Entities;

public class Book {
    private String code, title, author;
    private boolean isAvailable;
    
    public Book(String code, String title, String author, boolean isAvailable) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
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
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" + "code=" + code + ", tittle=" + title + ", author=" + author + ", isAvailable=" + isAvailable + '}';
    }
}
