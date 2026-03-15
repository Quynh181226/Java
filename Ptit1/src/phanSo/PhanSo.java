package phanSo;
public class PhanSo {
    private long tu, mau;
    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }
    public String toString(){
        return tu + "/" + mau;
    }
    public void rutGon(){
        long x = usc(tu,mau);
        tu /= x; mau /= x;
    }

    private long usc(long a, long b){
        while(b > 0){
            long t = a%b; a = b; b =t;
        }
        return a;
    }
}
