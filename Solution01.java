import java.util.*;

interface Shape {
    String getName();
    double getArea();
    double getPerimeter();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return "rectangle";
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// Escreva a classe Circle aqui, implementando Shape

// Escreva a classe Triangle aqui, implementando Shape

public class Solution01 {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal, qualquer que seja o idioma do computador
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        Shape[] shapes = new Shape[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            if (type.equals("RECTANGLE")) {
                double width = Double.parseDouble(scanner.next());
                double height = Double.parseDouble(scanner.next());
                shapes[i] = new Rectangle(width, height);
            } else if (type.equals("CIRCLE")) {
                double radius = Double.parseDouble(scanner.next());
                shapes[i] = new Circle(radius);
            } else {
                double a = Double.parseDouble(scanner.next());
                double b = Double.parseDouble(scanner.next());
                double c = Double.parseDouble(scanner.next());
                shapes[i] = new Triangle(a, b, c);
            }
        }
        scanner.close();

        printReport(shapes);
    }

    // Escreva o método printReport aqui
}
