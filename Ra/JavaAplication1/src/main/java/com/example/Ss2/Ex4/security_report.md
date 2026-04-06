# Bao cao bao mat: JSTL, EL va phong thu XSS (Ex04)

## Cau hoi 1: XSS la gi? Tai sao <c:out> an toan hon ${}?

### XSS (Cross-Site Scripting) la gi?

XSS la mot lo hong bao mat cho phep attacker chen ma JavaScript vao ung dung web de:
- Danh cap cookie/session cua user khac
- Thay doi noi dung trang web
- Redirect user toi trang doc hai
- Thuc hien hanh dong thay mat user (fake transfer, phishing)

### Vi du tan cong XSS:

User nhap vao o tim kiem: