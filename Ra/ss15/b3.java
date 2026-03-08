import java.util.Stack;

public class b3 {
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