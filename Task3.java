import java.util.Scanner;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {

        int sizeOfInputArray = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заполните массив целыми числами (введите слово 'quit', чтобы закончить заполнение)");
        StringBuilder stringBuilderForArray = new StringBuilder();
        String inputElement;

        do {
            System.out.println("Введите значение элемента массива");
            inputElement = scanner.next();

            if (Pattern.compile("((\\d+\\.)?\\d+)|[0-9]+").matcher(inputElement).matches()) {
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

        float[] inputFloatArray = new float[sizeOfInputArray];
        for (int i = 0; i < inputStringArray.length; i++) {
            inputFloatArray[i] = Float.parseFloat(inputStringArray[i]);
        }  // Переводит массив строк в массив целочисленных

        System.out.print("Исходный массив: ");
        for (int i = 0; i < inputFloatArray.length; i++) {
            System.out.print(inputFloatArray[i] + "  ");
        }

        //-------------------------------------------УДАЛЕНИЕ

        int indexToRemove;
        float[] resultArray = new float[inputFloatArray.length];
        System.arraycopy(inputFloatArray, 0, resultArray, 0, inputFloatArray.length);

        while (true) {
            indexToRemove = -1;
            for (int i = 0; i < resultArray.length - 1; i++) {
                if (resultArray[i + 1] < resultArray[i]) {
                    indexToRemove = i + 1;
                }
            }  //Поиск индекса элемента по его значения для послед. удаления
            if (indexToRemove == -1) break;

            float[] tempArray = new float[resultArray.length];
            System.arraycopy(resultArray, 0, tempArray, 0, resultArray.length);

            resultArray = new float[resultArray.length - 1];

            for (int i = 0; i < tempArray.length; i++) {
                if (i != indexToRemove) {
                    int newIndex = i < indexToRemove ? i : i - 1;
                    resultArray[newIndex] = tempArray[i];
                }
            }  //Копирует все элементы кроме удаляемого
        }

        System.out.print("\nМассив после обработки: ");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + "  ");
        }

    }
}


