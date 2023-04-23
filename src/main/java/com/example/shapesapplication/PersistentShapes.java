package com.example.shapesapplication;

import com.example.shapesapplication.models.Circle;
import com.example.shapesapplication.models.EquilateralTriangle;
import com.example.shapesapplication.models.Rectangle;
import com.example.shapesapplication.models.Square;
import com.example.shapesapplication.models.GeometricShapeColor;
import com.example.shapesapplication.models.GeometricShapeType;
import com.example.shapesapplication.services.CircleService;
import com.example.shapesapplication.services.EquilateralTriangleService;
import com.example.shapesapplication.services.RectangleService;
import com.example.shapesapplication.services.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class PersistentShapes {

    CircleService circleService;
    SquareService squareService;
    RectangleService rectangleService;
    EquilateralTriangleService equilateralTriangleService;
    Scanner scanner;

    @Autowired
    public PersistentShapes(CircleService circleService, SquareService squareService, RectangleService rectangleService, EquilateralTriangleService equilateralTriangleService) {
        this.circleService = circleService;
        this.squareService = squareService;
        this.rectangleService = rectangleService;
        this.equilateralTriangleService = equilateralTriangleService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("\n--- Persistent Shapes ---\n");

        int option = 0;
        while (option != 5) {
            System.out.print("""
                    Select and option:
                    1. Create a new shape
                    2. Find a shape by type and ID
                    3. List all shapes of a specific type
                    4. Update a shape by type and ID
                    5. Exit
                    Input:\s""");

            option = scanner.nextInt();

            System.out.print("\n--- * ---\n\n");

            switch (option) {
                case 1 -> createShape();
                case 2 -> findShapeByIdAndType();
                case 3 -> listAllShapesOfType();
                case 4 -> updateShapeByIdAndType();
                case 5 -> System.out.println("Bye!");
                default -> System.out.println("Illegal option");
            }

            System.out.println("Press ENTER key to continue");
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("\n");
        }
    }

    private void createShape() {
        GeometricShapeType shapeType = askShapeType();
        GeometricShapeColor shapeColor = askShapeColor();

        switch (shapeType) {
            case CIRCLE -> {
                System.out.print("Radius: ");
                double radius = scanner.nextDouble();
                Circle circle = new Circle();
                circle.setRadius(radius);
                circle.setColor(shapeColor.toString());

                circleService.createCircle(circle);

                System.out.println("Circle saved");
            }
            case SQUARE -> {
                System.out.print("Length: ");
                double length = scanner.nextDouble();
                Square square = new Square();
                square.setLength(length);
                square.setColor(shapeColor.toString());

                squareService.createSquare(square);

                System.out.println("Square saved");
            }
            case RECTANGLE -> {
                System.out.print("Width: ");
                double width = scanner.nextDouble();
                System.out.print("Height: ");
                double height = scanner.nextDouble();
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(width);
                rectangle.setHeight(height);
                rectangle.setColor(shapeColor.toString());

                rectangleService.createRectangle(rectangle);

                System.out.println("Rectangle saved");
            }
            case EQUILATERAL_TRIANGLE -> {
                System.out.print("Length: ");
                double length2 = scanner.nextDouble();
                EquilateralTriangle triangle = new EquilateralTriangle();
                triangle.setLength(length2);
                triangle.setColor(shapeColor.toString());

                equilateralTriangleService.createEquilateralTriangle(triangle);

                System.out.println("Equilateral triangle saved");
            }
            default -> System.out.println("Illegal argument");
        }
    }

    private void findShapeByIdAndType() {
        GeometricShapeType shapeType = askShapeType();
        long id = askShapeId();

        System.out.println();
        switch (shapeType) {
            case CIRCLE -> {
                Circle circle = circleService.getCircleById(id);
                System.out.printf("Circle #%d, radius: %.2f, color: %s\n", circle.getId(), circle.getRadius(), circle.getColor());
            }
            case EQUILATERAL_TRIANGLE -> {
                EquilateralTriangle triangle = equilateralTriangleService.getEquilateralTriangleById(id);
                System.out.printf("Equilateral Triangle #%d, length: %.2f, color: %s\n", triangle.getId(), triangle.getLength(), triangle.getColor());
            }
            case SQUARE -> {
                Square square = squareService.getSquareById(id);
                System.out.printf("Square #%d, length: %.2f, color: %s\n", square.getId(), square.getLength(), square.getColor());
            }
            case RECTANGLE -> {
                Rectangle rectangle = rectangleService.getRectangleById(id);
                System.out.printf("Rectangle #%d, width: %.2f, height: %.2f, color: %s\n", rectangle.getId(), rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());
            }
            default -> System.out.println("Illegal shape type");
        }
        System.out.println();
    }

    private void listAllShapesOfType() {
        GeometricShapeType type = askShapeType();

        System.out.println();
        switch (type) {
            case CIRCLE -> {
                List<Circle> list = circleService.getAllCircles();
                list.forEach(circle -> System.out.printf("Circle #%d, radius: %.2f, color: %s\n", circle.getId(), circle.getRadius(), circle.getColor()));
            }
            case SQUARE -> {
                List<Square> list = squareService.getAllSquares();
                list.forEach(square -> System.out.printf("Square #%d, length: %.2f, color: %s\n", square.getId(), square.getLength(), square.getColor()));
            }
            case RECTANGLE -> {
                List<Rectangle> list = rectangleService.getAllRectangles();
                list.forEach(rectangle -> System.out.printf("Rectangle #%d, width: %.2f, height: %.2f, color: %s\n", rectangle.getId(), rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor()));
            }
            case EQUILATERAL_TRIANGLE -> {
                List<EquilateralTriangle> list = equilateralTriangleService.getAllEquilateralTriangles();
                list.forEach(triangle -> System.out.printf("Equilateral Triangle #%d, length: %.2f, color: %s\n", triangle.getId(), triangle.getLength(), triangle.getColor()));
            }
            default -> System.out.println("Illegal shape");
        }
        System.out.println();
    }

    private void updateShapeByIdAndType() {
        GeometricShapeType shapeType = askShapeType();
        long id = askShapeId();

        System.out.println("\nInsert the new data: ");
        GeometricShapeColor newColor = askShapeColor();

        switch (shapeType) {
            case CIRCLE -> {
                Circle circle = circleService.getCircleById(id);

                if (circle != null) {
                    System.out.print("Radius: ");
                    double newRadius = scanner.nextDouble();
                    circle.setColor(newColor.toString());
                    circle.setRadius(newRadius);

                    circleService.updateCircle(circle);
                    System.out.println("Circle updated");
                }
            }
            case EQUILATERAL_TRIANGLE -> {
                EquilateralTriangle triangle = equilateralTriangleService.getEquilateralTriangleById(id);

                if (triangle != null) {
                    System.out.print("Length: ");
                    double newLength = scanner.nextDouble();
                    triangle.setColor(newColor.toString());
                    triangle.setLength(newLength);

                    equilateralTriangleService.updateEquilateralTriangle(triangle);
                    System.out.println("Equilateral triangle updated");
                }
            }
            case SQUARE -> {
                Square square = squareService.getSquareById(id);

                if (square != null) {
                    System.out.print("Length: ");
                    double newLength = scanner.nextDouble();
                    square.setColor(newColor.toString());
                    square.setLength(newLength);

                    squareService.updateSquare(square);
                    System.out.println("Square updated");
                }
            }
            case RECTANGLE -> {
                Rectangle rectangle = rectangleService.getRectangleById(id);

                if (rectangle != null) {
                    System.out.print("Width: ");
                    double newWidth = scanner.nextDouble();
                    System.out.print("Height: ");
                    double newHeight = scanner.nextDouble();
                    rectangle.setColor(newColor.toString());
                    rectangle.setWidth(newWidth);
                    rectangle.setHeight(newHeight);

                    rectangleService.updateRectangle(rectangle);
                    System.out.println("Rectangle updated");
                }
            }
        }
    }

    private GeometricShapeType askShapeType() {
        System.out.println("Enter the shape type:");

        for (int i = 1; i <= GeometricShapeType.values().length; i++) {
            System.out.printf("%d. %s \n", i, GeometricShapeType.values()[i-1]);
        }

        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt() - 1;

        return GeometricShapeType.values()[opt];
    }

    private GeometricShapeColor askShapeColor() {
        System.out.println("Enter the shape color:");

        for (int i = 1; i <= GeometricShapeColor.values().length; i++) {
            System.out.printf("%d. %s \n", i, GeometricShapeColor.values()[i-1]);
        }

        System.out.print("Input: ");
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt() - 1;

        return GeometricShapeColor.values()[opt];
    }

    private long askShapeId() {
        System.out.print("Enter the shape ID:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }
}
