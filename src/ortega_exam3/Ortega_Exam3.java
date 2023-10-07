/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ortega_exam3;

import java.util.Scanner;

/**
 *
 * @author home
 */
public class Ortega_Exam3 {
   
    public class PriorityQArray{
    int priority;
    int data;
    PriorityQArray next;
        
    }
private int printCount =0;
private PriorityQArray front;


private void insertion(int item,int priority) throws Exception{
    PriorityQArray  node = new PriorityQArray();
    node.data = item;
    node.priority = priority;
    node.next = null;
  
    
     if(front == null || priority <= front.priority){
         node.next = front;
         front  = node;
     }else{        
          PriorityQArray temporary = front ;
       
          while (temporary.next != null && temporary.next.priority <= priority){
              temporary = temporary.next;
          }
          
          node.next = temporary.next;
          temporary.next = node;  
          
        
          }
             printCount++;
             
          if(printCount> 5){
              deletion();   
          
     }
        
     
}

public int deletion () throws Exception {
    if (front == null){
        throw new Exception ("Queue is empty:");
    }
  
    int temporary = front.data;
    front = front.next;
      

    return temporary;
}

public void display ()throws Exception{
     if (front == null){
        throw new Exception ("Queue is empty:");
    }
     
     PriorityQArray temporary = front;
     
     System.out.println("Priority \t\t Pages");
     
     while (temporary != null){
    System.out.println(temporary.priority +"\t\t" + temporary.data);
            temporary = temporary.next;
}
      System.out.println("\n");
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      Scanner scan = new Scanner(System.in);
      Ortega_Exam3 pr = new Ortega_Exam3();
      boolean start = true;
      
      while(start){
          System.out.println("1. Print assignent:");
//          System.out.println("2. Display");
          int choose = scan.nextInt();
          
          switch(choose){
              case 1:
                  System.out.println("1.Print pages:");
                int num = scan.nextInt();
                System.out.println("Enter position");
                    int position = scan.nextInt();
          
                    pr.insertion(num, position-1);
                    pr.display();
                   break;
              default:
                  new AssertionError ();
          
          }
          
          
          
          
      }
      
    }
    
}
