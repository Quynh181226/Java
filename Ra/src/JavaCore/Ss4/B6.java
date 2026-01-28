package JavaCore.Ss4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Sinh viên có thể viết đánh giá về sách, nhưng hệ thống cần chặn các từ ngữ không phù hợp và định dạng lại nội dung
//
//Yêu cầu:
//Tạo một danh sách "Blacklist" các từ nhạy cảm
//Sử dụng Regex để tìm tất cả các từ trong Blacklist (không phân biệt hoa thường) trong đoạn đánh giá
//Thay thế các từ nhạy cảm đó bằng ký tự hình sao (****) dựa trên độ dài của từ đó
//Nếu đoạn đánh giá quá dài (trên 200 ký tự), hãy sử dụng substring và StringBuilder để cắt ngắn và thêm dấu ba chấm "..." ở cuối, nhưng phải đảm bảo không cắt ngang giữa một từ
public class B6 {
    public static void main(String[] args) {
        String[] blacklist = { "ngu", "xấu", "te", "dở" };
        String regex = "\\b(" + String.join("|", blacklist) + ")\\b";
        String review = "Cuốn sách này quá ngu và nội dung rất te Đọc xong thấy thật dở";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String result = getString(pattern, review);

        if (result.length() > 10) {
            int cutIndex = result.lastIndexOf(" ", 200);
            if (cutIndex == -1) {
                cutIndex = 200;
            }
            result = result.substring(0, cutIndex) + "...";
        }

        System.out.println(result);



    }

    private static String getString(Pattern pattern, String review) {
        Matcher matcher = pattern.matcher(review);
        StringBuilder filteredReview = new StringBuilder();
        int lastEnd = 0;


        while (matcher.find()) {
            filteredReview.append(review, lastEnd, matcher.start());

            int length = matcher.group().length();
            filteredReview.append("*".repeat(length));

            lastEnd = matcher.end();
        }
        filteredReview.append(review.substring(lastEnd));

        String result = filteredReview.toString();
        return result;
    }
}
