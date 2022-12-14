package highLvl;

public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.fillDatabase();

        employeeBook.addEmployee("Наталья", "Гаврилова", "Юрьевна", 5, 200000);
        employeeBook.showAllEmployeesOfDepartment(5);
        employeeBook.removeEmployee(10);
        employeeBook.removeEmployee(300);
        employeeBook.showAllEmployeesOfDepartment(5);
    }

}