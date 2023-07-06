package algo;

import java.time.LocalDate;
import java.time.YearMonth;

public class Collection_test {
	public static void main(String[] args) {
        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();

        // 해당 월의 날 수 구하기
        YearMonth yearMonth = YearMonth.of(year, month);
        int numberOfDays = yearMonth.lengthOfMonth();

        // 결과 출력
        System.out.printf("현재 달(%d)의 날 수: %d \n", month, numberOfDays);
    }
}
