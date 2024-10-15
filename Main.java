import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String[] STATEMENTS = {
        "English is my native language.",
        "My parents graduated college.",
        "I have never wondered where my next meal will come from.",
        "I have no disabilities.",
        "My work and school holidays coincide with the religious holidays I celebrate.",
        "I studied the culture and history of my ancestors in elementary school.",
        "I have never been bullied based on something I could not change.",
        "I have never been stopped by law enforcement due to mere suspicion.",
        "I or my parents have inherited money or property.",
        "I am a US citizen.",
        "I feel safe going for a walk alone.",
        "I go by the same name I was given at birth.",
        "I am comfortable presenting my ID.",
        "My ancestors were not enslaved.",
        "I have family or friends that can give me employment.",
        "I have never been told my natural hair looks unprofessional.",
        "I have gone to private school.",
        "I can easily find souvenirs with my name on them."
    };

    public static final int PTS_PER_ANSWER = 10;
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Person p1 = new Person("Amira", "She/Her", "Syrian refugee", 40);
        Person p2 = new Person("D'Andra", "She/Her", "African-American trans woman", -20);
        Person p3 = new Person("Jennifer", "She/Her", "New Yorker", 140);
        Person p4 = new Person("Pete", "He/Him", "Guy from Pennsylvania", 200);
        Person self = new Person();

        Person[] people = {p1, p2, p3, p4, self};
        boolean done = false;

        System.out.println("Welcome to the Privilege Calculator.\n");

        fillInfo(self);

        do {
            System.out.println("\n~~~ Main Menu ~~~");
            System.out.println("1. Take questionnaire to calculate privilege estimate.");
            System.out.println("2. Check my estimate.");
            System.out.println("3. Compare my estimate with others.");
            System.out.println("4. Exit program.");
            System.out.print("Enter choice: ");

            int input = keyboard.nextInt();
            System.out.println();

            switch (input) {
                case 1:
                    self.setPrivilege(doPrivilegeQuestionnaire());
                    System.out.println("Your privilege estimate is: " + self.getPrivilege());
                    break;
                case 2:
                    System.out.println(self);
                    break;
                case 3:
                    Arrays.sort(people);
                    System.out.println("Comparing your privilege to others:");
                    for (Person person : people) {
                        System.out.println(person);
                    }
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    done = true;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        } while (!done);

        System.out.println("Thank you for exploring your privilege.");
    }

    public static void fillInfo(Person person) {
        System.out.println("What is your name? ");
        keyboard.nextLine();  // Clear buffer
        String name = keyboard.nextLine();

        System.out.println("Enter your pronouns: ");
        String pronouns = keyboard.nextLine();

        System.out.println("Tell us about your background: ");
        String background = keyboard.nextLine();

        person.setName(name);
        person.setIdentity(pronouns, background);
    }

    public static int doPrivilegeQuestionnaire() {
        int privilegeEstimate = Person.DEFAULT_PRIVILEGE;

        for (String statement : STATEMENTS) {
            System.out.println(statement);
            System.out.print("1. True\n2. False\nEnter your choice: ");
            int choice = keyboard.nextInt();

            if (choice == 1) {
                privilegeEstimate += PTS_PER_ANSWER;
            } else if (choice == 2) {
                privilegeEstimate -= PTS_PER_ANSWER;
            } else {
                System.out.println("Invalid choice, defaulting to false.");
                privilegeEstimate -= PTS_PER_ANSWER;
            }
        }

        return privilegeEstimate;
    }
}
