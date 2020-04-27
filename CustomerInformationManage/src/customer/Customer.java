package customer;

/**
 * @Auther: qjx
 * @Date: 2020/4/27 10 10
 * @Description: Customer为实体类，用来封装客户信息
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public char getGender(){
        return gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public Customer(String name, char gender, int age, String phone, String email){
        this.name = name; //客户姓名
        this.gender = gender; //性别
        this.age = age; //年龄
        this.phone = phone; //电话号码
        this.email = email; //电子邮箱
    }

    public Customer(){

    }
}
