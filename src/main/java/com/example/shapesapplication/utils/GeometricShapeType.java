package com.example.shapesapplication.utils;

public enum GeometricShapeType {
    CIRCLE {
        @Override
        public String toString() {
            return "Circle";
        }
    },
    SQUARE {
        @Override
        public String toString() {
            return "Square";
        }
    },
    RECTANGLE {
        @Override
        public String toString() {
            return "Rectangle";
        }
    },
    EQUILATERAL_TRIANGLE {
        @Override
        public String toString() {
            return "EquilateralTriangle";
        }
    }
}
