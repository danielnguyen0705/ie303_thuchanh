**Yêu cầu:**
- Sử dụng Java Swing/JavaFX Thiết kế một website bán sản phẩm có bố cục như hình mẫu (8 điểm). 
- Thêm tính năng click chọn một sản phẩm ở trong danh sách các sản phẩm ở phía bên phải sẽ thay đổi sản phẩm được hiển thị ở phía bên trái (1 điểm).
- Thêm hiệu ứng thay đổi sản phẩm được hiển thị ở phía bên trái khi chọn vào một sản phẩm trong danh sách các sản phẩm ở phía bên phải (1 điểm).

**Cấu trúc thư mục**
```
├── src
│   ├── Main.java               # File chạy chương trình
│   ├── Product.java            # Class lưu thông tin sản phẩm
│   ├── ProductStoreFrame.java  # Class tạo giao diện chính
│   ├── ProductCard.java        # Class hiển thị từng card sản phẩm bên phải
│   ├── ProductDetailPanel.java # Class hiển thị chi tiết sản phẩm bên trái
│   ├── ImageUtil.java          # Class hỗ trợ load, scale và xử lý hình ảnh
│   └── assets                  # Thư mục chứa hình ảnh sản phẩm
└── README.md
```

**Cách compile và chạy chương trình**
- Bước 1: Mở CMD tại thư mục chứa project
- Bước 2: Compile source code:
```
javac -encoding UTF-8 -d bin src\*.java
```
- Bước 3: Chạy chương trình
```
java -cp bin Main
```
