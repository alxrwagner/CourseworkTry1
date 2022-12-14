package highLvl;

public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.fillDatabase();

        employeeBook.addEmployee("Наталья", "Гризли", "Акакиевна", 3, 250000f);
        employeeBook.removeEmployee(4);
        employeeBook.increaseSalaryAllEmployeesOfDepartment(7, 4);
        employeeBook.showAllEmployees();
        employeeBook.changeDepartment(2, 5);
        employeeBook.changeSalary(4, 155000);
        employeeBook.showSumAllSalaryOfDepartment(3);
    }

}