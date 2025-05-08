package org.baekjoon.implementation;
/**
 * 플랫폼: 백준
 * 문제번호: 20546
 * 문제이름: 기적의 매매법
 * 유형: 구현
 * 난이도: 실버5
 */

import java.io.*;
import java.util.*;

public class Main20546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //시작 자산 입력
        int money = Integer.parseInt(br.readLine());

        //주식표 입력
        int[] list = new int[14];
        String[] listToStr = br.readLine().split(" ");
        //int 로 파싱
        for(int i = 0; i < 14; i++){
            list[i] = Integer.parseInt(listToStr[i]);
        }

        //준현
        int junhyun = bnp(money, list);
        int sungmin = timing(money, list);

        //System.out.println("j: " + junhyun + ", s: " + sungmin);

        if(junhyun > sungmin)
            System.out.println("BNP");
        else if(junhyun < sungmin)
            System.out.println("TIMING");
        else
            System.out.println("SAMESAME");

    }

    //준현이 계산
    static int bnp(int money, int[] list){
        int stock = 0;
        for(int i = 0; i < 14; i++){
            if(money >= list[i]){
                stock += money / list[i];
                money = money % list[i];
            }
        }
        //System.out.println("bal: " + money + ", stock: " + stock);
        return calculateMoney(money, stock, list[13]);
    }

    //성민이 계산
    static int timing(int money, int[] list){
        int stock = 0;
        int upCnt = 0;
        int downCnt = 0;
        int prePrice = list[0];

        for(int i = 0; i < 14; i++){
            //상승 체크
            if(prePrice < list[i]){
                downCnt = 0;
                upCnt += 1;
            }
            //하락 체크
            if(prePrice > list[i]){
                upCnt = 0;
                downCnt += 1;
            }
            //System.out.println("p: " + list[i] + ", dC: " + downCnt + ", uC: " + upCnt);
            //매수
            if(downCnt >= 3){
                if(money >= list[i]){
                    //System.out.println("buy");
                    stock += money / list[i];
                    money = money % list[i];
                }
            }
            //매도
            if(upCnt >= 3 && stock != 0){
                //System.out.println("sell");
                money += stock * list[i];
                stock = 0;
            }

            prePrice = list[i];
            //System.out.println("money: " + money + ", stock: " + stock);
        }

        //System.out.println("bal: " + money + ", stock: " + stock);
        return calculateMoney(money, stock, list[13]);
    }
    //자산 계산
    static int calculateMoney(int balance, int stock, int price){
        return balance + (stock * price);
    }
}
