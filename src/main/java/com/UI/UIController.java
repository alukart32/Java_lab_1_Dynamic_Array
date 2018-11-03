package com.UI;

import com.array.DynamicArray;

import java.util.Scanner;

/**
 * UiController class implements interconnection with user by sending him messages.
 *
 * Gives result of tests
 */
public class UIController {
    public void printMsg(String msg){
        System.out.print(msg);
    }

    public void printMainMenu(){
        printMsg("***Action menu***\n");
        printMsg("1 - to add an element\n");
        printMsg("2 - to delete an element by index\n");
        printMsg("3 - to change an element by index\n");
        printMsg("4 - to get a size\n");
        printMsg("5 - to show an array\n");
        printMsg("0 - to exit\n");
        printMsg("Press action: ");
    }

    /**
     * Get int value from user
     *
     * @param scanner   what reads user input
     * @return tmp         return entered value
     */
    private int getValue(Scanner scanner){
        int tmp = scanner.nextInt();
        return tmp;
    }

    /**
     * Prints messages, show results of user's actions
     *
     * @param scanner   what reads user input
     * @param array     array
     */
    public void runUi(DynamicArray array, Scanner scanner){
        boolean runApp = true;
        int choice = -1;

        while(runApp){
            printMainMenu();
            choice=getValue(scanner);

            printMsg("\n");

            int tmp;

            switch (choice){
                // add
                case 1:
                    printMsg("Adding an element: ");

                    tmp = scanner.nextInt();
                    array.add(tmp);

                    printMsg("\nArray: \n");
                    array.show();
                    printMsg("\n");
                    break;
                // deleteAt
                case 2:
                    printMsg("Deleting an element:\n");

                    printMsg("Index: ");
                    tmp = scanner.nextInt();
                    array.deleteAt(tmp);

                    printMsg("\nArray: \n");
                    array.show();
                    printMsg("\n");
                    break;
                //changeAt
                case 3:
                    printMsg("Changing an element:\n");

                    printMsg("Index: ");
                    tmp = scanner.nextInt();

                    printMsg("New data: ");
                    int data = scanner.nextInt();

                    array.changeAt(tmp,data);

                    printMsg("\nArray: \n");
                    array.show();
                    printMsg("\n");
                    break;
                // size
                case 4:
                    printMsg("Size of array: ");
                    tmp = array.getSize();

                    printMsg(tmp+"\n\n");
                    break;
                // show
                case 5:
                    printMsg("\nArray: \n");
                    array.show();
                    printMsg("\n");
                    break;
                case 0:
                    runApp = false;
                    break;
                default:
                    printMsg("Not such option!!!\n");
            }
        }
    }
}
