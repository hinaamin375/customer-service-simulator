

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import ArrivalEvent;
import Server;
import Sequence;
import RandomGenerator;
import Event;

public class EventSimulator {

    public static final int ARRIVES = 1;
    public static int noLeft = 0;

    /**
     * Manages all the severs and assigns customers to their respective servers.
     */

    public static void simulate() {
        Scanner scanner = new Scanner(System.in);
        //arraylist of servers
        ArrayList<Server> servers = new ArrayList<>();
     
        //priority 
        PriorityQueue<Event> events = new PriorityQueue<>(new EventComparator());
        //Taking input from user
        System.out.println("Enter the seed Value");
        int seedValue = scanner.nextInt();
        
        System.out.println("Enter number of servers");
        int noOfServers = scanner.nextInt();
        
     
        
        System.out.println("Enter number of queue length");
        int queueLength = scanner.nextInt();
        
        System.out.println("Enter number of Customer");
        int noOfCustomers = scanner.nextInt();
        
        System.out.println("Enter number of arrival rate");
        double arrivalRate = scanner.nextDouble();
        
        System.out.println("Enter number of service rate");
        double serviceRate = scanner.nextDouble();
        
        System.out.println("Enter number of Resting rate");
        double restingRate = scanner.nextDouble();
        
        System.out.println("Enter number of resting probability");
        double restingProb = scanner.nextDouble();
        
    

        //object of random generator
        RandomGenerator rg = new RandomGenerator(seedValue, arrivalRate, serviceRate, restingRate);
 
        //setting arrival time
        Supplier<Double> arrivalTimeStream = () -> rg.genInterArrivalTime();
        
        //setting service time
        Supplier<Double> serviceTimeStream = () -> rg.genServiceTime();
        
        //setting resting rate
        Supplier<Double> randomRestStream = () -> rg.genRandomRest();
        //settung rest period
        Supplier<Double> restPeriodStream = () -> rg.genRestPeriod();
     

        Event.setServiceTimeStream(serviceTimeStream);
        Event.setRestPeriodStream(restPeriodStream);
        Event.setRandomRestStream(randomRestStream);
  

        //adding servers to the array list
        for (int i = 1; i <= noOfServers; i++) {
            servers.add(new Server(i));
        }
    
        Server.setRestingProb(restingProb);

        int i = 1;
        double time = 0.0;
        int counter = 0;

        while (counter < noOfCustomers) {

                ArrivalEvent e1 = new ArrivalEvent(new Customer(time, i), 
                    servers, queueLength);
                events.add(e1);
          

            time += arrivalTimeStream.get();
            i++;
            counter++;
        }

        while (!events.isEmpty()) {
            Event e1 = events.poll();
            Event next = e1.getNextEvent();
            if (next != null) {
                events.add(next);
            }
        }

        PriorityQueue<Sequence> sequence = Event.getSequence();

        while (!sequence.isEmpty()) {
            String sp = sequence.poll().getSentence();
            System.out.println(sp);
        }

        System.out.println(Server.getStats());

    }
}
