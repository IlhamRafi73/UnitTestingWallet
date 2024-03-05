
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {

    private static Wallet wallet;

    @BeforeAll
    static void setup() {
        wallet = new Wallet("Budi");
    }

    @AfterAll
    static void tearDown() {
        wallet = null;
    }

    @BeforeEach
    void init() {
        // Tidak ada
    }

    @AfterEach
    void cleanup() {
        wallet.listKartu.clear();
        wallet.listUangKoin.clear();
        wallet.listUangLembaran.clear();
    }

    @Test
    void testConstructor() {
        assertNotNull(wallet);
        assertEquals("Budi", wallet.owner);
        assertTrue(wallet.listKartu.isEmpty());
        assertTrue(wallet.listUangKoin.isEmpty());
        assertTrue(wallet.listUangLembaran.isEmpty());
    }

    @Test
    void testTambahKartu() {
        wallet.tambahKartu("Kartu ATM");
        assertFalse(wallet.listKartu.isEmpty());
        assertEquals(1, wallet.listKartu.size());
        assertEquals("Kartu ATM", wallet.listKartu.get(0));
    }

    @Test
    void testAmbilKartu() {
        wallet.tambahKartu("Kartu E-money");
        String kartuDiambil = wallet.ambilKartu("Kartu E-money");
        assertNotNull(kartuDiambil);
        assertEquals("Kartu E-money", kartuDiambil);
        assertTrue(wallet.listKartu.isEmpty());
    }

    @Test
    void testTambahUangRupiah() {
        wallet.tambahUangRupiah(1000);
        assertAll(
                () -> assertEquals(1, wallet.listUangLembaran.size()),
                () -> assertEquals(1000, wallet.listUangLembaran.get(0))

        );
        assertEquals(1, wallet.listUangLembaran.size());
        assertEquals(1000, wallet.listUangLembaran.get(0));

        wallet.tambahUangRupiah(500);
        wallet.tambahUangRupiah(200);

        assertAll(
                () -> assertEquals(2, wallet.listUangKoin.size()),
                () -> assertEquals(500, wallet.listUangKoin.get(0)),
                () -> assertEquals(200, wallet.listUangKoin.get(1))

        );

        assertThrows(Error.class, () -> wallet.tambahUangRupiah(-100));
    }

    @Test
    void testAmbilUang() {
        wallet.tambahUangRupiah(1000);
        int uangDiambil = wallet.ambilUang(1000);
        assertEquals(1000, uangDiambil);
        assertTrue(wallet.listUangLembaran.isEmpty());

        wallet.tambahUangRupiah(500);
        uangDiambil = wallet.ambilUang(500);
        assertEquals(500, uangDiambil);
        assertTrue(wallet.listUangKoin.isEmpty());

    }

    @Test
    void testTampilkanUang() {
        wallet.tambahUangRupiah(1000);
        wallet.tambahUangRupiah(500);
        assertEquals(1500, wallet.tampilkanUang());
    }
}