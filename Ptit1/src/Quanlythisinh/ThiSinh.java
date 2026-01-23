package Quanlythisinh;

/**
 *
 * @author ThS. Hoang Anh
 */
public class ThiSinh {
    private String sobaodanh;
    private String hoten;
    private float toan;
    private float ly;
    private float hoa;

    public ThiSinh() {
    }

    public ThiSinh(String sobaodanh, String hoten, float toan, float ly, float hoa) {
        this.sobaodanh = sobaodanh;
        this.hoten = hoten;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public ThiSinh(String sobaodanh) {
        this.sobaodanh = sobaodanh;
        this.hoten="";
        this.toan=0.0f;
        this.ly=0.0f;
        this.hoa=0.0f;
    }

    public String getSobaodanh() {
        return sobaodanh;
    }

    public void setSobaodanh(String sobaodanh) {
        this.sobaodanh = sobaodanh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    @Override
    public String toString()
    {
        return  sobaodanh+"\t"+hoten+"\t"+toan+"\t"+ly+"\t"+hoa;

    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        ThiSinh other = (ThiSinh) o;
        if (sobaodanh == null) {
            if (other.sobaodanh != null)
                return false;
        } else if(!sobaodanh.equals(other.sobaodanh))
            return false;
        return true;
    }
}