import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

public class DateInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("กรุณาป้อนวันที่ (รูปแบบ dd/MM/yyyy): ");
        String dateInput = scanner.nextLine();
        scanner.close();

        Calendar thaiCalendar = new GregorianCalendar(new Locale("th", "TH"));
        String[] weekdays = new String[] {"อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์", "เสาร์"};
    
        int day, month, year;
        try {
            day = Integer.parseInt(dateInput.substring(0, 2));
            month = Integer.parseInt(dateInput.substring(3, 5));
            year = Integer.parseInt(dateInput.substring(6));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("รูปแบบวันที่ไม่ถูกต้อง");
            return;
        }
    
        thaiCalendar.set(Calendar.YEAR, year - 543);
        thaiCalendar.set(Calendar.MONTH, month - 1);
        thaiCalendar.set(Calendar.DAY_OF_MONTH, day);
    
        int currentWeekday = thaiCalendar.get(Calendar.DAY_OF_WEEK);
        String currentWeekdayName = weekdays[currentWeekday - 1];
        // แสดงวันของสัปดาห์
        System.out.println("วันที่ " + dateInput + " เป็นวัน " + currentWeekdayName);
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateInput, formatter);
    
        // แสดงวันที่ในปี
        int dayOfYear = date.getDayOfYear();
        System.out.println("วันที่ " + dateInput + " เป็นวันที่ที่ " + dayOfYear + " ของปี");
    
        // แสดงสัปดาห์ในปี
        int weekOfYear = date.get(WeekFields.ISO.weekOfYear());
        System.out.println("วันที่ " + dateInput + " เป็นสัปดาห์ที่ " + weekOfYear + " ของปี");
    
        // แสดงปีที่เป็นคริสต์ศักราช
        int yearAD = date.getYear() - 543;
        System.out.println("ปีที่ " + dateInput + " เป็นปี ค.ศ. " + yearAD);
        
        // แสดงจำนวนวันในปี
        int daysInYear = date.lengthOfYear();
        System.out.println("ปีที่ " + dateInput + " มี " + daysInYear + " วัน ");
    }
}