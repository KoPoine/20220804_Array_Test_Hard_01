package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		
		int[] myNumbers = new int [6];
		
		for (int i = 0; i < 6; i ++) {
			
			
			while (true) {
				System.out.print(i + "번째 숫자 입력 : ");
				int inputNum = myScanner.nextInt();
				
//				받은 정수가 우리가 요구하는 조건을 통과하는지? > 통과한다면 break; while문을 종료
				boolean isRangeOk = 1 <= inputNum  && inputNum <= 45;
				
				
				if (isRangeOk) {
					myNumbers[i] = inputNum;
					break;
				}
				
				
			}
			
		}
		
	}
	
}
















