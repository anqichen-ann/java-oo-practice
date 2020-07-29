package com.twu;

import java.lang.reflect.Array;
import java.util.*;

public class HotList {
    public static ArrayList<Hot> hotList = new ArrayList<>();
    public int voteNumber = 10;
    public  Scanner sc = new Scanner(System.in);

    public void add(int factor){
        //Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要添加的热搜事件的标题：");
        String desc = sc.nextLine();
        System.out.println("添加成功！");
        Hot hotpot = new Hot(desc,0,factor);
        hotList.add(hotpot);
    }
    public void show(){
        if(hotList.size()==0){
            System.out.println("抱歉，热搜榜为空~");
        }else {
            int num = 1;
            for(Hot hot : hotList){
                System.out.println(num+" "+hot.getDesc()+" "+hot.getPot());
                num++;
            }
        }
    }
    public void vote(){
        Boolean find = false;
        int length = hotList.size();
        if(length ==0) {
            System.out.println("热搜事件为空，您无法投票");
        }else if(voteNumber == 0){
            System.out.println("您的票数为0，无法投票");
        }else {
            System.out.println("请输入您要投票的热搜事件标题：");
            String voteHotpot = sc.nextLine();
            for(int i=0; i<length; i++){
                Hot hot = hotList.get(i);
                if(hot.getDesc().equals(voteHotpot)){
                    find = true;
                    System.out.println("请输入您要投的票数：（您目前还有"+voteNumber+"票)");
                    try {
                        int num = Integer.parseInt(sc.nextLine());
                        if(num>=0&&num<=voteNumber){
                            hot.setPot(hot.getPot()+num*hot.getFactor());
                            voteNumber-=num;
                            sort();
                            System.out.println("投票成功！");
                            break;
                        }else {
                            System.out.println("您输入的票数数量错误");
                        }
                    }catch (NumberFormatException error){
                        System.out.println("您输入的票数格式错误");
                    }

                }
            }
            if(!find){
                System.out.println("该热搜事件不存在");
            }
        }

    }
    //按照热搜热度进行排序
    public void sort(){
        int length = hotList.size();
        //将购买热搜移出到另一个列表
        ArrayList<Hot> buyHotList = new ArrayList<>();
        Integer levelArray[] = new Integer[length];
        int num = 0;
        for(Hot hot: hotList){
            if(hot.getMoney()>0){
                buyHotList.add(hot);
                levelArray[num] = hot.getFixlevel();
                //hotList.remove(hot);
                num++;
            }
        }
        //从原热搜列表中删除购买热搜
        for(Hot hot : buyHotList){
            hotList.remove(hot);
        }

        int newleng = hotList.size();
        for(int i=0; i<newleng-1; i++){
            for(int j=0; j<newleng-1-i; j++){
                int prehot = hotList.get(j).getPot();
                int nexthot = hotList.get(j+1).getPot();
                if(nexthot>prehot){
                    swap(hotList, j,j+1);
                }
            }
        }
        //将购买热搜插入到原热搜中
        int count = buyHotList.size();
        if(count>0){
            Integer[] newLevelArray = Arrays.copyOfRange(levelArray,0,count);
            for(int j=0;j<count;j++){
                int min = Collections.min(Arrays.asList(newLevelArray));
                for(int n=0;n<count;n++){
                    if(min==newLevelArray[n]){
                        hotList.add(min-1,  buyHotList.get(n));
                        newLevelArray[n] = Integer.MAX_VALUE;
                    }
                }
            }
        }

    }

    //交换list中replaceNum1和replaceNum2的位置
    public void swap(ArrayList<Hot> list,int replaceNum1,int replaceNum2){
            list.add(replaceNum1, list.get(replaceNum2));
            list.add(replaceNum2+1, list.get(replaceNum1+1));
            list.remove(replaceNum1+1);
            list.remove(replaceNum2+1);
    }

    public void buy(){
        Boolean find = false;
        int length = hotList.size();
        if(length==0){
            System.out.println("热搜榜为空，无法购买");
        }else {
            System.out.println("请输入您要购买的热搜事件名称：");
            String buyHot = sc.nextLine();
            for(int i=0; i<length; i++) {
                Hot hot = hotList.get(i);
                if (hot.getDesc().equals(buyHot)) {
                    find = true;
                    System.out.println("请输入您要购买的热搜排名：");
                    try {
                        int level = sc.nextInt();
                        if(level<=0||level>length){
                            System.out.println("您输入的排名错误");
                        }else {
                            System.out.println("请输入您要购买的热搜金额：");
                            int money = sc.nextInt();
                            Hot desHot = hotList.get(level-1);
                            if(money > desHot.getMoney()){
                                System.out.println("购买成功！");
                                hot.setMoney(money);
                                hot.setFixlevel(level);
                                if(desHot.getMoney()>0){
                                    hotList.remove(level-1);
                                }
                                hotList.remove(hot);
                                hotList.add(level-1,hot);
                                break;
                            }else {
                                System.out.println("金额不够，购买失败！");
                            }
                        }
                    }catch (NumberFormatException error){
                        System.out.println("您输入的排名/金额格式错误");
                    }catch (InputMismatchException error){
                        System.out.println("您输入的排名/金额格式错误");
                    }

                }
            }
            if(!find){
                System.out.println("该热搜事件不存在");
            }
        }
    }

}
