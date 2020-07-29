package com.twu;

import java.util.Scanner;

public class Admin extends HotList{
    private static String name = "admin";
    private static String psd = "admin123";
    private String[] adminList = {
            "你好，"+name+"你可以进行以下操作：",
            "1.查看热搜排行榜",
            "2.添加热搜",
            "3.添加超级热搜",
            "4.退出"
    };
    public static boolean login = false;
    public boolean log_in(String name, String psd){
        if(name.equals(Admin.name) && psd.equals(Admin.psd)){
            login = true;
            return true;
        }else {
            return false;
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        while (login){
            for(String str : adminList){
                System.out.println(str);
            }
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if(number >=1 && number <=4){
                    switch (number){
                        case 1:show();
                            break;
                        case 2: add(1);
                            break;
                        case 3: add(2);
                            break;
                        case 4:login = false;
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
