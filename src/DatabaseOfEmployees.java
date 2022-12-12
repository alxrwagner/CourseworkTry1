import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseOfEmployees {
    private List<Employee> employees;

    public DatabaseOfEmployees() {
        this.employees = new ArrayList<>();
    }

    private List<Employee> getEmployeesWithMinSalary(){
        if(!employees.isEmpty()){
            List<Employee> employeesWithMinSalary = new ArrayList<>();
            float minValue = employees.stream()
                    .min(Comparator.comparing(Employee::getSalary))
                    .get().getSalary();

            for(Employee employee : employees){
                if(employee.getSalary() == minValue){
                    employeesWithMinSalary.add(employee);
                }
            }
            return employeesWithMinSalary;
        }
        else {
            System.out.println("База данных пуста");
            return null;
        }
    }

    private List<Employee> getEmployeesWithMaxSalary(){
        if(!employees.isEmpty()){
            List<Employee> employeesWithMaxSalary = new ArrayList<>();
            float maxValue = employees.stream()
                    .max(Comparator.comparing(Employee::getSalary)).get().getSalary();

            for(Employee employee : employees){
                if(employee.getSalary() == maxValue){
                    employeesWithMaxSalary.add(employee);
                }
            }
            return employeesWithMaxSalary;
        }
        else{
            System.out.println("База данных пуста");
            return null;
        }
    }

    private float getSumAllSalary(){
        float sumAllSalary = 0f;

        if (!employees.isEmpty()){
            for (Employee employee : employees){
                sumAllSalary += employee.getSalary();
            }
        }
        else {
            System.out.println("База данных пуста");
        }
        return sumAllSalary;
    }

    public void showAllEmployees(){
        if(!employees.isEmpty()){
            for(Employee employee : employees){
                System.out.printf("Имя: %s %s | Должность: %s%n", employee.getName(), employee.getSurname(), employee.getPost());
            }
        }
        else {
            System.out.println("База данных пуста");
        }
    }

    public void showEmployeesWithMinSalary(){
        List<Employee> employeesWithMinSalary = new ArrayList<>();

        employeesWithMinSalary = getEmployeesWithMinSalary();

        if (!employeesWithMinSalary.isEmpty()){
            for(Employee employee : employeesWithMinSalary){
                System.out.printf("Имя: %s %s | Должность: %s | Зарплата: %.2f рублей%n", employee.getName(), employee.getSurname(),
                        employee.getPost(), employee.getSalary());
            }
        }
    }
    public void showEmployeesWithMaxSalary(){
        List<Employee> employeesWithMaxSalary = new ArrayList<>();

        employeesWithMaxSalary = getEmployeesWithMaxSalary();

        if (!employeesWithMaxSalary.isEmpty()){
            for(Employee employee : employeesWithMaxSalary){
                System.out.printf("Имя: %s %s | Должность: %s | Зарплата: %.2f рублей%n", employee.getName(), employee.getSurname(),
                        employee.getPost(), employee.getSalary());
            }
        }
    }

    public void showSumAllSalary(){
        float sumAllSalary = getSumAllSalary();
        System.out.printf("Общая сумма заработных плат в месяц составляет: %.2f рублей%n", sumAllSalary);
    }

    public void showAverageAmountAllSalary(){
        float sumAllSalary = getSumAllSalary();
        float averageAmountAllSalary = sumAllSalary / employees.size();

        System.out.printf("Средняя сумма всех заработных плат в месяц составляет: %.2f рублей%n", averageAmountAllSalary);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
