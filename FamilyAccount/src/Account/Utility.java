package Account;

import java.util.Scanner;

/**
 * @Auther: qjx
 * @Date: 2020/4/21 11 22
 * @Description: 工具类,用于获取正确的输入
 */


public class Utility {
    private static Scanner input = new Scanner(System.in);

    //用于界面菜单选择，读取键盘输入，用户应输入'1' ~ '4'之间的任意值，并且返回该值。
    public static char readMenuSelection(){
        char c;
        while(true){
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if(c > '4' || c < '1'){
                System.out.print("无效输入，请重新输入: ");
            }else {
                break;
            }
        }

        return c;
    }

    //从键盘读入收入和支出金额，并且金额不能超过4位，并返回。
    public static int readNumber(){
        int money;
        while(true){
            String str = readKeyBoard(4);
            try{
                money = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.print("数字输入有误，请重新输入: ");
            }
        }
        return money;
    }

    //用于收入和支出的说明，从键盘接收一个不超过8位的字符串，并返回。
    public static String readString(){
        String str = readKeyBoard(8);
        return str;
    }

    //用于确认选择的输入，从键盘读取'Y' 或 'N'，并返回。
    public static char readConfirmSelection(){
        char c;
        while(true) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            }else{
                System.out.print("输入有误，请重新输入: ");
            }
        }
        return c;
    }



    //从键盘读入长度为1~limit之间的字符。
    private static String readKeyBoard(int limit){
        String line = "";
        while(input.hasNext()){
            line = input.nextLine();
            if(line.length() < 1 || line.length() > limit){
                System.out.print("输入长度(不大于" + limit + ")错误,请重新输入: ");
                continue;
            }
            break;
        }
        return line;
    }
}
