public class PiApproximator {
    private double precision; 

    public PiApproximator(double precision) {
        this.precision = precision;
    }

    public double estimatePi() {
        double r = 1.0;
        double step = 1.0 / precision; 
        double pointsInside = 0;

        // Quét góc phần tư I
        for (double x = 0; x <= r; x += step) {
            for (double y = 0; y <= r; y += step) {
                // Kiểm tra x^2 + y^2 <= 1^2
                if ((x * x + y * y) <= (r * r)) {
                    pointsInside += (step * step);
                }
            }
        }

        // Diện tích hình tròn đơn vị = Pi * 1^2 = Pi -> Pi = 4 * (diện tích góc phần tư)
        return pointsInside * 4;
    }
}