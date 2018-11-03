package com;


import com.UI.UIController;
import com.array.DynamicArray;


import java.util.Scanner;


/**
 * Start Point of an application.
 * <p>
 * Create User Interface, Scanner and DynamicArray <code>array</code>
 * which send as parameter to <code>ui.runUi</code>
 * <p>
 *
 * @author Ivan Tarasov
 * @version 1.0.2
 * @since 14.09.18
 * */
public class Main {
  public static void main(String[] args){
    UIController ui = new UIController();
    Scanner scanner = new Scanner(System.in);
    DynamicArray array = new DynamicArray();

    ui.runUi(array, scanner);
  }
}
