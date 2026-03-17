public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double approximateArea() {
        // Chia nhỏ bán kính thành các bước nhảy (step)
        double step = radius / 2000; 
        double totalArea = 0;

        // Quét qua các điểm trong hình vuông bao quanh góc phần tư thứ nhất (x > 0, y > 0)
        for (double x = 0; x <= radius; x += step) {
            for (double y = 0; y <= radius; y += step) {
                Point p = new Point(x, y);
                
                if (p.isInsideCircle(radius)) {
                    // Nếu điểm nằm trong, cộng diện tích của ô vuông nhỏ (step * step)
                    totalArea += (step * step);
                }
            }
        }

        // Vì ta chỉ quét 1/4 hình tròn nên phải nhân 4 để ra diện tích toàn phần
        return totalArea * 4;
    }
}