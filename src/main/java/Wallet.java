import java.util.ArrayList;
import java.util.List;

public class Wallet {
    String owner;
    List<String> listKartu;
    static List<Integer> listUangKoin;
    static List<Integer> listUangLembaran;

    public Wallet(String owner) {
        this.owner = owner;
        listKartu = new ArrayList<>();
        listUangKoin = new ArrayList<>();
        listUangLembaran = new ArrayList<>();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void tambahKartu(String namaKartu)
    {
        this.listKartu.add(namaKartu);
    }

    public String ambilKartu(String namaKartu){
        boolean isDeleted = this.listKartu.remove(namaKartu);
        if(isDeleted){
            return namaKartu;
        }
        return null;
    }

    public static void tambahUangRupiah(int jumlahUang){
        if(jumlahUang < 0){
            throw new Error("Jumlah uang tidak boleh minus");
        }

        if(jumlahUang > 1000){
            listUangLembaran.add(jumlahUang);
        }else {
            listUangKoin.add(jumlahUang);
        }

    }

    public static int ambilUang(int jumlahUang){
        boolean isUangLembaranTaken = listUangLembaran.remove(
                Integer.valueOf(jumlahUang));
        if(isUangLembaranTaken){
            return jumlahUang;
        }

        boolean isUangKoinTaken = listUangLembaran.remove(
                Integer.valueOf(jumlahUang));
        if(isUangKoinTaken){
            return jumlahUang;
        }
        return 0;
    }

    public int tampilkanUang(){
        int totalUang = 0;
        for(Integer uang : listUangKoin){
            totalUang += uang;
        }
        for(Integer uang : listUangLembaran){
            totalUang += uang;
        }
        return totalUang;
    }
}

