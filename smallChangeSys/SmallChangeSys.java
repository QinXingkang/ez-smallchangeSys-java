package ProjectExercise.smallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * @date
 * @content
 */
public class SmallChangeSys {
    //1.先完成显示菜单，并可以选择菜单，给出相应提示
    //2.完成零钱通明细
    //3.收益入账
    //4.消费
    //5.退出

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String key = "";
        //2.零钱通明细
        //（1）数组
        //（2）对象
        //（3）String拼接

        //(3)
        String details = "==============零钱通明细==============";


        //3.完成收益入账
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化

        //4.消费
        //定义新变量，保存消费的原因
        String note = "";
        do{
            System.out.println("\n==============零钱通菜单==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.println("请选择(1-4)：");
            key = scanner.next();

            //使用switch分支控制
            switch(key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验一下
                    if(money > 0){
                        balance += money;
                    }else{
                        System.out.println("金额输入有误");
                    }


                    //拼接收益入账信息到details
                    date = new Date();//获取当前日期
                    details += "\n收益入账" + "\t+" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验一下
                    if(money > 0 && money <= balance){
                        balance -= money;
                    }else if(money > 0 && money > balance){
                        System.out.println("余额不足，余额剩余" + balance);
                        break;
                    }else{
                        System.out.println("金额输入有误");
                    }
                    System.out.println("请输入消费说明");
                    note = scanner.next();

                    //拼接消费信息到details
                    date = new Date();//获取当前时间
                    details += "\n" + note + "\t-" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
                    break;
                case "4":
                    String choice = "";
                    while(true){
                        System.out.println("确定要退出码？ y/n");
                        choice = scanner.next();
                        if("y".equals(choice) || "n".equals(choice)){
                            break;
                        }else{
                            System.out.println("输入有误，请重新输入");
                        }

//                        if(choice.equals("y")){
//                            loop = false;
//                        }else if(choice.equals("n")){
//                            break;
//                        }
                    }
                    if(choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while(loop);
        System.out.println("==============退出了零钱通项目==============");
    }
}