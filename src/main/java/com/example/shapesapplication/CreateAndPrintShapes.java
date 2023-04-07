package com.example.shapesapplication;

import com.example.shapesapplication.generators.Person;
import com.example.shapesapplication.printables.PrintableShape;
import com.example.shapesapplication.printers.Printer;
import com.example.shapesapplication.utils.GeometricShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateAndPrintShapes {
    public static void main(String... args) {
        List<PrintableShape> shapes = Collections.synchronizedList(new ArrayList<>());

        final int NUM_SHAPES = Integer.MAX_VALUE;

        Person person1 = new Person("Person 1", shapes, NUM_SHAPES/2);
        Person person2 = new Person("Person 2", shapes, NUM_SHAPES/2);

        Printer circlePrinter = new Printer(GeometricShapeType.CIRCLE.toString(), shapes);
        Printer squarePrinter = new Printer(GeometricShapeType.SQUARE.toString(), shapes);
        Printer rectanglePrinter = new Printer(GeometricShapeType.RECTANGLE.toString(), shapes);
        Printer equilateralTrianglePrinter = new Printer(GeometricShapeType.EQUILATERAL_TRIANGLE.toString(), shapes);

        Thread person1Thread = new Thread(person1);
        Thread person2Thread = new Thread(person2);

        Thread circlePrinterThread = new Thread(circlePrinter);
        Thread squarePrinterThread = new Thread(squarePrinter);
        Thread rectanglePrinterThread = new Thread(rectanglePrinter);
        Thread equilateralTrianglePrinterThread = new Thread(equilateralTrianglePrinter);

        person1Thread.start();
        person2Thread.start();

        circlePrinterThread.start();
        squarePrinterThread.start();
        rectanglePrinterThread.start();
        equilateralTrianglePrinterThread.start();
    }
}
