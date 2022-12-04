import java.util.ArrayList;
import java.util.List;

public class DataBaseOfEmployees {
    private List<Employee> employees;

    public DataBaseOfEmployees() {
        this.employees = new ArrayList<>();
    }

    public void showAllEmployees(){
        if(!employees.isEmpty()){
            for(Employee employee : employees){
                System.out.println("Имя: " + employee.getName() + employee.getSurname() + " должность: " + employee.getPost());
            }
        }
        else {
            System.out.println("База данных пуста");
        }
    }

    private List<Employee> getEmployeesWithMinSalary(){
        if(!employees.isEmpty()){
            List<Employee> employeesWithMinSalary = new ArrayList<>();
            float minValue = employees.get(0).getSalary();

            for(int counter = 0; counter < employees.size(); counter++){
                if(employees.get(counter).getSalary() < minValue){
                    minValue = employees.get(counter).getSalary();
                }
            }

            for(Employee employee : employees){
                if(employee.equals(employee.getSalary() == minValue)){
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
            float maxValue = employees.get(0).getSalary();

            for(int counter = 0; counter < employees.size(); counter++){
                if(employees.get(counter).getSalary() > maxValue){
                    maxValue = employees.get(counter).getSalary();
                }
            }

            for(Employee employee : employees){
                if(employee.equals(employee.getSalary() == maxValue)){
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

    public void showEmployeesWithMinSalary(){
        List<Employee> employeesWithMinSalary = new ArrayList<>();

        employeesWithMinSalary = getEmployeesWithMinSalary();

        if (!employeesWithMinSalary.isEmpty()){
            for(Employee employee : employeesWithMinSalary){
                System.out.println("Имя: " + employee.getName() + employee.getSurname() +
                        "Должность: " + employee.getPost() + "Зарплата: " + employee.getSalary());
            }
        }
    }
    public void showEmployeesWithMaxSalary(){
        List<Employee> employeesWithMaxSalary = new ArrayList<>();

        employeesWithMaxSalary = getEmployeesWithMaxSalary();

        if (!employeesWithMaxSalary.isEmpty()){
            for(Employee employee : employeesWithMaxSalary){
                System.out.println("Имя: " + employee.getName() + employee.getSurname() +
                        "Должность: " + employee.getPost() + "Зарплата: " + employee.getSalary());
            }
        }
    }

    public void showSumAllSalary(){
        float sumAllSalary = getSumAllSalary();
        System.out.println("Общая сумма заработных плат в месяц составляет: " + sumAllSalary);
    }

    public void showAvarageAmountAllSalary(){
        float sumAllSalary = getSumAllSalary();
        float avarageAmountAllSalary = sumAllSalary / employees.size();

        System.out.println("Средняя сумма всех заработных плат в месяц составляет: " + avarageAmountAllSalary);
    }
}
