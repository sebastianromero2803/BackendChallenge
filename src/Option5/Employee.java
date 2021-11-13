package Option5;

public class Employee extends Person{

    /**
     * @return the Job
     */
    public String getJob() {
        return Job;
    }

    /**
     * @param Job the Job to set
     */
    public void setJob(String Job) {
        this.Job = Job;
    }

    /**
     * @return the Salary
     */
    public int getSalary() {
        return Salary;
    }

    /**
     * @param Salary the Salary to set
     */
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    private String Job;
    private int Salary;
    
    public Employee()
    {
        
    }
    
    public Employee(String name, String city, char gender, int age, int cellphone,String job, int salary)
    {
        super(name, city, gender, age, cellphone);
        this.Job = job;
        this.Salary = salary;
    }
}
