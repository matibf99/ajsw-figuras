package com.example.shapesapplication.printers;

import com.example.shapesapplication.printables.PrintableShape;

import java.util.Collection;
import java.util.Iterator;

public class Printer implements Runnable {
    private final String name;
    private final Collection<PrintableShape> shapes;

    public Printer(String name, Collection<PrintableShape> shapes) {
        this.name = name;
        this.shapes = shapes;

        System.out.println("Created printer " + name);
    }

    @Override
    public void run() {
        String lastColor = null;

        while (true) {
            PrintableShape shapeToPrint = null;
            int position;

            synchronized (shapes) {
                Iterator<PrintableShape> iterator = shapes.iterator();

                position = 1;
                while (iterator.hasNext()) {
                    PrintableShape shape = iterator.next();

                    if (!shape.isPrinted() && shape.getName().equals(name)) {
                        shapeToPrint = shape;
                        break;
                    } else if (!shape.isPrinted()) {
                        // if the next figure to be printed is not of the type of this printer,
                        // we exit the loop so that they are printed in order of arrival
                        break;
                    }

                    position++;
                }

                if (shapeToPrint != null) {
                    shapeToPrint.setPrinted(true);
                    String color = shapeToPrint.getColor();

                    if (color.equals(lastColor)) {
                        System.out.println("Printer " + name + " printing shape #" + position + ": " + shapeToPrint.getName() + " with color " + color);
                    } else {
                        System.out.println("Printer " + name + " changing color to " + color);

                        try {
                            Thread.sleep(1000); // wait some time before printing because we're changing color
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Printer " + name + " printing shape #" + position + ": " + shapeToPrint.getName() + " with color " + color);
                    }

                    lastColor = color;
                }
            }

            if (shapeToPrint == null) {
                try {
                    Thread.sleep(1000); // wait some time before checking again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(2000); // simulate some delay before printing next shape
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
