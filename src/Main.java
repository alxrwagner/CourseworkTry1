public class Main {
    public static void main(String[] args) {
        EmployeeBookApp employeeBookApp = new EmployeeBookApp();

        employeeBookApp.fillDatabase();

        employeeBookApp.runApp();
    }
}