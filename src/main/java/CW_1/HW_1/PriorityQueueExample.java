package CW_1.HW_1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {

    public static void main(String[] args) {

        //пример естественного упорядочивания priority queue
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Обработка Integer:"+in);
        }

        //PriorityQueue пример с Comparator
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);

        pollDataFromQueue(customerPriorityQueue);

    }

    //анонимный компаратор реализации класса
    public static Comparator<Customer> idComparator = new Comparator<Customer>(){

        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c1.getId() - c2.getId());
        }
    };

    //вспомогательный метод для добавления случайных данных в Queue
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
        }
    }

    //метод для извлечения данных из queue
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Обработка заказчика с ID="+cust.getId());
        }
    }

    public static class Customer {

        private int id;
        private String name;

        public Customer(int i, String n){
            this.id=i;
            this.name=n;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }


    }

}