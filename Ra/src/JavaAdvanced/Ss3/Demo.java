package JavaAdvanced.Ss3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        //Tạo stream: Arr và Collection
        int[] arr={1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);

        //Thao tác trung gian: sorted, timit, distint, filter, map,...
        IntStream stream1=stream.filter(val->val%2==0);

        //Thao tác đầu cuối: sum, foreach, reduce, count, finFist, findAny, anyMatch, allMatch, min, max, average
        OptionalDouble avg=stream1.average();
        System.out.println("Avg: "+avg.getAsDouble());

        // Tạo danh sách 1000 số ngẫu nhiên từ -200 đến 200
        List<Integer> randomList = Stream.generate(() -> new Random().nextInt(401) - 200)
                .limit(1000)
                .collect(Collectors.toList());

        // Để kiểm tra nhanh, in thử 10 phần tử đầu
        System.out.println("10 số đầu tiên trong danh sách:");
        randomList.stream().limit(10).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 1. Lọc và in các số nguyên dương ra màn hình
        System.out.println("1. Các số nguyên dương:");
        randomList.stream()
                .filter(n -> n > 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 2. Loại các số trùng lặp
        System.out.println("2. Số lượng phần tử sau khi loại trùng lặp: " +
                randomList.stream().distinct().count());

        // 3. Sắp xếp các số theo thứ tự từ lớn đến bé (descending)
        System.out.println("3. 15 số lớn nhất (sắp xếp giảm dần):");
        randomList.stream()
                .sorted(Comparator.reverseOrder())
                .limit(15)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 4. Tính min, max
        Optional<Integer> minOpt = randomList.stream().min(Integer::compareTo);
        Optional<Integer> maxOpt = randomList.stream().max(Integer::compareTo);

        System.out.println("4. Min = " + (minOpt.isPresent() ? minOpt.get() : "không có"));
        System.out.println("   Max = " + (maxOpt.isPresent() ? maxOpt.get() : "không có"));

        // 5. Tính tổng của tất cả các phần tử
        long total = randomList.stream()
                .mapToLong(Integer::longValue)  // tránh tràn int
                .sum();

        System.out.println("5. Tổng tất cả phần tử: " + total);

        // 6. Kiểm tra giá trị n nhập vào có tồn tại trong danh sách không
        Scanner sc = new Scanner(System.in);
        System.out.print("\n6. Nhập số cần tìm: ");
        int n = sc.nextInt();

        boolean exists = randomList.stream().anyMatch(x -> x == n);
        System.out.println("   → Số " + n + " " + (exists ? "CÓ" : "KHÔNG") + " tồn tại trong danh sách");

        // 7. Chuyển các số âm thành đối của nó → tạo danh sách mới
        List<Integer> transformed = randomList.stream()
                .map(x -> x < 0 ? -x : x)
                .collect(Collectors.toList());

        System.out.println("7. Một số phần tử sau khi chuyển số âm thành dương:");
        transformed.stream().limit(15).forEach(x -> System.out.print(x + " "));
        System.out.println("\n");

        // Bonus: Thống kê nhanh
        System.out.println("Thống kê nhanh:");
        System.out.println("Số lượng phần tử: " + randomList.size());
        System.out.println("Số lượng số dương: " + randomList.stream().filter(x -> x > 0).count());
        System.out.println("Số lượng số âm:   " + randomList.stream().filter(x -> x < 0).count());
        System.out.println("Số lượng số 0:    " + randomList.stream().filter(x -> x == 0).count());
    }
}
