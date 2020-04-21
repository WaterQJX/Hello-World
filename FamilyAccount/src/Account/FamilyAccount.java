package Account;

import java.util.Scanner;

/**
 * @Auther: qjx
 * @Date: 2020/4/21 10 15
 * @Description:
 */
public class FamilyAccount {
    public static void main(String[] args) {
        int balance = 10000; //生活起始基金
        String details = "收支\t账户金额\t收支金额\t说 明\n";
        boolean isFlag = true;
        while(isFlag){
            System.out.println("-----------------家庭收支记账软件----------------");
            System.out.println();
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退出\n");
            System.out.print("                   请选择(1-4): ");

            char selection = Utility.readMenuSelection(); //获取用户选择
            switch (selection){
                case '1':
                    System.out.println("-----------------当前收支明细----------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------");
                    break;
                case '2':
                    System.out.println("-------------------收入统计------------- ----");
                    System.out.print("请输入收入金额: ");
                    int amount1 = Utility.readNumber();
                    System.out.print("请输入收入说明: ");
                    String info1 = Utility.readString();
                    balance += amount1;
                    details += "收入" + "\t" + balance + "\t" + amount1 + "\t\t" + info1 + "\n";
                    System.out.println("-------------------登记完成------------------");
                    break;
                case '3':
                    System.out.println("-------------------支出统计------------------");
                    System.out.print("请输入支出金额: ");
                    int amount2 = Utility.readNumber();
                    System.out.print("请输入支出说明: ");
                    String info2 = Utility.readString();
                    balance -= amount2;
                    details += "支出" + "\t" + balance + "\t" + amount2 + "\t\t" + info2 + "\n";
                    System.out.println("-------------------登记完成------------------");
                    break;
                case '4':
                    //System.out.println("4 退出");
                    System.out.print("确认是否退出(Y/N): ");
                    char isExit = Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
                    break;
            }

            //isFlag = false;
        }
    }
}
