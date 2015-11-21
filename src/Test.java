// * * * * * * * * * * * * * * * * * * * * * * * *
// * REDROCK-TEAM HOMEWORK 6 (20151107)          *
// * Level 3 - Bag                               *
// * Author:  Haruue Icymoon                     *
// * Website: http://www.caoyue.com.cn/          *
// * * * * * * * * * * * * * * * * * * * * * * * *

import cn.com.caoyue.util.Bag;

/**
 * 此类用于测试 Bag 类
 */
public class Test {
    public static void main(String args[]) {
        Bag<Integer> bag = new Bag<>(5);
        bag.add(20);
        System.out.println(bag);
        bag.add(20);
        bag.add(20);
        bag.add(20);
        bag.add(20);
        System.out.println(bag);
        bag.add(30);
        bag.add(30);
        bag.add(40);
        bag.add(50);
        bag.add(60);
        System.out.println(bag);
        bag.remove(30);
        System.out.println(bag);
        bag.remove(20);
        System.out.println(bag);
        System.out.println(bag.indexOf(60));
        System.out.println(bag.indexOf(50,1));
        System.out.println(bag.indexOf(50,2));
        System.out.println(bag.getIndex(0));
    }
}
