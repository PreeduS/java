
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {
    static MathUtils m;

    // @BeforeEach
    // @AfterEach
    // @BeforeAll
    // @AfterAll

    @BeforeAll
    static void init(){
        m = new MathUtils();
    }

    @Test
    void testAdd(){
        // fail("not implemented");
        int addResult = m.add(5, 10);
        assertEquals(15, addResult);

    }

    @Test
    @DisplayName("testDivide DisplayName")
    void testDivide(){
        assertThrows(ArithmeticException.class, () -> m.divide(10,0));
        assertEquals(5, m.divide(10,2));

    }

    @Test
    // @Disabled                // skip test
    void test(){
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "assertArrayEquals message");
        assertFalse(false, "assertFalse message");
        assertTrue(true);

    }

}   