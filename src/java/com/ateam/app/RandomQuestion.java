/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;

import java.util.Random;
import java.util.*;
/**
 *
 * @author Andrew
 */
public class RandomQuestion {

 
public RandomQuestion () 
{
String[] questionAr=new String[5];
questionAr[0]="Question No 1";
questionAr[1]="Question No 2";
questionAr[2]="Question No 3";
questionAr[3]="Question No 4";
questionAr[4]="Question No 5";
Random generator = new Random();
int r = generator.nextInt(questionAr.length);
System.out.println(questionAr[r]);
}
}