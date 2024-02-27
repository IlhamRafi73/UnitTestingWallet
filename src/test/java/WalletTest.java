
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @BeforeEach
    public  void setUp() {
        Wallet.listUangKoin = new ArrayList<>();
        Wallet.listUangLembaran = new ArrayList<>();
    }

    @Test
    public void testOwner() {
        Wallet wallet = new Wallet("Slamet");
        assertEquals("Alice", wallet.owner);
    }

    @Test
    public void testTambahKartu() {
        Wallet wallet = new Wallet("Soeharto");
        wallet.tambahKartu("Credit Card");
        assertTrue(wallet.listKartu.contains("Credit Card"));
    }

    @Test
    public void testAmbilKartu() {
        Wallet wallet = new Wallet("Saman Brembo");
        wallet.tambahKartu("Debit Card");
        assertEquals("Debit Card", wallet.ambilKartu("Debit Card"));
        assertNull(wallet.ambilKartu("Nonexistent Card"));
    }

    @Test
    public void testTambahUangRupiahPositive() {
        Wallet.tambahUangRupiah(5000);
        Wallet.tambahUangRupiah(100);
        assertEquals(1, Wallet.listUangKoin.size());
        assertEquals(1, Wallet.listUangLembaran.size());
        assertEquals(5000, (int) Wallet.listUangLembaran.get(0));
        assertEquals(100, (int) Wallet.listUangKoin.get(0));
    }

    @Test
    public void testTambahUangRupiahNegative() {
        assertThrows(Error.class, () -> {
            Wallet.tambahUangRupiah(-100);
        });
    }
S
    @Test
    public void testAmbilUangAvailable() {
        Wallet.tambahUangRupiah(2000);
        assertEquals(2000, Wallet.ambilUang(2000));
    }

    @Test
    public void testAmbilUangNotAvailable() {
        Wallet.tambahUangRupiah(1000);
        assertEquals(0, Wallet.ambilUang(500));
    }

    @Test
    public void testTampilkanUang() {
        Wallet wallet = new Wallet("Maryono");
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(1000);
        wallet.tambahUangRupiah(500);

        int totalMoney = wallet.tampilkanUang();
        assertEquals(6500, totalMoney);
    }
}