import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private int val1 = 8, val2 = 2;
    @Test
    void add() {
        Calculator calc = new Calculator(val1,val2);
        val1 = calc.add();
        int expect = 10;
        assertEquals(expect,val1);
    }

    @Test
    void minus() {
        Calculator calc = new Calculator(val1,val2);
        int hasil = calc.minus();
        assertNotNull(hasil);
    }

    @Test
    void multiply() {
        Calculator calc = new Calculator(val1,val2);
        int hasil = calc.multiply();
        int expect = 16;
        assertAll(
                () -> assertEquals(8,calc.val1),
                () -> assertEquals(2,calc.val2),
                () -> assertEquals(expect,hasil)
        );
    }

    @Test
    void divide() {
        Calculator calc = new Calculator(val1,val2);
        int hasil = calc.divide();
        int hasil2 =  hasil;
        assertSame(hasil,hasil2);
    }
}