import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import  java.time.*;
import java.time.temporal.ChronoUnit;



/**

 * A class that organizes user data input and formatted output of the received data
 */
public class Functions {

    /**

     * Reading the name (last name or patronymic) entered by the user
     *
     *
     * @return <b>Name</b> which the user entered
     *
     */

    public static String GetName(){

        String Name = null;
        int LenInput=0;

        try {
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
            Name = bufferedReader1.readLine();

            //If the input buffer is empty
            if (Name.isEmpty())
                throw new FormatException("Ничего не введено");

            for (char c : Name.toCharArray()) {
                if (Character.isWhitespace(c)) {
                    LenInput++;

                }
            }
            //If the string consists only of spaces
            if (LenInput==Name.length())
                throw new FormatException("Ввод не должен содержать одни пробелы");


        }
        catch(FormatException e) {
            System.out.println("Ошибка ввода");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch(IOException e) {
            System.out.println("Ошибка при вводе данных");
            System.out.println(e.getMessage());
        }
        return Name;
    }

    /**

     * Reading the date of birth entered by the user
     *
     *
     * @return <b>Date</b>  of birth which the user entered
     *
     */
    public static String GetDate(){
        String Date = null;

        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            Date = buff.readLine();
            //
            if (Date.length()!=10)
                throw new FormatException("Введите дату в формате чч.мм.гггг");

        }
        catch(FormatException e) {
            System.out.println("Неверный формат ввода");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch(IOException e) {
            System.out.println("Ошибка при вводе данных");
            System.out.println(e.getMessage());
        }

        return Date;
    }

    /**

     * Format output of user entered data: Surname and initials,Gender of a person,Current age.
     *
     * @param InSurname user's surname
     * @param InName Username
     * @param InPatronymic user's patronymic
     * @param number day of birth
     * @param month birth month
     * @param year year of birth
     */
    public static void OutPut(String InSurname, String InName, String InPatronymic,int number,int month, int year){
        char Name;
        char Patronymic;
        char last;
        try {
            Name = InName.charAt(0);
            Patronymic = InPatronymic.charAt(0);

            //Gender determination by ending patronymic
            last=InPatronymic.charAt(InPatronymic.length()-1);
            String gender;
            if (last=='а'){
                gender="женский";
            }
            else gender="мужской";

            System.out.println("\nВведенные данные:");
            System.out.println(InSurname + " " + Name + "." + Patronymic + ".");
            System.out.println("Пол: " + gender);
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Ошибка при вводе данных");
            System.out.println(e.getMessage());
        }

        //Age calculation
        LocalDate today             = LocalDate.now();
        LocalDate birthday          = LocalDate.of(year, month, number);
        long age = ChronoUnit.YEARS.between(birthday, today);

        //Output format for the word "years"
        String word_age = "лет";
        if (age>10 && age<20){
            word_age= "лет";
        }
        else if (age%10==1){
            word_age= "год";
        }
        else if (age%10==2 || age%10==3 || age%10==4){
            word_age= "года";
        }
        System.out.println("Возраст: " + age + " " + word_age);



    }
}
