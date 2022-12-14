package baseLvl;

public class Employee {
    private String name;
    private String surname;
    private int department;
    private float salary;
    private int id;
    private static int counter;

    public Employee(String name, String surname, int department, float salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        id = ++counter;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
}

