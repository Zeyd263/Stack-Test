import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack testStack;

    @BeforeEach
    public void initialize() {
        testStack = new Stack(5); // Erstelle einen neuen Stapel mit einer maximalen Größe von 5
    }

    @Test
    public void checkIfStackIsEmpty() {
        // Überprüfe, ob ein neu erstellter Stapel leer ist
        assertTrue(testStack.isEmpty(), "Der neue Stapel sollte leer sein.");

        // Füge ein Element hinzu und überprüfe, dass der Stapel nicht mehr leer ist
        testStack.push(10);
        assertFalse(testStack.isEmpty(), "Der Stapel sollte nach dem Hinzufügen eines Elements nicht leer sein.");

        // Entferne das Element und überprüfe, ob der Stapel wieder leer ist
        testStack.pop();
        assertTrue(testStack.isEmpty(), "Der Stapel sollte nach dem Entfernen des einzigen Elements leer sein.");
    }

    @Test
    public void verifyPushFunctionality() {
        // Überprüfe das Hinzufügen von Elementen zum Stapel
        testStack.push(10);
        assertEquals(1, testStack.size(), "Die Größe des Stapels sollte 1 sein, nachdem ein Element hinzugefügt wurde.");

        testStack.push(20);
        assertEquals(2, testStack.size(), "Die Größe des Stapels sollte 2 sein, nachdem ein weiteres Element hinzugefügt wurde.");

        // Überprüfe, ob die Elemente korrekt hinzugefügt wurden
        assertEquals(20, testStack.pop(), "Das letzte hinzugefügte Element (20) sollte entfernt werden.");
        assertEquals(10, testStack.pop(), "Das zuerst hinzugefügte Element (10) sollte entfernt werden.");
    }

    @Test
    public void validatePopOperation() {
        // Überprüfe das Entfernen von einem leeren Stapel
        assertEquals(-1, testStack.pop(), "Das Entfernen von einem leeren Stapel sollte -1 zurückgeben.");

        // Füge ein Element hinzu und entferne es dann
        testStack.push(10);
        assertEquals(10, testStack.pop(), "Das einzige Element (10) sollte entfernt werden.");

        // Überprüfe, dass der Stapel nach dem Entfernen wieder leer ist
        assertTrue(testStack.isEmpty(), "Der Stapel sollte nach dem Entfernen des einzigen Elements leer sein.");
    }

    @Test
    public void checkStackSize() {
        // Überprüfe die Größe des Stapels
        assertEquals(0, testStack.size(), "Die Größe des neuen Stapels sollte 0 sein.");

        testStack.push(10);
        assertEquals(1, testStack.size(), "Die Größe des Stapels sollte 1 sein, nachdem ein Element hinzugefügt wurde.");

        testStack.push(20);
        assertEquals(2, testStack.size(), "Die Größe des Stapels sollte 2 sein, nachdem ein weiteres Element hinzugefügt wurde.");

        testStack.pop();
        assertEquals(1, testStack.size(), "Die Größe des Stapels sollte 1 sein, nachdem ein Element entfernt wurde.");
    }

    @Test
    public void handlePushExceptions() {
        // Überprüfe, ob das Hinzufügen einer negativen Zahl eine Ausnahme auslöst
        Exception illegalArgument = assertThrows(IllegalArgumentException.class, () -> {
            testStack.push(-1);
        });
        assertNotNull(illegalArgument, "Das Hinzufügen einer negativen Zahl sollte eine IllegalArgumentException auslösen.");

        // Fülle den Stapel, um StackOverflowError zu testen
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5); // Der Stapel ist jetzt voll

        // Überprüfe, ob das Hinzufügen, wenn der Stapel voll ist, eine Ausnahme auslöst
        StackOverflowError stackOverflow = assertThrows(StackOverflowError.class, () -> {
            testStack.push(6);
        });
        assertNotNull(stackOverflow, "Das Hinzufügen zu einem vollen Stapel sollte eine StackOverflowError auslösen.");
    }

    @Test
    public void testTop() {
        // Überprüfe das Top-Element eines leeren Stapels
        assertEquals(-1, testStack.top(), "Das Top-Element eines leeren Stapels sollte -1 zurückgeben.");

        // Füge ein Element hinzu und überprüfe das Top-Element
        testStack.push(10);
        assertEquals(10, testStack.top(), "Das Top-Element sollte 10 sein.");

        // Füge ein weiteres Element hinzu und überprüfe das Top-Element
        testStack.push(20);
        assertEquals(20, testStack.top(), "Das Top-Element sollte 20 sein.");

        // Entferne das oberste Element und überprüfe das neue Top-Element
        testStack.pop();
        assertEquals(10, testStack.top(), "Das Top-Element sollte jetzt 10 sein.");

        // Entferne das letzte Element und überprüfe wieder
        testStack.pop();
        assertEquals(-1, testStack.top(), "Das Top-Element eines leeren Stapels sollte wieder -1 zurückgeben.");
    }
}