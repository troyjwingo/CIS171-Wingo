
public class CH13PersonTester {

    
    public static void main(String[] args) {
//        Person myPerson = new Person("Bob", "Smelly");
//        System.out.println(myPerson);
        
        Employee myEmployee = new Employee("A1234", "Sam", "Purple");
        System.out.println(myEmployee);
    }
    
}
class Employee extends Person {
    String empID;
    
    public Employee(String eID, String pName, String fColor){
        super(pName, fColor);
        this.empID = eID;
    }
    public String getID() {
        return this.empID;
    }
    @Override
    public String toString() {
        return super.toString() + " ID - " + getID();
    }
}      
abstract class Person {
    String personName;
    String favColor;
    
    public Person(String pName,String fColor) {
        this.personName = pName;
        this.favColor = fColor;
    }
    
    abstract public String getID();
    
    public void setFavColor(String fColor) {
        this.favColor = fColor;
    }
    @Override
    public String toString() {
        return "Name = " + this.personName + "\nColor = " + this.favColor;
    }
    
    
}

