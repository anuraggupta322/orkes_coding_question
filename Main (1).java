import java.util.HashMap;
import java.util.Map;
class Main {
    public Map<String, Object> cells = new HashMap<>();

    public void setCellValue(String cellId, Object value) {
        cells.put(cellId, value);
    }

    public int getCellValue(String cellId) {
        Object value = cells.get(cellId);
        if (value instanceof Integer) {
            return (int) value;
        } else if (value instanceof String) {
            return evaluateExpression((String) value);
        } else {
            throw new IllegalArgumentException("Invalid cell value type: " + value.getClass().getName());
        }
    }

    private int evaluateExpression(String expression) {
        String[] tokens = expression.split("\\+");
        int sum = 0;
        for (String token : tokens) {
            sum += getCellValue(token.trim());
        }
        return sum;
    }

    public static void main(String args[])
    {
        
        Main Spreadsheet = new Main();
        Spreadsheet.setCellValue("A1",12);
        int value1=Spreadsheet.getCellValue("A1");
        System.out.println(value1);
        Spreadsheet.setCellValue("A2",13);
        int value2=Spreadsheet.getCellValue("A2");
        System.out.println(value2);
        Spreadsheet.setCellValue("A3","A1+A2");
        int value3=Spreadsheet.getCellValue("A3");
        System.out.println(value3);
        a
    }
}