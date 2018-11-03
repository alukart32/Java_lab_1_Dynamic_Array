package com.array;

import java.util.Arrays;

/**
 * DynamicArray class implements an array
 * which could be resized in a run time.
 *
 * It allows to add one element at one time, change or
 * delete elements by index, return it's size, show elements
 * <p>
 * Parameter:
 *            <code>size</code> - current size of an array
 *            <code>elements[]</code> - array of elements
 * <p>
 *
 * @author Ivan Tarasov
 * @version 1.0.5
 * @since 20.09.18
 * */
public class DynamicArray{
  private int size;
  private int elements[];

  /**
   * Constructor which setting a beginning size
   */
  public DynamicArray() {
    this.size = 0;
  }

  /**
   * Adding an element, in the meanwhile increasing size and
   * checking size for next steps:
   *
   * if size == 1 than <code>elements[0] = newElement</code>
   * else call copyOf and  <code>elements[this.size-1] = newElement</code>
   *
   * @param newElement  data that will be added to the array
   */
  public void add(int newElement){
    this.size++;

    if(this.size == 1){
      elements = new int[size];
      elements[0] = newElement;
    }else{
      elements = copyOf(elements, this.size, this.size-1);
      elements[this.size-1] = newElement;
    }
  }

  /**
   * Adding a sequence of elements from certain place
   *
   * @param newElements    array of elements that will be added
   * @param index          index from which elements would be added
   */
  public void add(int[] newElements, int index) {
    if (index > 0 && index <= this.size) {
      elements = copyOf(elements, this.size + newElements.length, this.size);

        if (this.size > 0) {
//          if(this.size ==1)
//            for (int j = 1; j < elements.length; j++) {
//             elements[j]=newElements[j-1];
//            }
//
//          int[] tmpArray = new int[newElements.length];
//          for (int i = 0; i < newElements.length; i++)
//            tmpArray[i] = newElements[i];

            elements = shiftRight(elements, index, newElements.length);
        }

        if (index > 0 && this.size > 0) {
          index--;
        }
        for (int i = index, j = 0; i <= index + newElements.length - 1; i++, j++) {
          elements[i] = newElements[j];
        }
        this.size += newElements.length;
      }else{
        System.out.println("\n ArrayIndexOutOfBoundsException!!!");
    }
  }

  /**
   * Changing data by index
   *
   * @param index         index of element which would be changed
   * @param newElement    new data
   */
  public void changeAt(int index, int newElement){
    if(index >= 0 && index <= this.size){
      elements[index-1] = newElement;
    }else {
      System.out.println("\n ArrayIndexOutOfBoundsException!!!");
    }
  }

  /**
   * Deleting element by index.
   *
   * If index is out of range then prints message " ArrayIndexOutOfBoundsException!!!".
   *
   * Index at a last position - calls copyOf() for creating a new array of elements then decrease size.
   *
   * Index is different - calls shiftLeft(), copyOf() and decrease size.
   *
   * @param index   index of target
   */
  public void deleteAt(int index){
    if(index >= 0 && index <= this.size){
      if(index == this.size){
        elements = copyOf(elements, this.size-1, this.size-1);
        this.size--;
      }else {
        elements = shiftLeft(elements, index-1);
        elements = copyOf(elements, this.size-1, this.size-1);
        this.size--;
      }
    }else {
      System.out.println("\n ArrayIndexOutOfBoundsException!!!");
    }
  }

  public int getSize() {
    return size;
  }

  public int getElements(int index) {
    return elements[index-1];
  }

  public void show(){
    for(int i=0; i<size;i++){
      System.out.println(i+1 +": "+ elements[i]);
    }
  }

  /**
   * Shifts in left elements in target[] from given index "from"
   *
   * @param target    array that will be shifted
   * @param from      start index
   * @return          return shifted in left array
   */
  private int[] shiftLeft(int[] target, int from){
    for (int i = from; i < target.length-1; i++) {
      target[i] = target[i+1];
    }
    return target;
  }

  /**
   * Shift in right elements in target[] from given index "from"
   *
   * @param target    array that will be shifted
   * @param index      start index
   * @return          return shifted in right array
   */
  private int[] shiftRight(int[] target, int index, int n){
    for(int i=elements.length-1, j=index-1; i>=elements.length-index && j >=0; i--,j++){
      target[i]=target[j];
    }
    return elements;
  }

  /**
   * Create a new array by copying
   *
   * int[] copy           temp array for coping
   * @param target        array which would be coped
   * @param sizeOfCopy    size of temp array "copy"
   * @param realSize      amount of elements that would be coped
   * @return              return coped array with size of "sizeOfCopy" and with amount of elements "realSize"
   */
  private int[] copyOf(int[] target, int sizeOfCopy, int realSize){
    int[] copy = new int[sizeOfCopy];

    for(int i=0; i<realSize;i++){
      copy[i]=target[i];
    }
    return copy;
  }

}