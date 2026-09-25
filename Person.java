abstract class Person { 
    // Abstract class: Person er direct object create kora jabe na


    // Encapsulation: data hiding using private variables
    private String name;
    private int age;
    private String phone;


    // Constructor: initialize object data
    public Person(String name, int age, String phone) {

        // this refers to current object
        this.name = name;
        this.age = age;
        this.phone = phone;
    }


    // Getter methods: controlled access to private data
    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getPhone() {
        return phone;
    }


    // Abstract method: child class must implement this method
    public abstract void displayInfo();

}