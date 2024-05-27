package Taylor;

public class Ejercicio_2 {
   
    public static void main(String[] args) {
        // Ecuación diferencial: dy/dx = y - x^2
        // Condiciones iniciales: y(0) = 2
        double x0 = 0, y0 = 2, x, y, h = 0.05, xEnd = 0.2;
        int n = (int)((xEnd - x0) / h);
        
        x = x0;
        y = y0;
        
        System.out.println("x\ty");
        System.out.println(x + "\t" + y);
        
        for (int i = 0; i < n; i++) {
            double k1 = h * dydx(x, y);
            double k2 = h * (dydx(x + h, y + k1));
            
            y = y + (k1 + k2) / 2;
            x = x + h;
            System.out.println(x + "\t" + y);
        }
    }
    
    public static double dydx(double x, double y) {
        return y - x * x;
    }
}
