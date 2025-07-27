//blueprint of Figure
abstract class Figure {
  int dim1;

  //default constructor
  Figure() {
    dim1 = 0;
  }
  //Parameterized constructor 
  Figure(int dim1) {
    this.dim1 = dim1;
  }
  //concrete method
  void display() {
    System.out.println("Dimension 1: "+dim1);
  }

  //Abstract methods
  abstract void area();
  abstract void perimeter();
}


//circle class
class Circle extends Figure{
  Circle() {
    super();
  }
  Circle(int dim1) {
    super(dim1); //radius
  }
  void display() {
    System.out.println("----circle----");
    System.out.println("Radius: "+dim1);
  }
  void area() {
    double ar = 3.14 * dim1 * dim1;
    System.out.println("Area of circle = "+ar);
  }
  void perimeter() {
    double pm = 2 * 3.14 * dim1;
    System.out.println("Perimeter = "+pm);
  }
}

//Recatangle class
class Rectangle extends Figure {
  int dim2;
  Rectangle() {
    super();
    dim2 = 0;
  }
  Rectangle(int dim1, int dim2) {
    super(dim1);//length of rectangle
    this.dim2 = dim2;//breathe of rectangle
  }
  void display() {
    System.out.println("--------Rectangle---------");
    System.out.println("Length: "+dim1);
    System.out.println("Breadth: "+dim2);
  }
  void area() {
    int ar = dim1 * dim2;
    System.out.println("Area = "+ar);
  }
  void perimeter() {
    int pm = 2 * (dim1 + dim2);//calculation of perimeter
    System.out.println("Perimeter = "+pm);
  }
}
//Triangle class 
class Triangle extends Figure {
  int dim2, dim3;
  Triangle() {
    super();
    dim2 = dim3 = 0;
  }
  Triangle(int dim1, int dim2, int dim3) {
    super(dim1);//side1
    this.dim2 = dim2;//side2
    this.dim3 = dim3;//side3
  }
  void display() {
    System.out.println("--------Triangle-------");
    System.out.println("Side 1: "+dim1);
    System.out.println("side 2: "+dim2);
    System.out.println("side 3: "+dim3);
  }
  
  void area() {
    double sp = (dim1 + dim2 + dim3) / 2.0;
    double ar = Math.sqrt(sp * (sp-dim1) * (sp - dim2) * (sp-dim3));
    System.out.println("Area = "+ar);
  }
  void perimeter() {
    int pm = dim1 + dim2 + dim3;
    System.out.println("perimeter = "+pm);
  }
}

class Cylinder extends Figure {
  int dim2;
  Cylinder() {
    super();
    dim2 = 0;
  }
  Cylinder(int dim1, int dim2) {
    super(dim1); //radius of cylinder
    this.dim2 = dim2;//height of  cylinder
  }

  void display() {
    System.out.println("-------Cylinder-------");
    System.out.println("Radius: "+dim1);
    System.out.println("Height: "+dim2);
  }
  void area() {
    double ar = 2 * 3.14 * dim1 * (dim1 + dim2);//calculating total surface area
    System.out.println("Surface Area = "+ar);
  }
  void perimeter() {
    System.out.println("Perimeter: No perimeter of a 3D shape");
  }
}


public class Assigenment9{
  public static void main(String[] args) {
    //Create circle
    Circle cir = new Circle(7);
    cir.display();
    cir.area();
    cir.perimeter();
    System.out.println();

    //create recatangle
    Rectangle rec = new Rectangle(4,8);
    rec.display();
    rec.area();
    rec.perimeter();
    System.out.println();


    Triangle tri = new Triangle(4,2, 5);
    tri.display();
    tri.area();
    tri.perimeter();
    System.out.println();

    Cylinder cyl = new Cylinder(10, 18);
    cyl.display();
    cyl.area();
    cyl.perimeter();
  }
  
}
