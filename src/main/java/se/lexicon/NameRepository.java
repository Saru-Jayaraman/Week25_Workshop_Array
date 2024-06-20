package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param newNames The array of names to set.
     */
    public static void setNames(String[] newNames) {
        //todo: PART 1: implement setNames method
        clear();
        names = Arrays.copyOf(newNames, newNames.length);
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: PART 1: implement clear method
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method
        return Arrays.copyOf(names, names.length);
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: PART 2: implement find method
        String isFound = null;
        for (String name : names) {
            if (name.trim().equalsIgnoreCase(fullName.trim())) {
                isFound = name.trim();
            }
        }
        return isFound;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: PART 2: implement add method
        boolean isFound = true;
        if(fullName == null || (fullName.trim().isEmpty())) {
            isFound = false;
        } else {
            String[] tempNames;
            int i=0;
            while(i<names.length) {
                if(names[i].trim().equalsIgnoreCase(fullName.trim())) {
                    isFound = false;
                    break;
                }
                i++;
            }
            if(isFound) {
                String newCapitalizedFullname = "";
                String[] splittedNames = fullName.trim().split(" ");
                for (String splittedName : splittedNames) {
                    newCapitalizedFullname = newCapitalizedFullname.concat(splittedName.substring(0, 1).toUpperCase())
                            .concat(splittedName.substring(1)).concat(" ");
                }
                tempNames = Arrays.copyOf(names, names.length+1);
                tempNames[names.length] = newCapitalizedFullname.trim();
                names = Arrays.copyOf(tempNames, tempNames.length);
            }
        }
        return isFound;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        //todo: PART 3: findByFirstName method
        int matchingFirstNameArrayCounter = 0;
        String[] matchingFirstNameArray = null;
        if(firstName != null && (!firstName.trim().isEmpty())) {
            for (String name : names) {
                if (name.trim().startsWith(firstName.trim())) {
                    if (matchingFirstNameArray == null) {
                        matchingFirstNameArray = new String[1];
                    } else {
                        matchingFirstNameArray = Arrays.copyOf(matchingFirstNameArray, matchingFirstNameArray.length + 1);
                    }
                    matchingFirstNameArray[matchingFirstNameArrayCounter] = name.trim();
                    matchingFirstNameArrayCounter++;
                }
            }
        }
        return matchingFirstNameArray;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        //todo: PART 3: implement findByLastName method
        int matchingLastNameArrayCounter = 0;
        String[] matchingLastNameArray = null;
        if(lastName != null && (!lastName.trim().isEmpty())) {
            for (String name : names) {
                if (name.trim().endsWith(lastName.trim())) {
                    if (matchingLastNameArray == null) {
                        matchingLastNameArray = new String[1];
                    } else {
                        matchingLastNameArray = Arrays.copyOf(matchingLastNameArray, matchingLastNameArray.length + 1);
                    }
                    matchingLastNameArray[matchingLastNameArrayCounter] = name.trim();
                    matchingLastNameArrayCounter++;
                }
            }
        }
        return matchingLastNameArray;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: PART 3: implement update method
        boolean isReplaced = false;
        boolean isUpdatedNamePresent = false;
        if(original == null || original.trim().isEmpty() || updatedName == null || updatedName.trim().isEmpty() || original.trim().equalsIgnoreCase(updatedName.trim())) {
            return isReplaced;
        } else {
            for (String name : names) {
                if (name.trim().equalsIgnoreCase(updatedName.trim())) {
                    isUpdatedNamePresent = true;
                    break;
                }
            }
            if(!isUpdatedNamePresent) {
                for(int i=0; i< names.length; i++) {
                    if(names[i].trim().equalsIgnoreCase(original.trim())) {
                        names[i] = updatedName.trim();
                        isReplaced = true;
                    }
                }
            }
            return isReplaced;
        }
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        //todo: PART 4: implement remove method
        boolean isRemoved = false;
        if(fullName == null || (fullName.trim().isEmpty())) {
            return isRemoved;
        } else {
            for(int i=0; i< names.length; i++) {
                if(names[i].trim().equalsIgnoreCase(fullName.trim())) {
                    names[i] = null;
                    isRemoved = true;
                }
            }
            return isRemoved;
        }
    }
}