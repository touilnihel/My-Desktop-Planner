
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class utility {
    // write a method to get input from the user
    public static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    // write a method to display a message to the user
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    // write a method to tell if the given date is in the future
    public static boolean isDateInFuture(String date) throws ParseException {
        Date d = new Date();

        return (d.after(convertStringToDate(date))) ? true : false;

    }

    // write a method to convert string to date
    public static Date convertStringToDate(String date) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }

    // write a method to display date in the format dd/mm/yyyy
    public static String displayDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    // write a method that converts String to hour:min format date

    public static Date convertStringToHour(String date) throws ParseException {
        return new SimpleDateFormat("HH:mm").parse(date);
    }

    // write a method that takes any enum and displays its members
    public static <T extends Enum<T>> void displayEnumMembers(Class<T> enumClass) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            System.out.println(enumConstant);
        }
    }

    // write a method to get the enum member from cardinal number
    public static <T extends Enum<T>> T getEnumMember(Class<T> enumClass, int ordinal) {
        return enumClass.getEnumConstants()[ordinal];
    }

    public static int askForInt(String string) {
        System.out.print(string);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
