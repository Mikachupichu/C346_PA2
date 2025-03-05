package C346_PA2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	Network objNetwork = new Network( );            /* Activate the network */
        objNetwork.start();

        Client objClient1 = new Client("sending");          /* Start the sending client thread */
        objClient1.start();
        Client objClient2 = new Client("receiving");        /* Start the receiving client thread */
        objClient2.start();
        
      /*..............................................................................................................................................................*/
       
      Server server1 = new Server(1);
      server1.start();
      Server server2 = new Server(2);
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
