package Account;

import java.util.Scanner;

/**
 * @Auther: qjx
 * @Date: 2020/4/21 10 15
 * @Description:
 */
public class FamilyAccount {
    public static void main(String[] args) {
        int balance = 10000; //������ʼ����
        String details = "��֧\t�˻����\t��֧���\t˵ ��\n";
        boolean isFlag = true;
        while(isFlag){
            System.out.println("-----------------��ͥ��֧�������----------------");
            System.out.println();
            System.out.println("                   1 ��֧��ϸ");
            System.out.println("                   2 �Ǽ�����");
            System.out.println("                   3 �Ǽ�֧��");
            System.out.println("                   4 �˳�\n");
            System.out.print("                   ��ѡ��(1-4): ");

            char selection = Utility.readMenuSelection(); //��ȡ�û�ѡ��
            switch (selection){
                case '1':
                    System.out.println("-----------------��ǰ��֧��ϸ----------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------");
                    break;
                case '2':
                    System.out.println("-------------------����ͳ��------------- ----");
                    System.out.print("������������: ");
                    int amount1 = Utility.readNumber();
                    System.out.print("����������˵��: ");
                    String info1 = Utility.readString();
                    balance += amount1;
                    details += "����" + "\t" + balance + "\t" + amount1 + "\t\t" + info1 + "\n";
                    System.out.println("-------------------�Ǽ����------------------");
                    break;
                case '3':
                    System.out.println("-------------------֧��ͳ��------------------");
                    System.out.print("������֧�����: ");
                    int amount2 = Utility.readNumber();
                    System.out.print("������֧��˵��: ");
                    String info2 = Utility.readString();
                    balance -= amount2;
                    details += "֧��" + "\t" + balance + "\t" + amount2 + "\t\t" + info2 + "\n";
                    System.out.println("-------------------�Ǽ����------------------");
                    break;
                case '4':
                    //System.out.println("4 �˳�");
                    System.out.print("ȷ���Ƿ��˳�(Y/N): ");
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
