
public class Dog{
    private Integer age;

    public Dog(Integer age) {
        this.setAge(age);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    
    @Override
    public String toString(){
        return "dog " + this.age;
    }

}