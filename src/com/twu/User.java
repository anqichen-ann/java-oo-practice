package com.twu;

import javafx.scene.chart.ScatterChart;

import java.util.Scanner;

public class User extends HotList{
    public String name;
    public static String[] userList = new String[6];
    public static boolean login = false;
    public User(String name){
        this.name = name;
        userList[0] = "你好 "+name+",你可以进行以下操作：";
        userList[1] = "1.查看热搜排行榜";
        userList[2] = "2.给热搜事件投票";
        userList[3] = "3.购买热搜";
        userList[4] = "4.添加热搜";
        userList[5] = "5.退出";
    };
    public void run(){
        Scanner sc = new Scanner(System.in);
        login = true;
        while (login){
            for(String str : userList){
                System.out.println(str);
            }
            try {
                String input = sc.nextLine();
                int number = Integer.parseInt(input);
                if(number >=1 && number <=5){
                    switch (number){
                        case 1: show();
                            break;
                        case 2: vote();
                            break;
                        case 3: buy();
                            break;
                        case 4: add(1);
                            break;
                        case 5: login = false;
                            break;
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
