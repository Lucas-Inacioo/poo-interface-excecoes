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
        int n = Integer.parseInt(scanner.nextLine());
        Shape[] shapes = new Shape[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            shapes[count] = parseShape(scanner.nextLine());
            count++;
        }
        scanner.close();

        printReport(Arrays.copyOf(shapes, count));
    }

    public static Shape parseShape(String line) {
        String[] parts = line.split(" ");
        if (parts[0].equals("RECTANGLE")) {
            double width = Double.parseDouble(parts[1]);
            double height = Double.parseDouble(parts[2]);
            return new Rectangle(width, height);
        } else if (parts[0] == "CIRCLE") {
            double radius = Double.parseDouble(parts[1]);
            return new Circle(radius);
        } else {
            double a = Double.parseDouble(parts[1]);
            double b = Double.parseDouble(parts[2]);
            double c = Double.parseDouble(parts[3]);
            return new Triangle(a, b, c);
        }
    }

    public static void printReport(Shape[] shapes) {
        Shape largest = null;
        for (Shape shape : shapes) {
            System.out.printf("%s: area %.2f perimeter %.2f%n", shape.getName(), shape.getArea(), shape.getPerimeter());
            if (largest == null || shape.getArea() >= largest.getArea()) {
                largest = shape;
            }
        }
        System.out.printf("largest area: %s%n", largest.getName());
    }
}
