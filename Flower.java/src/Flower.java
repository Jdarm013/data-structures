import java.awt.*;
import edu.princeton.cs.introcs.StdDraw;

public class Flower {

    /**
     * Recursive Flower Logic
     * Contains the math for sizing and the "printing" (drawing) to the canvas.
     */

    public void flower(Color[] palette, double x, double y, double n, int count) {
        if (n > count) return;

        // Spiral Math
        double angle = n * 137.5;
        double r = 0.006 * Math.sqrt(n);
        double posX = r * Math.cos(Math.toRadians(angle)) + x;
        double posY = r * Math.sin(Math.toRadians(angle)) + y;

        // Aesthetics
        int alpha = (int) (150 + 100 * Math.sin(n * 0.1));
        double dotSize = 0.002 + (0.005 * (n / count));

        Color c = palette[(int)(n % palette.length)];
        StdDraw.setPenColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha));
        StdDraw.filledCircle(posX, posY, dotSize);

        // Halo Detail
        StdDraw.setPenColor(new Color(255, 255, 255, alpha / 2));
        StdDraw.filledCircle(posX + 0.003, posY + 0.003, dotSize / 2);

        // Recursive Call (5 parameters now matches the call in testDriver)
        flower(palette, x, y, n + 1, count);
    }

    // Square Fractal Blackhole
    public void sprialSquares(double x, double y, double size, double angle, int count) {
        if (count == 60) return; //

        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setPenRadius(0.001);

        // Use trigonometry to draw a rotated square
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad) * size;
        double sin = Math.sin(rad) * size;


        StdDraw.line(x + cos, y + sin, x - sin, y + cos);
        StdDraw.line(x - sin, y + cos, x - cos, y - sin);
        StdDraw.line(x - cos, y - sin, x + sin, y - cos);
        StdDraw.line(x + sin, y - cos, x + cos, y + sin);

        // Recurse: Shrink slightly and rotate 10 degrees
        sprialSquares(x, y, size * 0.95, angle + 10, count + 1);
    }

    //  Zelda Triangle pattern (Sierpinski Gasket)
    public void sierpinski(double x, double y, double size, int count) {
        if (count == 0) return;
        double h = size * Math.sqrt(3) / 2; // Height of equilateral triangle
        double[] px = {x, x - size / 2, x + size / 2};
        double[] py = {y + h / 2, y - h / 2, y - h / 2};

        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.polygon(px, py);

        sierpinski(x, y + h / 4, size / 2, count - 1);       // Top
        sierpinski(x - size / 4, y - h / 4, size / 2, count - 1); // Left
        sierpinski(x + size / 4, y - h / 4, size / 2, count - 1); // Right
    }

    // Koch Curve- SnowFlake
    public void kochCurve(double x1, double y1, double x5, double y5, int count) {
        if (count == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }

        double dx = x5 - x1;
        double dy = y5 - y1;

        double x2 = x1 + dx / 3;
        double y2 = y1 + dy / 3;

        double x3 = 0.5 * (x1 + x5) + (Math.sqrt(3) / 6) * (y1 - y5);
        double y3 = 0.5 * (y1 + y5) + (Math.sqrt(3) / 6) * (x5 - x1);

        double x4 = x1 + 2 * dx / 3;
        double y4 = y1 + 2 * dy / 3;

        kochCurve(x1, y1, x2, y2, count - 1);
        kochCurve(x2, y2, x3, y3, count - 1);
        kochCurve(x3, y3, x4, y4, count - 1);
        kochCurve(x4, y4, x5, y5, count - 1);
    }


    // City Circuit Board (Recursive Circuitry)
    public void hTree(double x, double y, double size, int count) {
        if (count == 0) return;
        StdDraw.setPenColor(StdDraw.WHITE);

        double x0 = x - size / 2, x1 = x + size / 2;
        double y0 = y - size / 2, y1 = y + size / 2;

        StdDraw.line(x0, y, x1, y);   // Horizontal
        StdDraw.line(x0, y0, x0, y1); // Left Vertical
        StdDraw.line(x1, y0, x1, y1); // Right Vertical

        hTree(x0, y0, size / 2, count - 1);
        hTree(x0, y1, size / 2, count - 1);
        hTree(x1, y0, size / 2, count - 1);
        hTree(x1, y1, size / 2, count - 1);
    }

    public void testDriver() {
        System.out.println("Executing Balanced Art Simulation...");
        StdDraw.setCanvasSize(900, 900);
        StdDraw.clear(StdDraw.BLACK);

        Color[] p = {
                new Color(0, 255, 255),   // Cyan
                new Color(255, 0, 255),   // Magenta
                new Color(137, 207, 240), // Baby Blue
                StdDraw.WHITE
        };

        // 1. CENTER: Quantum Singularity (Phyllotaxis Spiral)
        flower(p, 0.5, 0.5, 1, 1200);

        // 2. TOP LEFT: Celtic Vortex (sprialSquares)
        sprialSquares(0.22, 0.78, 0.12, 0, 0);

        // 3. TOP RIGHT: Fractal Triangles (sierpinski)
        sierpinski(0.78, 0.78, 0.22, 5);

        // 4. BOTTOM LEFT: The Overlapping Koch Star
        StdDraw.setPenColor(new Color(137, 207, 240));
        double kSize = 0.28;
        double kh = kSize * Math.sqrt(3) / 2;
        // Upright
        kochCurve(0.08, 0.12, 0.08 + kSize, 0.12, 4);
        kochCurve(0.08 + kSize, 0.12, 0.08 + kSize / 2, 0.12 + kh, 4);
        kochCurve(0.08 + kSize / 2, 0.12 + kh, 0.08, 0.12, 4);
        // Upside Down
        kochCurve(0.08, 0.32, 0.08 + kSize, 0.32, 4);
        kochCurve(0.08 + kSize, 0.32, 0.08 + kSize / 2, 0.32 - kh, 4);
        kochCurve(0.08 + kSize / 2, 0.32 - kh, 0.08, 0.32, 4);

        // 5. BOTTOM RIGHT: Circuitry (hTree)
        hTree(0.82, 0.18, 0.15, 4);

        System.out.println("Simulation Render Complete.");
    }




    public static void main(String[] args) {
        Flower fd = new Flower();
        fd.testDriver();
    }
}