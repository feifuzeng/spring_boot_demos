package com.github.feifuzeng;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年07月17日 11:09:00
 */
 class SingleTon {

    private static SingleTon singleTon = new SingleTon();

    public static int count1;

    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }
    public static SingleTon getInstance(){
        return singleTon;
    }

}


    public class Test{
        public static void main(String[] args) {
            SingleTon singleTon = SingleTon.getInstance();
            System.out.println(singleTon.count1);
            System.out.println(singleTon.count2);
        }
    }
