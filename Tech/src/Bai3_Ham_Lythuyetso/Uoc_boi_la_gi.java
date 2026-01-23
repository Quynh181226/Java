package Bai3_Ham_Lythuyetso;
//Bội số và Ước số là gì?
//1. Ước số là gì?
//Ước số của một số n là những số chia hết cho n (tức là n chia hết cho chúng mà không có dư).
//
//Ví dụ:
//
//Ước số của 12 là: {1, 2, 3, 4, 6, 12}
//Vì 12 chia hết cho từng số này (12 % 1 == 0, 12 % 2 == 0, v.v.)
//Công thức:
//
//Số a là ước số của b nếu b % a == 0.
//2. Bội số là gì?
//Bội số của một số n là những số được tạo ra bằng cách nhân n với một số nguyên.
//
//Ví dụ:
//
//Bội số của 3 là: {3, 6, 9, 12, 15, 18, ...}
//Vì chúng là 3 × 1, 3 × 2, 3 × 3, 3 × 4, ...
//Công thức:
//
//Số b là bội số của a nếu tồn tại số nguyên k sao cho b = k × a.
//Sự khác nhau giữa Ước số và Bội số
//Thuộc tính	Ước số	            Bội số
//Định nghĩa	Số chia hết cho n	Số nhân lên từ n
//Ví dụ với n = 4	{1, 2, 4}	    {4, 8, 12, 16, ...}
//Tổng quát	Nhỏ hơn hoặc bằng n	Lớn hơn hoặc bằng n
//Cách tính	n % ước số == 0	bội số = n × k (k ∈ ℕ)
//Ghi nhớ nhanh:
//
//Ước số chia hết vào số ban đầu.
//Bội số là số ban đầu nhân lên.
