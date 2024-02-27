import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calc = new Calculator(2,8);
        int actual = calc.add();
        int expect = 10;
        assertEquals(expect,actual);
    }

    @Test
    void minus() {
        Calculator calc = new Calculator(8,4);
        int hasil = calc.minus();
        assertNotNull(hasil);
    }

    @Test
    void multiply() {
        Calculator calc = new Calculator(8,2);
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
        Calculator calc = new Calculator(8,2);
        int hasil = calc.divide();
        int hasil2 =  hasil;
        assertSame(hasil,hasil2);
    }
}