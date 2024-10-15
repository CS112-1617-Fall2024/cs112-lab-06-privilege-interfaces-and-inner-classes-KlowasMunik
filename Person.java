public class Person implements Comparable<Person> {
    // CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Jamie Doe";
    public static final String DEFAULT_STORY = "Unknown";
    public static final int DEFAULT_PRIVILEGE = 100;

    // INSTANCE VARIABLES
    private String name;
    private Identity identity;  // Changed from 'story' to 'identity'
    private int privilege;

    /**
     * Identity inner class to represent pronouns and background
     */
    public class Identity {
        private String pronouns;
        private String background;

        public Identity(String pronouns, String background) {
            this.pronouns = pronouns;
            this.background = background;
        }

        // Setters
        public void setPronouns(String pronouns) {
            this.pronouns = pronouns;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        // Getters
        public String getPronouns() {
            return pronouns;
        }

        public String getBackground() {
            return background;
        }

        @Override
        public String toString() {
            return "Pronouns: " + pronouns + ", Background: " + background;
        }
    }

    // CONSTRUCTORS
    public Person(String name, String pronouns, String background, int privilege) {
        this.name = name;
        this.identity = new Identity(pronouns, background);
        this.privilege = privilege;
    }

    public Person() {
        this(DEFAULT_NAME, "They/Them", DEFAULT_STORY, DEFAULT_PRIVILEGE);
    }

    public Person(Person original) {
        if (original == null) {
            throw new IllegalArgumentException("Cannot copy null object in Person copy constructor");
        } else {
            this.name = original.name;
            this.identity = new Identity(
                original.identity.getPronouns(),
                original.identity.getBackground()
            );
            this.privilege = original.privilege;
        }
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public void setIdentity(String pronouns, String background) {
        this.identity.setPronouns(pronouns);
        this.identity.setBackground(background);
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public int getPrivilege() {
        return privilege;
    }

    public Identity getIdentity() {
        return identity;
    }

    // INTERFACE METHODS: Comparable Implementation
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.privilege, other.privilege);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", " + identity.toString() +
               "\nPrivilege Points: " + privilege;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return this.name.equals(otherPerson.name) &&
               this.identity.getPronouns().equals(otherPerson.identity.getPronouns()) &&
               this.identity.getBackground().equals(otherPerson.identity.getBackground()) &&
               this.privilege == otherPerson.privilege;
    }
}
