import java.util.Scanner;
import java.util.Vector;

abstract class Shape {
    public Shape next;

    public Shape() {
        next = null;
    }

    public abstract void draw();
}

class Line extends Shape {
    public void draw() { // overriding
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

public class EX1107_3 {
    public static void main(String[] args) {
        System.out.println("Operating Graphic Editor beauty");
        Scanner scanner = new Scanner(System.in);
        Vector<Shape> vector = new Vector<>();

        while (true) {
            System.out.print("Insert(1), Delete(2), View all(3), Exit(4)>>");
            int action = 0;
            int sh = 0;
            int rm = 0;
            try {
                action = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("똑바로 써라 핫산");
                continue;
            }

            try {
                if (action < 1 || action > 4) {
                    System.out.println("똑바로 써라 핫산");
                    continue;
                } else if (action == 4) {
                    System.out.println("beauty is shutting down.");
                    break;
                }
                else if (action == 1) {
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    sh = scanner.nextInt();

                    if (sh == 1) vector.add(new Line());
                    else if (sh == 2) vector.add(new Rect());
                    else if (sh == 3) vector.add(new Circle());
                    else {
                        System.out.println("똑바로 써라 핫산");
                        continue;

                    }
                } else if (action == 2) {
                    try {
                        System.out.print("Number of element>> ");
                        rm = scanner.nextInt();
                        vector.remove(rm);
                    } catch (Exception e) {
                        System.out.println("It cannot be deleted.");
                    }
                } else if (action == 3) {
                    for (int i = 0; i < vector.size(); i++)
                        vector.get(i).draw();
                }
            } catch (Exception e) {
                System.out.println("Muyaho");
            }


        }
    }
}
