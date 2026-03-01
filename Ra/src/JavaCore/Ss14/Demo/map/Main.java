package JavaCore.Ss14.Demo.map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Map lưu cặp key val (key - Khóa là 1 SET<key>), giống Class
        //Map tương tự SET
        //Key ko trùng lặp

        // 4 Lớp triển khai
        //HashMap
        //LinkedHashMap
        //TreeMap
        //EnumMap

        Map<String, String> dictionary = new HashMap<>();

        //Các pthuc lm vc
        dictionary.put("apple", "banana"); // Thêm or chỉnh sửa
        dictionary.put("apple", "orange"); // Thêm or chỉnh sửa

        dictionary.remove("apple");

        String val=dictionary.get("apple");

        /// ////
        //Pthuc ktra tồn tại (2) - Trả về có or ko ( tồn tại hay ko tồn tại )
        dictionary.containsKey("apple");
        dictionary.containsValue("banana");

        //Duyệt collection
        // Ko lưu trữ gtri đơn và lưu trữ .....???
        //Nên ns duyệt theo 3 cách
        //Từ 1 key có the suy ra đc val tương ứng
        //Nhg ngc lại thì ko suy đc
        //Theo key
        for(String key: dictionary.keySet()){
            //Lm vc vs key
        }
        //Theo Val
        for (String values: dictionary.values()){
            //Lm vc vs val
        }
        //Theo cả 2
        //Đc định nghĩa bên trg Map và là thành phần tĩnh (Entry)
        for(Map.Entry<String, String > entry: dictionary.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
        }
    }
}
