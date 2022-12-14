package highLvl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeBook {
    List<Employee> employees;

    public EmployeeBook() {
        this.employees = new ArrayList<>();
    }

    private List<Employee> getEmployeesOfDepartment(int department) {
        List<Employee> employeesOfDepartment = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employeesOfDepartment.add(employee);
            }
        }
        return employeesOfDepartment;
    }

    private List<Employee> getEmployeesWithMinSalaryOfDepartment(int department) {
        if (!employees.isEmpty()) {
            List<Employee> employeesOfDepartment = getEmployeesOfDepartment(department);
            List<Employee> employeesWithMinSalary = new ArrayList<>();

            float minValue = employeesOfDepartment.stream()
                    .min(Comparator.comparing(Employee::getSalary))
                    .get().getSalary();

            for (Employee employee : employeesOfDepartment) {
                if (employee.getSalary() == minValue) {
                    employeesWithMinSalary.add(employee);
                }
            }
            return employeesWithMinSalary;
        } else {
            System.out.println("База данных пуста");
            return null;
        }
    }


    private List<Employee> getEmployeesWithMaxSalaryOfDepartment(int department) {
        if (!employees.isEmpty()) {
            List<Employee> employeesOfDepartment = getEmployeesOfDepartment(department);
            List<Employee> employeesWithMaxSalary = new ArrayList<>();

            float maxValue = employeesOfDepartment.stream()
                    .max(Comparator.comparing(Employee::getSalary)).get().getSalary();

            for (Employee employee : employeesOfDepartment) {
                if (employee.getSalary() == maxValue) {
                    employeesWithMaxSalary.add(employee);
                }
            }
            return employeesWithMaxSalary;
        } else {
            System.out.println("База данных пуста");
            return null;
        }
    }

    private float getSumAllSalaryOfDepartment(int department) {
        float sumAllSalary = 0f;

        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    sumAllSalary += employee.getSalary();
                }
            }
        } else {
            System.out.println("База данных пуста");
        }
        return sumAllSalary;
    }

    private float getAverageSalaryOfDepartment(int department) {
        float averageAmount = 0f;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                averageAmount += employee.getSalary();
            }
        }
        return averageAmount;
    }

    private Employee searchEmployeeById(int id) {
        Employee foundEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                foundEmployee = employee;
                break;
            }
        }
        if (foundEmployee == null) {
            System.out.printf("Сотрудник с ID %d не был найден. Проверьте ID и попробуйте снова.%n", id);
        }
        return foundEmployee;
    }

    public void showSumAllSalaryOfDepartment(int department) {
        System.out.printf("Общая сумма заработных плат в месяц составляет: %.2f рублей%n", getSumAllSalaryOfDepartment(department));
    }

    public void showAllEmployeesOfDepartment(int department) {
        if (!employees.isEmpty()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    System.out.printf("ID: %d Имя: %s %s %s%n", employee.getId(), employee.getName(), employee.getSurname(), employee.getMiddleName());
                }
            }
        } else {
            System.out.println("База данных пуста");
        }
    }

    public void showEmployeesWithMinSalaryOfDepartment(int department) {
        List<Employee> employeesWithMinSalary;

        employeesWithMinSalary = getEmployeesWithMinSalaryOfDepartment(department);

        if (!employeesWithMinSalary.isEmpty()) {
            System.out.println("Сотрудники с минимальной заработной платой: ");
            for (Employee employee : employeesWithMinSalary) {
                System.out.printf("ID: %d Имя: %s %s %s | Отдел: %d | Зарплата: %.2f рублей%n", employee.getId(), employee.getName(), employee.getSurname(),
                        employee.getMiddleName(), employee.getDepartment(), employee.getSalary());

            }
        }
    }

    public void showEmployeesWithMaxSalaryOfDepartment(int department) {
        List<Employee> employeesWithMaxSalary;

        employeesWithMaxSalary = getEmployeesWithMaxSalaryOfDepartment(department);

        if (!employeesWithMaxSalary.isEmpty()) {
            System.out.println("Сотрудники с максимальной заработной платой: ");
            for (Employee employee : employeesWithMaxSalary) {
                System.out.printf("ID: %d Имя: %s %s %s | Отдел: %d | Зарплата: %.2f рублей%n", employee.getId(), employee.getName(), employee.getSurname(), employee.getMiddleName(),
                        employee.getDepartment(), employee.getSalary());

            }
        }
    }

    public void showAverageAmountSalaryOfDepartment(int department) {
        System.out.printf("Средняя зарплата по отделу %d: %.2f%n", department, getAverageSalaryOfDepartment(department));
    }

    public void fillDatabase() {
        addEmployee("Анатолий", "Мамонов", "Васильевич", 1, 60000);
        addEmployee("Галина", "Шварц", "Александровна", 2, 150000);
        addEmployee("Сергей", "Никифоров", "Николаевич", 3, 100000);
        addEmployee("Евгения", "Кулеш", "Валерьевна", 4, 90000);
        addEmployee("Александр", "Минин", "Александрович", 5, 60000);
        addEmployee("Евгений", "Богданов", "Игнатьевич", 1, 70000);
        addEmployee("Николай", "Савченко", "Юрьевич", 2, 150000);
        addEmployee("Лидия", "Александрова", "Степановна", 3, 200000);
        addEmployee("Наталья", "Кравцова", "Николаевна", 4, 90000);
        addEmployee("Петр", "Иванов", "Васильевич", 5, 70000);
    }

    public void showEmployeesWithSalaryLessAmount(float amountThreshold) {

        for (Employee employee : employees) {
            if (employee.getSalary() < amountThreshold) {
                System.out.printf("ID: %d Имя: %s Фамилия: %s Отчество: %s Зарплата: %f%n", employee.getId(), employee.getName(),
                        employee.getSurname(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    public void showEmployeesWithSalaryMoreEqualAmount(float amountThreshold) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= amountThreshold) {
                System.out.printf("ID: %d Имя: %s Фамилия: %s Отчество: %s Зарплата: %f%n", employee.getId(), employee.getName(),
                        employee.getSurname(), employee.getMiddleName(), employee.getSalary());
            }
        }
    }

    public void increaseSalaryAllEmployeesOfDepartment(int percentageIncrease, int department) {
        float increaseAmount;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                increaseAmount = employee.getSalary();
                increaseAmount += employee.getSalary() / 100 * percentageIncrease;
                employee.setSalary(increaseAmount);
            }
        }

    }

    public void addEmployee(String name, String surname, String middlname, int department, float salary) {
        employees.add(new Employee(name, surname, middlname, department, salary));
    }

    public void removeEmployee(int id) {
        Employee employee = searchEmployeeById(id);

        if (employee != null){
            employees.remove(employee);
            System.out.printf("Сотрудник с ID %d был удален.%n", id);
        }
    }

    public void changeSalary(int id, float newSalary) {
        Employee employee = searchEmployeeById(id);
        employee.setSalary(newSalary);
    }

    public void changeDepartment(int id, int newDepartment){
        Employee employee = searchEmployeeById(id);
        employee.setDepartment(newDepartment);
    }
}
