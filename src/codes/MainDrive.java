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
		
//		임시로 당첨번호 하드코딩 > 아래 로직 확인용
		winNumbers[0] = 10;
		winNumbers[1] = 11;
		winNumbers[2] = 12;
		winNumbers[3] = 13;
		winNumbers[4] = 14;
		winNumbers[5] = 15;
		
//		Bubble sort
		for (int i = 0; i < winNumbers.length; i++) {
			
			for (int j = 0; j < winNumbers.length - 1; j++) {
			
				if (winNumbers[j] > winNumbers[j+1]) {
					int backUp = winNumbers[j];
					
					winNumbers[j] = winNumbers[j+1];
					
					winNumbers[j+1] = backUp;
				}
				
			}				
		}
		
//		내 숫자가 당첨 숫자들 사이에 있는가?
		int correctCount = 0;
		
		for (int myNum : myNumbers) {
			
			for (int winNum : winNumbers) {
			
				if (myNum == winNum) {
					correctCount++;
					break;					
				}
				
			}
		}		
		
//		보너스 번호를 추출
		int bonusNum = 0;
		while (true) {
			int randomNum = (int) (Math.random() * 45 + 1);
			
			boolean isRepeat = false;
			
			for (int num : winNumbers) {
				if (num == randomNum) {
					isRepeat = true;
					break;							
				}
			}
			
			if (!isRepeat) {
				bonusNum = randomNum;
				break;
			}
		}
		
//		당첨 등수 확인
		if (correctCount == 6) {
			System.out.println("축 당첨 - 1등");
		}
		else if (correctCount == 5) {
//			2등과 3등의 분기처리
//			임시로 3등으로 진행
			boolean isBonusCorrect = false;
			
			for (int myNum : myNumbers) {
				if (myNum == bonusNum) {
					isBonusCorrect = true;
					break;
				}
			}
			
			if (isBonusCorrect) {
				System.out.println("축 당첨 - 2등");
			}
			else {
				System.out.println("축 당첨 - 3등");	
			}			
		}
		else if (correctCount == 4) {
			System.out.println("축 당첨 - 4등");
		}
		else if (correctCount == 3) {
			System.out.println("축 당첨 - 5등");
		}
		else {
			System.out.println("낙첨되었습니다.");
		}
			
		
		
		
		
		
		
	}
	
}



































