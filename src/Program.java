
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RAFAEL
 */
public class Program {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Employee> list = new ArrayList<>();
        
        System.out.print("Hot many employees will be registered? ");
        int n = sc.nextInt();
        
            for(int i = 0 ; i<n; i++){
            System.out.println();    
            System.out.print("Id: "+ (i+1) + "# ");
            int id = sc.nextInt();
                    while (hasId(list, id)) {
			System.out.print("Id already taken. Try again: ");
			id = sc.nextInt();
			}
        
        
        System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
        System.out.print("Salary: ");
            Double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary);
        
            list.add(emp);
        
            }
        
       
        System.out.println("employee who will get a raise? ");
            int idsalary = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
       
                if(emp == null){
                    System.out.println("Not found");
                }else{
                        System.out.print("Enter the percentage:");
                        double percent = sc.nextDouble();
                        emp.percentage(percent);
        
        
        }
                    System.out.println();
                    System.out.println("List Employees ");
                         for(Employee e : list ){
                                System.out.println(e);
            
                        }
                sc.close();
        
    }
    
    
    public static Integer position(List<Employee> list, int id){
                for(int  i = 0; i<list.size(); i++){
                    if(list.get(i).getId() == id){
                return i;
        }
       }
    return null;
}
    
    public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
    
    
}