package Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import Controllers.BooksController;
import Controllers.ControllerInterface;
import Controllers.LendingsController;
import Controllers.MembersController;
import Entities.Lending;

public class LendingsControllerTest {
    @Test
    void testLending() {
        ControllerInterface[] collection={new BooksController(), new MembersController()};
        List<ControllerInterface> controllers = new ArrayList<ControllerInterface>(Arrays.asList(collection));
        controllers.stream().parallel().forEach((c)->{
            c.load();
        });

        var book=BooksController.findBookByCode("1");
        var member=MembersController.findMemberByNumber("1");
        LocalDateTime NOW=LocalDateTime.now();
        LendingsController.register(new Lending(book.getCode(), member.getNumber(), NOW));
        var lendings=LendingsController.get();
        var lending=lendings.get(0);
        assertEquals(book.getCode(), lending.getBookCode());
        assertEquals(member.getNumber(), lending.getMemberNumber());
    }
}
