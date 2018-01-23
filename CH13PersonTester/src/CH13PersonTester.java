
public class CH13PersonTester {

    
    public static void main(String[] args) {
        Person myPerson = new Person("Bob", "Smelly");
        System.out.println(myPerson);
    }
    
}
class Person {
    String personName;
    String favColor;
    
    public Person(String pName,String fColor) {
        this.personName = pName;
        this.favColor = fColor;
    }
    
    public void setFavColor(String fColor) {
        this.favColor = fColor;
    }
    @Override
    public String toString() {
        return "Name = " + this.personName + "\nColor = " + this.favColor;
    }
    
    
}

