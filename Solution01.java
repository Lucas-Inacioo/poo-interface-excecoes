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
        return 2 * width + height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    double getArea() {
        return Math.PI * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimetre() {
        return a + b + c;
    }
}

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

    public static void printReport(Shape[] shapes) {
        Shape largest = null;
        for (Shape shape : shapes) {
            System.out.printf("%s: area %.2f perimeter %.2f%n", shape.getName(), shape.getArea(), shape.getPerimeter());
            if (largest == null || shape.getArea() >= largest.getArea()) {
                largest = shape;
            }
        }
        System.out.printf("largest area: %s", largest.getName());
    }
}
