import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyMathsTest {

    private final MyMaths myMaths = new MyMaths();

    @Test
    public void testStatementCoverage() {
        // Testen der neuen Fälle
        assertEquals(4, myMaths.gcd(8, 12), "GCD von (8, 12) sollte 4 sein");

    }

    @Test
    public void testBranchCoverage() {
        // Testen der neuen Fälle
        assertEquals(4, myMaths.gcd(8, 12), "GCD von (8, 12) sollte 4 sein");
        assertEquals(8, myMaths.gcd(8, 8), "GCD von (8, 8) sollte 8 sein");
    }
}