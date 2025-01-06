/** <b>The class of a two-dimensional vector.</b>
 * A class that implements mathematical tools for
 * working with two-dimensional vectors and displays the results on the screen
 *
 *
 * @author Vdovin Vladislav
 * @version 1.0
 * @since 2024-10-19
 */

public class Vector {

    private double x;
    private double y;

    /** Constructor of a class without parameters,
     * initializing them automatically
     */
    public Vector(){
        x = 0;
        y = 0;
    }

    /**
     * * Class constructor that accepts vector coordinates
     * @param Cx the first coordinate of the vector
     * @param Cy the second coordinate of the vector
     */
    public Vector(double Cx, double Cy){
        x = Cx;
        y = Cy;
    }

    /**
     * The constructor of the class that accepts coordinates
     * the beginning and end of the vector
     * @* @param x1 the first coordinate of the starting point
     * @param y1 is the second coordinate of the starting point
     * @param x2 the first coordinate of the endpoint
     * @param y2 the second coordinate of the endpoint
     */
    public Vector(double x1, double y1, double x2, double y2){
        x = x2 - x1;
        y = y2 - y1;
    }

    /**
     * Метод для получения первой координаты вектора
     * @return double тип возвращаемой координаты
     */
    public double getX(){
        return x;
    }

    /**
     * Method for obtaining the first coordinate of the vector
     */
    public void setX(double newX){
        x = newX;
    }

    /**
     * Метод для получения второй координаты вектора
     * @return double тип возвращаемой координаты
     */
    public double getY(){
        return y;
    }

    /**
     * Method for obtaining the second coordinate of the vector
     */
    public void setY(double newY){
        y = newY;
    }

    /**
     * A method for finding a vector product.
     * Counts the pseudoscalar product of vectors.
     * Displays the result on the screen.
     * @param vec is the second vector that is multiplied by this instance of the class
     */
    public void vecProduct(Vector vec){
        System.out.println("Результат векторного произведения: " + (x * vec.getY() - y * vec.getX()));
    }

    /**
     * A method for finding the scalar product.
     * Displays the result on the screen
     * @param vec is the second vector that is multiplied by this instance of the class
     */
    public void scalarProduct(Vector vec){
        System.out.println("Результат скалярного произведения: " + (x * vec.getX() + y * vec.getY()));
    }

    /**
     * * Method for calculating the length of a vector
     * Displays the result on the screen.
     */
    public void length(){
        System.out.println("Длина вектора равна: " + (Math.sqrt(x * x + y * y)));
    }

    /**
     * Multiplying a vector by a number
     * Returns the result vector of the operation
     * @param a number of type double
     * @return Vector
     */
    public Vector numberProduct(double a){
        return new Vector(x * a, y * a);
    }

    /**
     * A method for summing two vectors.
     * Returns the result vector of the operation
     * @param vec vector
     * @return Vector
     */
    public Vector sum(Vector vec){
        return new Vector(x + vec.getX(), y + vec.getY());
    }

    /**
     * A method for subtracting two vectors
     * Returns the result vector of the operation
     * @param vec is the second vector in the operation
     * @return Vector
     */
    public Vector difference(Vector vec){
        return new Vector(x - vec.getX(), y - vec.getY());
    }

    public static void main(String[] args){
        Vector vec1 = new Vector(5, 2);
        Vector vec2 = new Vector();

        System.out.println("Координаты первого вектора: " + vec1.getX() + " " +  vec1.getY());
        System.out.println("Координаты второго вектора: " + vec2.getX() + " " + vec2.getY());
        vec2.setX(2);
        vec2.setY(8);
        System.out.println("Координаты второго вектора: " + vec2.getX() + " " + vec2.getY());
        vec1.vecProduct(vec2);
        vec1.scalarProduct(vec2);
        vec1.length();
        Vector mult = vec2.numberProduct(2.0);
        System.out.println("Координаты вектора, являющегося результатом произведения второго вектора на 2: " + mult.getX() + " " + mult.getY());
        Vector sumVec = vec1.sum(vec2);
        System.out.println("Координаты суммы векторов: " + sumVec.getX() + " " + sumVec.getY());
        Vector diffVec = vec1.difference(vec2);
        System.out.println("Координаты разности векторов: " + diffVec.getX() + " " + diffVec.getY());
    }
}
