package Board;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    @Test
    public void isValid() {
        assertTrue(Field.isValidMove(new Field(0, 0)));
        assertTrue(Field.isValidMove(new Field(0, 7)));
        assertTrue(Field.isValidMove(new Field(7, 0)));
        assertTrue(Field.isValidMove(new Field(7, 7)));
        assertTrue(Field.isValidMove(new Field(3, 5)));
        assertFalse(Field.isValidMove(new Field(-1, 5)));
        assertFalse(Field.isValidMove(new Field(1, -4)));
        assertFalse(Field.isValidMove(new Field(-1, -4)));
        assertFalse(Field.isValidMove(new Field(8, 5)));
        assertFalse(Field.isValidMove(new Field(23, 5)));

    }
}