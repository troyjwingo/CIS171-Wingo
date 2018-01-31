/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Troy Local
 */
public class CH13_5GeometricObject {
  /** Main method */
  static GeometricObject geoObject1 = new Circle(5);
  static GeometricObject geoObject2 = new Circle(7);
    
  static GeometricObject geoObject3 = new Rectangle(5, 2);
  static GeometricObject geoObject4 = new Rectangle(7, 3);
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    

    System.out.println("The two objects have the same area? " + equalArea(geoObject1, geoObject2));
    System.out.println("The two objects have the same area? " + equalArea(geoObject3, geoObject4));

    // Display circles
    displayGeometricObject(geoObject1);
    displayGeometricObject(geoObject2);
    // Display rectangles
    displayGeometricObject(geoObject3);
    displayGeometricObject(geoObject4);
  }

  /** A method for comparing the areas of two geometric objects */
  public static boolean equalArea(GeometricObject object1,
      GeometricObject object2) {
    return GeometricObject.max( geoObject1, geoObject2);
  }

  /** A method for displaying a geometric object */
  public static void displayGeometricObject(GeometricObject object) {
    System.out.println();
    System.out.println("The area is " + object.getArea());
    System.out.println("The perimeter is " + object.getPerimeter());
  }
}
