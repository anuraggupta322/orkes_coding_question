import java.util.HashMap;
import java.util.Map;
class  Spreadsheet{
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
        
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setCellValue("A1",12);
        int value1=spreadsheet.getCellValue("A1");
        System.out.println(value1);
        spreadsheet.setCellValue("A2",13);
        int value2=spreadsheet.getCellValue("A2");
        System.out.println(value2);
        spreadsheet.setCellValue("A3","A1+A2");
        int value3=spreadsheet.getCellValue("A3");
        System.out.println(value3);
    }
}
