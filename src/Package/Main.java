package Package;

import Option5.Employee;
import Option5.Customer;

public class Main {
    
    public static void main(String[] args) {
        
        Menu menu = new Menu();
        
        Employee juan = new Employee("juan","Medellin",'M',22,315478451, "Gamer", 8000000);
        Employee ana = new Employee("ana","Bogota",'F',18,314235478, "Model", 700000);
        Employee sebastian = new Employee("sebatian","ocaña",'M',19,318795478, "Developer", 5000000);
        
        Customer rodolfo = new Customer("rodolfo","Medellin",'M',22,312478569, 50000, 3, "Exito");
        Customer pablo = new Customer("pablo","Cali",'M',17,316478957, 120000, 8, "Carrefour");
        Customer leo = new Customer("leo","pamplona",'M',50,319547845, 200000, 12, "Olimpica");
        
        System.out.println("Employees");
        System.out.println("-----------------------------------------");
        System.out.println(juan.getName() + " - " + juan.getAge());
        System.out.println(ana.getName() + " - " + ana.getAge());
        System.out.println(sebastian.getName() + " - " + sebastian.getAge());
        System.out.println("-----------------------------------------");
        
        System.out.println("Employees");
        System.out.println("-----------------------------------------");
        System.out.println(rodolfo.getName() + " - " + rodolfo.getAge());
        System.out.println(pablo.getName() + " - " + pablo.getAge());
        System.out.println(leo.getName() + " - " + leo.getAge());
        System.out.println("-----------------------------------------");
    }
    
}
