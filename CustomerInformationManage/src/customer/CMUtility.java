package customer;

import java.util.Scanner;

/**
 * @Auther: qjx
 * @Date: 2020/4/26 15 42
 * @Description: 工具类 将不同的功能封装为方法，就是可以直接通过调用的方法使用它的功能，而无需考虑具体的功能实现细节。
 */
public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
      * @Description: 该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回。返回值为用户键入字符。
      */
    public static char readMenuSelection(){
        char c;
        while(true){
            String str = scanner.next();
            c = str.charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4' && c != '5'){
                System.out.print("输入错误，请重新输入: ");
            }else{
                break;
            }
        }
        return c;
    }

    /**
      * @Description: 从键盘读取一个字符，并将其作为方法的返回值。
      */
    public static char readChar(){
        String  str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
      * @Description: 从键盘读取一个字符，并将其作为方法的返回值。
      * defaultValue — 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
      * （提示：此方法可在修改客户时调用）
      */
    public static char readChar(char defaultValue){
        String str = readKeyBoard(1, true);
        return (str.length() == 0 ? defaultValue : str.charAt(0));
    }

    /**
      * @Description: 从键盘读取一个长度不超过2位的   整数，并将其作为方法的返回值。
      */
    public static int readInt(){
        int num;
        while(true){
            String str = readKeyBoard(2, false);
            try{
                num = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.print("数字输入有误，请重新输入: ");
            }
        }
        return num;
    }

    /**
      * @Description: 从键盘读取一个长度不超过2位的   整数，并将其作为方法的返回值。
      * defaultValue — 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
      */
    public static int readInt(int defaultValue){
       int num;
       while(true){
           String str = readKeyBoard(2, true);
           if(str.equals("")){
               return defaultValue;
           }

           try{
               num = Integer.parseInt(str);
               break;
           }catch (NumberFormatException e){
               System.out.print("数字输入错误，请重新输入: ");
           }
       }

       return num;
    }

    /**
      * @Description: 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
      */
    public static String readString(int limit){
        String str = readKeyBoard(limit, false);
        return str;
    }

    /**
      * @Description: 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
      * limit — 指定字符串的最大长度
      * defaultValue — 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
      */
    public static String readString(int limit, String defaultValue){
        String str = readKeyBoard(limit, true);
        return (str.length() == 0 ? defaultValue : str);
    }

    /**
      * @Description: 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
      */
    public static char readConfirmSelection(){
        char c;
        while(true){
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if(c != 'Y' && c != 'N'){
                System.out.print("输入有误，请重新输入: ");
            }else{
                break;
            }
        }
        return c;
    }

    /**
      * @Description: 获取键盘收入,并返回
      */
    private static String readKeyBoard(int limit, boolean blankRturn){
        String line = "";
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length() == 0){
                if(blankRturn){
                    return line;
                }else{
                    continue;
                }
            }
            if(line.length() < 1 || line.length() > limit){
                System.out.print("输入长度(不大于" + limit + ") 错误，请重新输入: ");
                continue;
            }
            break;
        }
        return line;
    }
}
