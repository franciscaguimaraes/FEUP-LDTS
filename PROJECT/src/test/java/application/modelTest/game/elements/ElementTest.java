package application.modelTest.game.elements;

import application.model.Position;
import application.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {
    Element element;

    @BeforeEach
    void setUp() {
        element = Mockito.mock(Element.class);

        Mockito.doCallRealMethod().when(element).setPosition(Mockito.any());
        Mockito.doCallRealMethod().when(element).getPosition();
    }

    @Test
    void position() {
        element.setPosition(new Position(6, 6));
        assertEquals(element.getPosition(), new Position(6, 6));
    }
}
