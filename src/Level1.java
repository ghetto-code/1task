import com.sun.jdi.Type;

import java.beans.ExceptionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Level1 {

    public static int operationsCount = 0;
    // задаем текущую строку
    public static String currentString = "";

    // задаем результирующую строку
    public static String resultString = "";

    // создаем список, куда будем записывать историю оперций
    public static ArrayList<String []> operationsStack = new ArrayList<>();

    // создаем список, куда будем записывать историю состояний
    public static ArrayList<String> stateStack = new ArrayList<>();

    // хэш мэп со списком поддерживаемых команд
    public static HashMap<Integer, String> commands = new HashMap<>();

    // массив из строк, в котором будем хранить предыдущую операцию
    public static String[] prevOperation = new String[2];

    public static int idx = 0;

    // исполняющая функция
    public static String BastShoe(String command) {

        // если стэк состояний пуст, добавляем в список операций добавление пустой строки, добавляем в стек состояний пустую строку, увеличиваем счетчик операций
        if (stateStack.size() == 0) {
            operationsStack.add(new String[]{"1",""});
            stateStack.add("");
            operationsCount++;
            idx++;
        }
        // определяем текущую операцию
        String[] currentOperation = new String[2];

        // подгрузили поддерживаемые команды
        defCommands(commands);

        // превратили входящую строку в команду
        convertCurrentOperationFromString(currentOperation, command);

        // проверить корректность входящей команды и отдать ее код
        int code = operationCode(currentOperation);
        if (code == 1) {
            try {
                if (Integer.parseInt(prevOperation[0]) == 4){
                    String [] x = operationsStack.get(idx-1);
                    String z = stateStack.get(idx - 1);
                    operationsStack.clear();
                    stateStack.clear();
                    operationsStack.add(x);
                    stateStack.add(z);
                    currentString = z;
                    idx = stateStack.size();
                    operationsCount = 1;
                }
                add(currentOperation[1],currentOperation);
            } catch (NumberFormatException e) {
                add(currentOperation[1], currentOperation);
            }

        } else if (code == 2) {
            try {
                if (Integer.parseInt(prevOperation[0]) == 4){

                }
                del(Integer.parseInt(currentOperation[1]),currentOperation);
            } catch (NumberFormatException e) {
                del(Integer.parseInt(currentOperation[1]),currentOperation);
            }

        } else if (code == 3) {
            return getSymbol(Integer.parseInt(currentOperation[1]));
        } else if (code == 4) {
            undo(currentOperation);
        } else if (code == 5) {
            redo(currentOperation);
        } else {
            return currentString;
        }

        return resultString;
    }

    //  фунция определения поддерживаемых команд
    public static void defCommands(HashMap<Integer, String> commands) {
        commands.put(1, "add");
        commands.put(2, "del");
        commands.put(3, "get");
        commands.put(4, "undo");
        commands.put(5, "redo");
    }

    // функция ковертирует текущую операцию из входящей строки в массив
    public static void convertCurrentOperationFromString(String[] currentOperation, String currentCommand) {
        currentOperation[0] = null;
        currentOperation[1] = null;

        //   в первую ячку записываем первый символ строки
        currentOperation[0] = currentCommand.substring(0,1);

        // если длина текущей команды больше 2
        if (currentCommand.length() > 2) {

            // если второй символ "пробел", тогда....
            if(currentCommand.charAt(1) == ' '){

                // во вторую ячейку записываем оставшуюся часть строки, начиная с третьего символа, чтобы не попадать на
                // первый пробел
                currentOperation[1] = currentCommand.substring(2);
            } else {
                currentOperation[1] = "dontcorrect";
            }

        }
    }

    // функция проверяет, является ли числом входящая строка
    public static boolean isANum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // функция, которая проверяет корректность текущей команды, и если она корректна, возвращает код операции,
    // а если нет, то 0
    public static int operationCode(String [] currentOperation) {
        if (Integer.parseInt(currentOperation[0]) == 5 && currentOperation[1] == null) {
            return 5;
        }
        if (Integer.parseInt(currentOperation[0]) == 4 && currentOperation[1] == null) {
            return 4;
        }
        if (Integer.parseInt(currentOperation[0]) == 3 && !currentOperation[1].equals("dontcorrect") && Integer.parseInt(currentOperation[1]) < currentString.length()) {
            return 3;
        }
        if (Integer.parseInt(currentOperation[0]) == 2 && isANum(String.valueOf(currentOperation[1]))) {
            return 2;
        }
        if (Integer.parseInt(currentOperation[0]) == 1 && !currentOperation[1].equals("dontcorrect")) {
            return 1;
        }
        return 0;
    }

    // функция добавления строки
    public static void add(String addStr, String[] currentOperation) {
        resultString = currentString + addStr;
        currentString = resultString;


        // добавляем текущую операцию в стек
        operationsStack.add(currentOperation);
        operationsCount++;
        stateStack.add(resultString);
        // обновляем значение предыдущей операции
        prevOperation = currentOperation;
        idx = stateStack.size();
    }

    // функция удаления заданного количества символов
    public static void del(int quantity, String[] currentOperation) {

//         если количество удаляемых символов больше, чем длина текущей строки,...
        if (quantity > currentString.length()) {

            //  тогда очищаем результирующую строку
            resultString = "";

            // если нет, то...
        } else {

            // обновляем значение результирующей строки
            resultString = currentString.substring(0,currentString.length() - quantity);
        }

        // обновляем значение текущей строки
        currentString = resultString;

        // обновляем значение предыдущей операции
        prevOperation = currentOperation;

        // добавляем текущую операцию в стек
        operationsStack.add(currentOperation);
        stateStack.add(resultString);
        operationsCount++;
        idx = stateStack.size();
    }

    // функция возвращает запрошенный символ в виде строки
    public static String getSymbol(int i) {
        String x = String.valueOf(resultString.charAt(i));
        return x;
    }

    // функция отмены последней операции
    public static void undo (String[] currentOperation) {
        if (stateStack.size() > 1) {
            if(idx != 1){
                resultString = stateStack.get(idx - 2);
                currentString = resultString;
                idx--;
                prevOperation = currentOperation;
            }
        }
    }

    // функция восстановления последней операции после отмены
    public static void redo (String[] currentOperation) {
        if(idx < stateStack.size()) {
            resultString = stateStack.get(idx);
            currentString = resultString;
            idx++;
            prevOperation = currentOperation;
        }
    }
}
