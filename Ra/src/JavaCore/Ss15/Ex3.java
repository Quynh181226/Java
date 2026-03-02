package JavaCore.Ss15;

import java.util.Stack;

//[Bài tập] Kiểm tra thứ tự dùng thuốc trong ca trực
//1. Mục tiêu: Vận dụng Stack để kiểm tra trình tự. Tư duy logic, kiểm tra tính hợp lệ.
//2. Mô tả: Trong một ca trực, y tá phải thực hiện các thao tác: Phát thuốc (Push), Hoàn tất phát thuốc (Pop). Danh sách thao tác được ghi lại dưới dạng chuỗi ký tự: PUSH : phát thuốc, POP : hoàn tất.
//Yêu cầu: Dùng Stack để kiểm tra xem quy trình có hợp lệ không. Không được POP khi Stack rỗng. Kết thúc ca trực, Stack phải rỗng.
//Cài đặt lớp MedicationProcessChecker: Thuộc tính: Stack<String> stack. Phương thức: boolean checkProcess(String[] actions), void reset().
//3. Kết quả mong muốn: Chương trình xác định quy trình hợp lệ / không hợp lệ. Giải thích rõ lý do sai (nếu có). Áp dụng đúng nguyên lý Stack.
public class Ex3 {
    static void use(){
        Stack<String> s = new Stack<>();
        MedicationProcessChecker checker = new MedicationProcessChecker(s);
        String[] process1 = {"PUSH", "PUSH", "POP", "POP"};
        checker.checkProcess(process1);
        checker.reset();
        String[] process2 = {"PUSH", "PUSH", "POP"};
        checker.checkProcess(process2);
        checker.reset();

    }
}

class MedicationProcessChecker{
    Stack<String> stack;

    public MedicationProcessChecker(Stack<String> stack) {
        this.stack = stack;
    }

    boolean checkProcess(String[] actions){
        for(String x  :actions){
            if(x.equals("PUSH")){
                stack.push("Medicine Task");
                System.out.println("Đã thêm Medicine Task");
            }else if (x.equals("POP")){
                if (stack.isEmpty()) {
                    System.out.println("Lỗi: Không có tác vụ phát thuốc nào để hoàn tất!");
                    return false;
                }
                System.out.println("Đã POP");
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    void reset(){
        stack.clear();
    }
}