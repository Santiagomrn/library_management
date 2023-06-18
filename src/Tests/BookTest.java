package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Entities.Book;

public class BookTest {
    @Test
    void testToString() {
        String code="1",title="book1",author="miker";
        Boolean isAvailable=true;
     var book = new Book(code, title, author, isAvailable);
      assertEquals("Book{" + "code=" + code + ", tittle=" + title + ", author=" + author + ", isAvailable=" + isAvailable + '}',book.toString()); 
    }
}
