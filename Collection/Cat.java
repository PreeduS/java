
public class Cat implements Comparable<Cat>{
    private Integer age;

    public Cat(Integer age) {
        this.setAge(age);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Cat o) {
        return this.age - o.age;

        /*if(this.age < o.age){
            return -1;
        }
        if(this.age > o.age){
            return 1;
        }
        return 0;*/
    }
    
    @Override
    public String toString(){
        return "cat " + this.age;
    }

}