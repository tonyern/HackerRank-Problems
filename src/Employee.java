import java.util.*;

public class Employee {
    private String employeeID;

    /**
     * Default constructor
     */
    public Employee() {}

    /**
     * Constructor where ID is created.
     * @param employeeID
     */
    public Employee(String employeeID) {
        this.employeeID = employeeID;
        System.out.println(generateCode(employeeID.substring(4, 13)));
    }

    public String generateCode(String numericString) {
        int even = 0;
        int odd = 0;
        int difference;

        for (int i = 0; i < numericString.length(); i++) {
            char c = numericString.charAt(i);
            int digit = Character.getNumericValue(c);

            if ((i + 1) % 2 == 0) {
                even += digit;
            } else if ((i + 1) % 2 != 0) {
                odd += digit;
            }
        }

        difference = even - odd;
        if (difference > 9) {
            return String.valueOf(difference % 10);
        } else {
            return String.valueOf(difference);
        }
    }

    /**
     * Set employee ID of object calling it.
     * @param employeeID
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Get employee ID of object calling it.
     * @return employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }
}
