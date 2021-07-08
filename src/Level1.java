import java.beans.ExceptionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Level1 {
    private static int operationsCount = 0;
    private static ArrayList<String[]> operationsStack = new ArrayList<>();
    private static ArrayList<String> stateStack = new ArrayList<>();
    public static String finalString = "";
    private static HashMap<Integer,String> commands = new HashMap<>();


    public static String BastShoe(String command) {
        commands.put(1, "add");
        commands.put(2, "del");
        commands.put(3, "get");
        commands.put(4, "undo");
        commands.put(5, "redo");

        if (operationsStack.size() == 0) {
            stateStack.add(finalString);
            upOperationsCount();
        }
        String [] strArr = command.split(" ");
        operationsStack.add(strArr);
        try {
            if (Integer.parseInt(strArr[0]) == 1) {
                try{
                    int x = Integer.parseInt(operationsStack.get(operationsStack.size()-2)[0]);
                    if (x == 4) {
                        operationsStack.clear();
                        stateStack.clear();
                        operationsCount = 0;
                    }
                    add(strArr[1]);
                }catch (IndexOutOfBoundsException e){

                }
            }
            if (Integer.parseInt(strArr[0]) == 2) {
                if (Integer.parseInt(operationsStack.get(operationsStack.size()-1)[0]) == 4) {
                    operationsStack.clear();
                    stateStack.clear();
                    operationsCount = 0;
                }
                del(Integer.parseInt(strArr[1]));
            }
            if (Integer.parseInt(strArr[0]) == 3) {
                return getSymbol(Integer.parseInt(strArr[1]));
            }
            if (Integer.parseInt(strArr[0]) == 4) {
                undo();
            }
            if (Integer.parseInt(strArr[0]) == 5) {
                redo();
            }
            if(!commands.containsKey(Integer.parseInt(strArr[0]))){
                return finalString;
            }
        } catch (NumberFormatException e) {
        }

        return finalString;
    }

    public static void undo () {
        if (operationsCount > 1) {
            finalString = stateStack.get(operationsCount-2);
            downOperationsCount();
        }



    }
    public static void redo () {
        finalString = stateStack.get(operationsCount);
        upOperationsCount();
    }
    public static String getSymbol(int i) {
        String x = String.valueOf(finalString.charAt(i));
        upOperationsCount();
        return x;

    }
    public static void add(String addStr) {
        finalString += addStr;
        stateStack.add(finalString);
        upOperationsCount();
    }
    public static void del(int quantity) {
        if (quantity > finalString.length()) {
            finalString = "";
        } else {
            finalString = finalString.substring(0,finalString.length() - quantity);
        }

        stateStack.add(finalString);
        upOperationsCount();
    }
    public static void upOperationsCount () {
        operationsCount++;
    }
    public static void downOperationsCount () {
        operationsCount--;
    }

}
