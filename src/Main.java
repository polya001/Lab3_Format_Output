//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.lang.String;
public class Main {
    public static void main(String[] args) throws FormatException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //entering last name, first name, patronymic and date of birth
        System.out.println("Введите фамилию:");
        String InputSurname = Functions.GetName();
        System.out.println("Введите имя:");
        String InputName = Functions.GetName();
        System.out.println("Введите отчество:");
        String InputPatronymic = Functions.GetName();
        System.out.println("Введите дату рождения в формате чч.мм.гггг :");
        String InputDate = Functions.GetDate();

        //Getting the day, month, year number from the entered date
        String Number = null;
        String Month = null;
        String Year = null;
        try {
             Number = InputDate.substring(0,2);
             Month = InputDate.substring(3,5);
             Year = InputDate.substring(6,InputDate.length());
         }
         catch (StringIndexOutOfBoundsException e){
             System.out.println("Ошибка при вводе данных");
             System.out.println(e.getMessage());
         }


        //Formatted data output
        try {
            Functions.OutPut(InputSurname,InputName, InputPatronymic,Integer.parseInt(Number),Integer.parseInt(Month),Integer.parseInt(Year));


        }
        catch (NumberFormatException e){
            System.out.println("Ошибка преобразования String к int");
            System.out.println(e.getMessage());
        }





    }
}