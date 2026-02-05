package Pratice1;

import java.util.*;

public class Chuan_hoa_xau_ho_ten {
    public static void main(String[] args) {
        //Bai2: Chuan hoa xau ho ten
        //Một xâu họ tên được coi là viết chuẩn nếu chữ cái đầu tiên mỗi từ được viết hoa, các chữ
        //cái khác viết thường. Các từ cách nhau đúng một dấu cách và không có khoảng trống
        //thừa ở đầu và cuối xâu. Hãy viết chương trình đưa các xâu họ tên về dạng chuẩn.
        //Dữ liệu vào: Dòng 1 ghi số bộ test.
        //Mỗi bộ test ghi trên một dòng xâu ký tự họ tên, không quá 80 ký tự.
        //Kết quả: Với mỗi bộ test ghi ra xâu ký tự họ tên đã chuẩn hóa.
        //Ví dụ:
        //Input
        // nGuYEN vAN naM
        //tRan TRUNG hiEU
        //  vO le hOA bINh
        //Output
        //Nguyen Van Nam
        //Tran Trung Hieu
        //Vo Le Hoa Binh
//        Scanner sc = new Scanner(System.in);
//        int t=Integer.parseInt(sc.nextLine());
//        while(t-->0){
//            String s=sc.nextLine().trim().toLowerCase();
//            //Ktra do dai
//            if(s.length()>80){
//                //>max(80)=> Bo qua in dong trong
//                //Chuyen sang test ttheo
//                continue;
//            }
//            String[] a=s.split("\\s+");
//            //For each : item la 1 chuoi dai dien cho 1 tu trg ten
//            //CharAt() : la phtuc cua lop String, tra ve ky tu tai vtri chi so duoc chi dinh
//            //=> lay ky tu () cua chuoi item
//            //String.valueOf() : la 1 phtuc tinh cua lop String chuyen doi 1 gia tri thanh 1 chuoi
//            //=> eg: 'n' => "n" : tai sao phai chuyen u tai vi de dung pthuc toUpperCase() (chi adung cho chuoi, ko adung ttiep cho kieu char)
//            //Luồng xử lý:
//            // item = "nguyen".
//            // item.charAt(0): Lấy 'n' (kiểu char).
//            // String.valueOf('n'): Chuyển 'n' thành "n" (kiểu String).
//            // "n".toUpperCase(): Chuyển "n" thành "N".
//            // item.substring(1): Lấy chuỗi con của item từ vị trí 1 đến hết, tức là "guyen".
//            // "guyen".toLowerCase(): Chuyển "guyen" thành "guyen".
//            // "N" + "guyen": "Nguyen".
//            //=> in ra chuoi "Nguyen"
//            for (String item : a) {
//                if(!item.isEmpty()){
////                    System.out.print(String.valueOf(item.charAt(0)).toUpperCase() + item.substring(1) + " ");
//                    char s1=Character.toUpperCase(item.charAt(0));
//                    String s2=item.substring(1);
//                    String s3=s1+s2;
//                    System.out.print(s3+" ");
//                }
//            }
//            System.out.println();
//        }
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String hoten=sc.nextLine();
            System.out.println(chuanHoa(hoten));
        }
    }

    public static String chuanHoa(String s) {
        StringBuilder kq=new StringBuilder();
        StringTokenizer st=new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            String tu=st.nextToken();
            kq.append(Character.toUpperCase(tu.charAt(0)));

            for(int i=1;i<tu.length();i++) {
                kq.append(Character.toLowerCase(tu.charAt(i)));
            }
            kq.append(" ");
        }
        return kq.toString().trim();
    }
}
