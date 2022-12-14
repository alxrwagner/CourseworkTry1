package averageLvl;

public class Employee {
    private String name;
    private String surname;
    private String middleName;
    private int department;
    private float salary;
    private int id;
    private static int counter;

    public Employee(String name, String surname, String middleName, int department, float salary) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
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

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

