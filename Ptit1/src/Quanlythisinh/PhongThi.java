package Quanlythisinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ThS. Hoang Anh
 */
public class PhongThi {
    private String mapt;
    private String phongthi;
    private int soluong;
    private ArrayList<ThiSinh> list;

    public PhongThi() {
    }

    public PhongThi(String mapt, String phongthi, int soluong) {
        this.mapt = mapt;
        this.phongthi = phongthi;
        this.soluong = soluong;
        list= new ArrayList<ThiSinh>();
    }

    public boolean themThiSinh()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Nhap thong tin thi sinh");
        System.out.print("\n Nhap so bao danh: ");
        String sobaodanh = input.nextLine();
        ThiSinh ts = new ThiSinh(sobaodanh);
        if(list.contains(ts))
            return false;
        System.out.print("\n Nhap Ho ten: ");
        String hoten=input.nextLine();
        ts.setHoten(hoten);
        return list.add(ts);
    }

    public boolean suaThiSinh() {
        Scanner input=new Scanner(System.in);
        System.out.print("\n Nhap so bao danh thi sinh can sua: ");
        String sobaodanh = input.nextLine();
        ThiSinh ts = new ThiSinh(sobaodanh,"",0f,0f,0f);
        if(!list.contains(ts))
            return false;
        System.out.println("index: "+ list.indexOf(ts));
        ts = list.get(list.indexOf(ts));
        System.out.print("\n Nhap ho ten: ");
        String hoten = input.nextLine();
        ts.setHoten(hoten);
        return true;
    }

    public void nhapDiem(){
        Scanner in=new Scanner(System.in);
        inDanhSach();
        float dt,dl,dh;
        //int i=0;
        for(ThiSinh t:list){
            System.out.println("So bao danh:"+t.getSobaodanh());
            System.out.print("Nhap diem toan:");
            dt=Float.parseFloat(in.nextLine());
            System.out.print("\n Nhap diem ly:");
            dl=Float.parseFloat(in.nextLine());
            System.out.print("\n Nhap diem hoa:");
            dh=Float.parseFloat(in.nextLine());
            //t=list.get(i);
            t.setToan(dt);
            t.setLy(dl);
            t.setHoa(dh);
            //i++;
        }
    }

    public void sapXepByTen(){
        Collections.sort(list, new Comparator<ThiSinh>() {
                    @Override
                    public int compare(ThiSinh sv1, ThiSinh sv2) {
                        return (sv1.getHoten().compareTo(sv2.getHoten()));
                    }
                }
        );
    }
    public void sapXepByDiemToan(){
        Collections.sort(list, new Comparator<ThiSinh>(){
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if (o1.getToan()<o2.getToan()){
                    return 1;
                }
                else {
                    if (o1.getToan()==o2.getToan()){
                        return 0;
                    }
                    else return -1;
                }
            }
        });
    }

    public  void inDanhSach(){
        System.out.println("=DANH SACH SINH VIEN=");
        System.out.println("So BD  Ho va ten Diem Toan  Diem Ly    Diem Hoa");
        for (ThiSinh sv: list)
            System.out.println(sv.toString());
        System.out.println("=====================================");
    }

    public String getMapt() {
        return mapt;
    }

    public void setMapt(String mapt) {
        this.mapt = mapt;
    }

    public String getPhongthi() {
        return phongthi;
    }

    public void setPhongthi(String phongthi) {
        this.phongthi = phongthi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public ArrayList<ThiSinh> getList() {
        return list;
    }

    public void setList(ArrayList<ThiSinh> list) {
        this.list = list;
    }

}