package Option5;

public class Person {
    protected String Name;
    protected String City;
    protected char Gender;
    protected int Age;
    protected int Cellphone;
    
    public Person()
    {
        
    }
    
    public Person(String name, String city, char gender, int age, int cellphone)
    {
        Name = name;
        City = city;
        Gender = gender;
        Age = age;
        Cellphone = cellphone;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the Gender
     */
    public char getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     * @return the Cellphone
     */
    public int getCellphone() {
        return Cellphone;
    }

    /**
     * @param Cellphone the Cellphone to set
     */
    public void setCellphone(int Cellphone) {
        this.Cellphone = Cellphone;
    }
}
