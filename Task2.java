import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2 {
    public static void main (String[] args) {

        int sizeOfInputArray = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заполните массив целыми числами (введите слово 'quit', чтобы закончить заполнение)");
        StringBuilder stringBuilderForArray = new StringBuilder();
        String inputElement;

        do {
            System.out.println("Введите значение элемента массива");
            inputElement = scanner.next();

            if (Pattern.compile("[0-9]+").matcher(inputElement).matches()) {
                sizeOfInputArray += 1;
                stringBuilderForArray.append(inputElement);
                stringBuilderForArray.append(" ");
            } else if (inputElement.equals("quit")) break;
            else {
                System.out.println("Неверное значение");
            }

        } while (true); //Заполняет StringBuilder новыми элементами массива и как счётчик увеличивает размерность

        System.out.println("Размерность массива: " + sizeOfInputArray);

        String stringForArray = stringBuilderForArray.toString();
        String[] inputStringArray = stringForArray.split(" "); // Делает массив строк из введённых числе

        int[] inputIntegerArray = new int[sizeOfInputArray];
        for (int i = 0; i < inputStringArray.length; i++) {
            inputIntegerArray[i] = Integer.parseInt(inputStringArray[i]);
        }  // Переводит массив строк в массив целочисленных

        System.out.print("Исходный массив: " );
        for (int i = 0; i < inputIntegerArray.length; i++) {
            System.out.print(inputIntegerArray[i] + " ");
        }

        System.out.print("\nЧисло к удалению: ");
        int deletedNumber = scanner.nextInt();


        //-------------------------------------------УДАЛЕНИЕ

        int indexToRemove;
        int[] resultArray = new int[inputIntegerArray.length];
        System.arraycopy(inputIntegerArray, 0, resultArray, 0, inputIntegerArray.length);

        while(true) {
            indexToRemove = -1;
            for (int i = 0; i < resultArray.length; i++) {
                if (resultArray[i] == deletedNumber) {
                    indexToRemove = i;
                }
            }  //Поиск индекса элемента по его значения для послед. удаления
            if (indexToRemove == -1) break;


            int[] tempArray = new int[resultArray.length];
            System.arraycopy(resultArray, 0, tempArray, 0, resultArray.length);

            resultArray = new int[resultArray.length - 1];

            for (int i = 0; i < tempArray.length; i++) {
                if (i != indexToRemove) {
                    int newIndex = i < indexToRemove ? i : i - 1;
                    resultArray[newIndex] = tempArray[i];
                }
            }  //Копирует все элементы кроме удаляемого
        }

        System.out.print("Массив после обработки: " );
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }

    }
}