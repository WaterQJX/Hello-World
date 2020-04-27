package customer;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;

/**
 * @Auther: qjx
 * @Date: 2020/4/27 16 36
 * @Description: 负责菜单的显示和处理用户操作
 */
public class CustomerView {
     private CustomerList customerList = new CustomerList(10);

    /**
      * @Description: 显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
      */
    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char c = CMUtility.readMenuSelection();
            switch (c){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y|N): ");
                    if(CMUtility.readConfirmSelection() == 'Y'){
                        isFlag = false;
                    }
                    break;
            }
        }

    }

    /**
      * @Description: 添加客户操作
      */
    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名: ");
        String name = CMUtility.readString(10);
        System.out.print("性别: ");
        char gender = CMUtility.readChar();
        System.out.print("年龄: ");
        int age = CMUtility.readInt();
        System.out.print("电话: ");
        String phone = CMUtility.readString(20);
        System.out.print("邮箱: ");
        String email = CMUtility.readString(30);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean flag = customerList.addCustomer(customer);
        if(flag){
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("人数已达上限，添加失败！");
        }
    }

    /**
      * @Description: 修改客户操作
      */
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        while(true){
            System.out.print("请选择待修改客户编号(-1退出): ");
            int num = CMUtility.readInt();
            if(num-1 >= 0 && num-1 < customerList.getTotal()){
                Customer customer = customerList.getCustomer(num-1);
                System.out.print("姓名("+ customer.getName() +"): ");
                String name = CMUtility.readString(10, customer.getName());
                System.out.print("性别("+ customer.getGender() +"): ");
                char gender = CMUtility.readChar(customer.getGender());
                System.out.print("年龄("+ customer.getAge() +"): ");
                int age = CMUtility.readInt(customer.getAge());
                System.out.print("电话("+ customer.getPhone() +"): ");
                String phone = CMUtility.readString(20, customer.getPhone());
                System.out.print("邮箱("+ customer.getEmail() +"): ");
                String email = CMUtility.readString(30, customer.getEmail());

                Customer newCustomer = new Customer(name, gender, age, phone, email);
                boolean isReplaced = customerList.replaceCustomer(num-1, newCustomer);
                if(isReplaced){
                    System.out.println("---------------------修改成功---------------------");
                }else{
                    System.out.println("---------------------修改失败---------------------");
                }
                return;
            }else if( num == -1){
                return;
            }else{
                System.out.println("无法找到指定客户！");
            }
        }
    }

    /**
      * @Description: 删除客户操作
      */
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        while(true){
            System.out.print("请选择待删除客户编号(-1退出): ");
            int num = CMUtility.readInt();
            if(num - 1 >= 0 && num - 1 < customerList.getTotal()){
                System.out.print("确认是否删除(Y|N): ");
                char isDelete = CMUtility.readConfirmSelection();
                if(isDelete == 'Y'){
                    boolean delete = customerList.deleteCustomer(num-1);
                    if(delete){
                        System.out.println("---------------------删除成功---------------------");
                    }else{
                        System.out.println("---------------------删除失败---------------------");
                    }
                }
            }else if(num == -1){
                return;
            }else{
                System.out.println("无法找到指定客户！");
            }
        }
    }

    /**
      * @Description: 显示所有客户信息列表
      */
    private void listAllCustomer(){
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
        if(customerList.getTotal() == 0){
            System.out.println("没有客户记录！");
        }else{
            Customer[] c = customerList.getAllCustomers();
            for(int i = 0; i < c.length; i++){
                System.out.println((i + 1) + "\t\t" + c[i].getName() + "\t"+ c[i].getGender() +
                        "\t\t" + c[i].getAge() +"\t\t" + c[i].getPhone()  + "\t" + c[i].getEmail());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
