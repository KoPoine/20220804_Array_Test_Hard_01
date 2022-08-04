package codes;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		
		int[] myNumbers = new int [6];
		
		for (int i = 0; i < myNumbers.length; i ++) {			
			
			while (true) {
				System.out.print((i + 1) + "번째 숫자 입력 : ");
				int inputNum = myScanner.nextInt();
				
//				받은 정수가 우리가 요구하는 조건을 통과하는지? > 통과한다면 break; while문을 종료
				boolean isRangeOk = 1 <= inputNum  && inputNum <= 45;
				
				boolean isRepeat = false;
				
//				중복을 확인하는 for-each > isRepeat 변수 값을 변경
//				 => 값을 대입하는게 아닌, 조회해서 우리가 뽑은 숫자(inputNum)과의 중복 여부
				for (int num : myNumbers) {
					
					if (num == inputNum) {
						isRepeat = true;
						break;
					}					
				}	
				
				if (isRangeOk && !isRepeat) {
					myNumbers[i] = inputNum;
					break;
				}
				
				
			}
			
		}
		
//		당첨 숫자 뽑기
		int[] winNumbers = new int[6];
		
		for (int i = 0; i < winNumbers.length; i++) {
			while(true) {
				int randomNum = (int) (Math.random() * 45 + 1);  // Math.random의 범위 : 0 < double < 1
				
				boolean isRepeat = false;
				
				for (int num : winNumbers) {
					if (num == randomNum) {
						isRepeat = true;
						break;
					}
				}
				
				if (!isRepeat) {
					winNumbers[i] = randomNum;
					break;
				}
				
			}
		}
		
	}
	
}
















