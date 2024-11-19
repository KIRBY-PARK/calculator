package calculatorLv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 사용자 입력 객체 생성
            Scanner scanner = new Scanner(System.in);

            // 첫번째 피연산자 입력
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            double operandFirst = scanner.nextDouble();

            // 연산자 입력
            System.out.print("기호를 입력하세요 (+, -, *, /) : ");
            char operator = scanner.next().charAt(0);

            // 두번째 피연산자 입력
            System.out.print("두 번째 숫자를 입력하세요 : ");
            double operandSecond = scanner.nextDouble();

            // 결과값 저장 변수 선언
            double result = 0;

            // 유효하지 않은 연산자 변수 선언
            boolean operatorNo = true;

            // 사용자가 입력한 기호에 따른 case(operator) 실행
            switch (operator) {
                // 덧셈
                case '+':
                    result = operandFirst + operandSecond;
                    break;
                // 뺄셈
                case '-':
                    result = operandFirst - operandSecond;
                    break;
                // 곱셈
                case '*':
                    result = operandFirst * operandSecond;
                    break;
                // 나눗셈
                case '/':
                    if (operandSecond != 0) { // 0으로 나눌 수 없음
                        result = operandFirst / operandSecond;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력하세요.");
                        operatorNo = false;
                    }
                    break;

                // 안내한 기호 외의 것을 입력한 경우 오류 메세지 출력
                default:
                    System.out.println("기호입력이 잘못되었습니다.");
                    operatorNo = false; // 유효하지 않은 연산자
                    break;
            }

            // 잘못된 입력으로 인한 루프 발생 > 시작으로 돌아감
            if (!operatorNo) {
                continue;
            }

            // 결과 값 출력
            System.out.println("결과 : " + result);

            // 종료 및 재실행 여부 확인
            System.out.println("exit를 입력하면 계산을 종료합니다. 다시 계산을 원한다면 아무거나 입력해주세요.");

            // 사용자 입력 객체 생성
            String str = sc.nextLine();

            // 종료 여부 확인
            if (str.equalsIgnoreCase("exit")) {
                System.out.println("계산 종료");
                break; // 루프 종료
            } else {
                System.out.println("계산을 다시 시작합니다.");
            }
        }
    }
}
