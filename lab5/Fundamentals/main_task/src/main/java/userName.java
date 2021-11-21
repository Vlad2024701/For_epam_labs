import java.util.Scanner;

public class userName {
    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String inputUserName = inputStream.nextLine();
        System.out.println("Hello " + inputUserName + "!\n");

        for (int i = args.length - 1; i >= 0; i--)
            System.out.printf("Argument %d: %s; ", i, args[i]);

        System.out.println("\nСколько чисел вы хотите скомпилировать?");
        int inputNumberOfDigits = inputStream.nextInt();
        System.out.println("\nВвод " + inputNumberOfDigits + " радномных чисел, без перехода на новую строку:");
        for (int i = 0; i < inputNumberOfDigits; i++){
            int randomNumber = (int)(Math.random()*((100 - 10) + 1)) + 10;
            System.out.print(randomNumber + ", ");
        }
        System.out.println("\n\nС переходом на новую строку:");
        for (int i = 0; i < inputNumberOfDigits; i++){
            int randomNumber = (int)(Math.random()*((100 - 10) + 1)) + 10;
            System.out.println(i + 1 + ") " + randomNumber);
        }

        System.out.print("\nВведите первое целое число: ");
        int firstValue = inputStream.nextInt();
        System.out.print("Введите второе целое число: ");
        int secondValue = inputStream.nextInt();
        System.out.println("Сумма = " + (firstValue + secondValue) + "\nПроизведение = " + firstValue * secondValue);

        System.out.print("\nВведите число от 1 до 12 для вывода названия месяца, соответствующего данному числу: ");
        int numberOfMonth = inputStream.nextInt();
        System.out.println(getMonth(numberOfMonth));
    }

    public static String getMonth(int numberOfMonth){
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if(numberOfMonth > 0 && numberOfMonth < months.length)
            return "Месяц для введенного числа: " + months[numberOfMonth];
        return "number must be in the limit of 1 and 12";
    }
}
