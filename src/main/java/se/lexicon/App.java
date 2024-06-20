package se.lexicon;


public class App {
    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("PART 1...................");
        System.out.println("=========================");
        int size = NameRepository.getSize();
        System.out.println(size);

        System.out.println("=========================");
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Sarumathi Jayaraman", "sarumathi satheeshkumar",
         "sarumathi satheesh", "sarumathi jayaram", "chellathai jayaraman", "jayapradeep jayaraman", "jayabharath jayaraman"});
        System.out.println(NameRepository.getSize());

        System.out.println("=========================");
        String[] names = NameRepository.findAll();
        System.out.println("Newly added names:");
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println("=========================");
        System.out.println("*************END OF PART1*************");

        System.out.println();

        System.out.println("=========================");
        System.out.println("PART 2...................");
        System.out.println("=========================");
        String foundFullName = NameRepository.find("sarumathi jayaraman");
        System.out.println("Founded full name: " + foundFullName);

        System.out.println("=========================");
        String name = "pragya satheeshkumar";
        String name1 = "sarumathi jayaraman";
        boolean isFound = NameRepository.add(name);
        System.out.println("Adding a name " + name + ":" + isFound);
        boolean isFound1 = NameRepository.add(name1);
        System.out.println("Adding a name " + name1 + ":" + isFound1);
        System.out.println("=========================");
        System.out.println("*************END OF PART2*************");

        System.out.println();

        System.out.println("=========================");
        System.out.println("PART 3...");
        System.out.println("=========================");

        String[] firstNameArray = NameRepository.findByFirstName("sarumathi");
        System.out.println("Matching first name array");
        if(firstNameArray != null) {
            for(String firstName : firstNameArray) {
                System.out.println(firstName);
            }
        }

        System.out.println("=========================");
        String[] lastNameArray = NameRepository.findByLastName("jayaraman");
        System.out.println("Matching last name array");
        if(lastNameArray != null) {
            for(String lastName : lastNameArray) {
                System.out.println(lastName);
            }
        }

        System.out.println("=========================");
        boolean replacedString = NameRepository.update(" Sarumathi Jayaraman  ", " Saru Jayaraman ");
        System.out.println("Replaced String: " + replacedString);
        System.out.println("=========================");
        System.out.println("*************END OF PART3*************");

        System.out.println();

        System.out.println("=========================");
        System.out.println("PART 4...");
        System.out.println("=========================");
        boolean isRemoved = NameRepository.remove(" Saru Jayaraman ");
        System.out.println("String removed: " + isRemoved);
        System.out.println("=========================");
        System.out.println("*************END OF PART4*************");
    }
}