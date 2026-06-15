**Yêu cầu:**
- Dựa trên bài thực hành 03, xây dựng CSDL (ở đây sử dụng SQLite) để lưu thông tin sản phẩm và truy vấn sản phẩm từ CSDL.

**Cấu trúc thư mục**
├── src
│   ├── Main.java               # File chạy chương trình
│   ├── Product.java            # Class lưu thông tin sản phẩm
│   ├── DatabaseHelper.java     # Class cấu hình, khởi tạo CSDL SQLite và chèn dữ liệu mẫu
│   ├── ProductStoreFrame.java  # Class tạo giao diện chính và load sản phẩm từ CSDL
│   ├── ProductCard.java        # Class hiển thị từng card sản phẩm bên phải
│   ├── ProductDetailPanel.java # Class hiển thị chi tiết sản phẩm bên trái
│   ├── ImageUtil.java          # Class hỗ trợ load, scale và xử lý hình ảnh
│   └── assets                  # Thư mục chứa hình ảnh sản phẩm
├── sqlite-jdbc-3.49.0.0.jar   # Driver kết nối CSDL SQLite
└── README.md

**Cách compile và chạy chương trình**
- Bước 1: Mở CMD tại thư mục chứa project Lab4
- Bước 2: Compile source code:
```
javac -cp "sqlite-jdbc-3.49.0.0.jar" -encoding UTF-8 -d bin src\*.java
```
- Bước 3: Chạy chương trình
```
java -cp "bin;sqlite-jdbc-3.49.0.0.jar" Main
```

**Cách quản lý và kết nối CSDL (SQLite)**
- File CSDL là `products_db.db`, tự động khởi tạo khi chạy chương trình lần đầu.
- Khi sử dụng các công cụ GUI để mở file SQLite `products_db.db`:
  - **Name:** Điền tên bất kỳ (ví dụ: `ProductStore`).
  - **Group:** Có thể bỏ trống hoặc để mặc định.