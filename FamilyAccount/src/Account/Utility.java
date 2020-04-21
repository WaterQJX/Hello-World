package Account;

import java.util.Scanner;

/**
 * @Auther: qjx
 * @Date: 2020/4/21 11 22
 * @Description: ������,���ڻ�ȡ��ȷ������
 */


public class Utility {
    private static Scanner input = new Scanner(System.in);

    //���ڽ���˵�ѡ�񣬶�ȡ�������룬�û�Ӧ����'1' ~ '4'֮�������ֵ�����ҷ��ظ�ֵ��
    public static char readMenuSelection(){
        char c;
        while(true){
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if(c > '4' || c < '1'){
                System.out.print("��Ч���룬����������: ");
            }else {
                break;
            }
        }

        return c;
    }

    //�Ӽ��̶��������֧�������ҽ��ܳ���4λ�������ء�
    public static int readNumber(){
        int money;
        while(true){
            String str = readKeyBoard(4);
            try{
                money = Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.print("����������������������: ");
            }
        }
        return money;
    }

    //���������֧����˵�����Ӽ��̽���һ��������8λ���ַ����������ء�
    public static String readString(){
        String str = readKeyBoard(8);
        return str;
    }

    //����ȷ��ѡ������룬�Ӽ��̶�ȡ'Y' �� 'N'�������ء�
    public static char readConfirmSelection(){
        char c;
        while(true) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            }else{
                System.out.print("������������������: ");
            }
        }
        return c;
    }



    //�Ӽ��̶��볤��Ϊ1~limit֮����ַ���
    private static String readKeyBoard(int limit){
        String line = "";
        while(input.hasNext()){
            line = input.nextLine();
            if(line.length() < 1 || line.length() > limit){
                System.out.print("���볤��(������" + limit + ")����,����������: ");
                continue;
            }
            break;
        }
        return line;
    }
}
