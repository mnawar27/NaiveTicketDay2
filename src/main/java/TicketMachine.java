/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine {
    // The price of a ticket from this machine.
    private Integer price;
    // The amount of money entered by a customer so far.
    private Integer balance;
    // The total amount of money collected by this machine.
    private Integer total;
    // The number of tickets printed.
    private Integer ticketNumber;
    private Integer numberofTickets;

    private Integer refund;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(Integer ticketCost) {
        price = ticketCost;
        balance = 0;
        total = 0;
        ticketNumber = 0;
        numberofTickets= 0;
        refund = 0;
    }




    /**
     * Return the price of a ticket.
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Return ticketNumber.
     * (Increments on each print.)
     */
    public Integer getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public Integer insertMoney(Integer amount) {
        balance = balance + amount;
        return balance;
    }

    public Integer calculateTotal() {
        total = balance + total;
        return total;
    }

    public Integer getRefund(){

       /* if (balance >= price){
            refund = balance - price;
            return refund;
        }
        else{
            return 0;
        }*/

        balance = getBalance();
        refund = balance - price;
        return refund;


    }


    public Integer incrementTicketNumber() {
        ticketNumber++;
        return ticketNumber;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public String printTicket() {
        // Increment the number of tickets printed
        incrementTicketNumber();
        System.out.println("ticket no. is: " + ticketNumber);
        // Update the total collected with the balance.
        //total = total + balance;
        total = ticketNumber * price;
        // Clear the balance.
        clearBalance();
        calculateTotal();
        System.out.println("Ticket price: " + price + " cents. " + "Your total is " + total + ".");


        return "Ticket price: " + price + " cents. " + "Your total is " + balance + ".";
    }

    private void clearBalance() {
        balance = 0;
    }

    public static void main(String[] args){
//        TicketMachine machine1 = new TicketMachine(40);
//        //machine1.balance = machine1.price;
//        System.out.println("Ticket price is: " + machine1.getPrice());
//        System.out.println("Money Inserted: " + machine1.insertMoney(100));
//        System.out.println("Your Balance is: " + machine1.getBalance());
//        System.out.println(machine1.printTicket());
//        //0 is returned if we check the machine’s balance after it has printed a ticket
//        System.out.println("Your balance is(inserted money): " + machine1.getBalance());
//        System.out.println("Your refund is: " + machine1.getRefund());
//        System.out.println("\t");

        TicketMachine machine2 = new TicketMachine(68);
        //machine2.balance = machine2.price;
        System.out.println("Your ticket number is: " + machine2.getTicketNumber());
        System.out.println("Ticket price is: " + machine2.getPrice());
        System.out.println("Money Inserted: " + machine2.insertMoney(100));
        //System.out.println("Your Balance is: " + machine2.getBalance());
        System.out.println("Your Balance is: " + machine2.getRefund());
        System.out.println(machine2.printTicket());
        System.out.println("Your Balance is " + machine2.balance);
        //clearBalance();

       // System.out.println("Your balance(inserted money) is: " + machine2.getBalance());
        //System.out.println("Your refund is: " + machine2.getRefund());

    }

}