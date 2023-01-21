public class Thread1 {
    public static void main(String args[]) {
        System.out.println("Main Starts");

        Thread th = Thread.currentThread(); // * returns the current thread which is being executed
        System.out.println("Name: " + th.getName());
        System.out.println("Priority: " + th.getPriority());
        System.out.println("Alive: " + th.isAlive()); // * returns if true if thread is alive else returns zero

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println("Main Ends");
    }
}