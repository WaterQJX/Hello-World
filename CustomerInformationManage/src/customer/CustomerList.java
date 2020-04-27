package customer;

import java.util.concurrent.Callable;

/**
 * @Auther: qjx
 * @Date: 2020/4/27 10 23
 * @Description: CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 */
public class CustomerList {
    private Customer[] customers; //用来保存客户对象的数组
    private int total; //记录已保存客户对象的数量

    /**
      * @Description: 构造器，用来初始化customers数组
      */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
      * @Description: 将参数customer添加到数组中最后一个客户对象记录之后
      * 添加成功后返回true，false表示数组已满，无法添加。
      */
    public boolean addCustomer(Customer customer){
        if(customers.length > total-1){
            customers[total++] = customer;
            return true;
        }else{
            return false;

        }
    }

    /**
      * @Description: 用参数customer替换数组中由index指定的对象
      * 参数：customer指定替换的新客户对象
      * 	 index指定所替换对象在数组中的位置，从0开始
      * 返回：替换成功返回true；false表示索引无效，无法替换
      */
    public boolean replaceCustomer(int index, Customer customer){
        if(index < 0 || index > total - 1){
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
      * @Description: 从数组中删除参数index指定索引位置的客户对象记录
      * 参数： index指定所删除对象在数组中的索引位置，从0开始
      * 返回：删除成功返回true；false表示索引无效，无法删除
      */
    public boolean deleteCustomer(int index){
        if(index < 0 || index > total - 1){
            return false;
        }
        for(int i = index; i < total-1; i++){
            customers[i] = customers[i+1];
        }
        customers[total-1] = null;
        total--;
        return true;
    }

    /**
      * @Description: 返回数组中记录的所有客户对象
      * 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同.
      */
    public Customer[] getAllCustomers(){
        Customer[] customers1 = new Customer[total];
        for(int i = 0; i < total; i++){
            customers1[i] = customers[i];
        }
        return customers1;
    }

    /**
      * @Description: 返回参数index指定索引位置的客户对象记录
      * 参数： index指定所要获取的客户在数组中的索引位置，从0开始
      * 返回：封装了客户信息的Customer对象
      */
    public Customer getCustomer(int index){
        if(index < 0 || index > total-1){
            return null;
        }
        return customers[index];
    }

    /**
      * @Description: 返回对象的个数
      */
    public int getTotal(){
        return total;
    }

}
