

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Main {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Object object = new Object();
      Object item = new Object();
      Object thing = new Object();
        
    	Network objNetwork = new Network( );            /* Activate the network */
        objNetwork.start();

        Client objClient1 = new Client("sending", object, item);          /* Start the sending client thread */
        objClient1.start();
        Client objClient2 = new Client("receiving", object, item);        /* Start the receiving client thread */
        objClient2.start();
        
      /*..............................................................................................................................................................*/
       
      Server server1 = new Server("Thread1", object, item, thing);
      server1.start();
      Server server2 = new Server("Thread2", object, item, thing);
      server2.start();
      
      try {
        objNetwork.join();
        objClient1.join();
        objClient2.join();
        server1.join();
        server2.join();
      }  catch (InterruptedException e) {System.out.println("Done.");}
    }
    
 }
