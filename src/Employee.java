public class Employee {
    private String name;
    private String surname;
    private String post;
    private float salary;

    public Employee(String name, String surname, String post, float salary) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPost() {
        return post;
    }

    public float getSalary() {
        return salary;
    }
}
