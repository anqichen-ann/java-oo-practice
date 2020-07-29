package com.twu;

import java.util.Scanner;

public class Main {
    public static boolean login = true;
    public static String[] mainList = new String[4];

    public static void main(String[] args) {
        mainList[0] = "欢迎来到热搜榜，你是？";
        mainList[1] = "1.用户";
        mainList[2] = "2.管理员";
        mainList[3] = "3.退出";
        Scanner sc = new Scanner(System.in);
        while(login){
            for(String str : mainList){
                System.out.println(str);
            }
            try {
                String input = sc.nextLine();
                int number = Integer.parseInt(input);
                if( number >=1 && number <= 3){
                    if(number == 1){
                        System.out.println("请输入您的昵称：");
                        String username = sc.nextLine();
                        User user = new User(username);
                        user.run();
                    }
                    if(number == 2){
                        System.out.println("请输入您的昵称：");
                        String AdminName = sc.nextLine();
                        System.out.println("请输入您的密码：");
                        String psw= sc.nextLine();
                        Admin adm = new Admin();
                        if(adm.log_in(AdminName, psw)){
                            adm.run();
                        }else {
                            System.out.println("您的用户名或密码输入错误");
                        }
                    }
                    if(number == 3){
                        login = false;
                    }

                }else {
                    System.out.println("您的输入错误，请重新输入~");
                }
            }catch (NumberFormatException error){
            System.out.println("您的输入错误");
            }

        }
    }
}
