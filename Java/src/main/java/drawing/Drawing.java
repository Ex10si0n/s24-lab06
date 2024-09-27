package drawing;

import drawing.shapes.Line;
import drawing.shapes.Shape;
import drawing.writing.DrawWriter;
import drawing.writing.JPEGWriter;
import drawing.writing.PNGWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Drawing {

    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Draw shapes to a file with given file format.
     *
     * @param format   file format
     * @param filename file name
     */
    public void draw(String format, String filename) {
        // Duplicated draw Functionality for Each File Format
        DrawWriter writer = null;
        try {
            if (format.equals("jpeg")) {
                writer = new JPEGWriter(filename + ".jpeg");
            } else if (format.equals("png")) {
                writer = new PNGWriter(filename + ".png");
            }
            if (writer != null) {
                for (Shape shape : this.shapes) {
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//        if (format.equals("jpeg")) {
//            try (Writer writer = new JPEGWriter(filename + ".jpeg")) {
//                for (Shape shape : this.shapes) {
//                    Line[] lines = shape.toLines();
//                    shape.draw(writer, lines);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else if (format.equals("png")) {
//            try (Writer writer = new PNGWriter(filename + ".png")) {
//                for (Shape shape : this.shapes) {
//                    Line[] lines = shape.toLines();
//                    shape.draw(writer, lines);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
}

