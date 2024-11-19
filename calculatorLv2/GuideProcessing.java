package calculatorLv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuideProcessing {

    // 접근 제어 변수 생성
    private int operandFirst = 0;
    private int operandSecond = 0;

    private String pastRecords = "0";
    private String menu;
    private boolean MenuStart;
    private boolean MenupastRecords = false;

    private Calculator calc = new Calculator();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            try {
                MenuStart = true;
                // 계산기 안내 및 메뉴 출력
                while (MenuStart) {
                    System.out.println("어서오세요! \uD83D\uDD22 커비의 계산기에 오신 것을 환영합니다!" + System.lineSeparator() + "y: 계산기 사용하기 | h: 지난 기록 확인하기 | e: 종료하기");
                    System.out.println("-----------------------------------------------------");
                    System.out.print("어떤 메뉴를 이용하시겠습니까? : ");
                    menu = sc.nextLine();
                    switch (menu) {
                        // 계산기 종료
                        case "e":
                            System.out.println("커비의 계산기를 종료합니다.");
                            System.exit(0);
                            break;
                        // 계산기 사용
                        case "y":
                            System.out.println("✖\uFE0F➕➖➗ 계산을 시작합니다! ✖\uFE0F➕➖➗");
                            MenuStart = !MenuStart;
                            break;
                        // 연산 과정, 결과, 삭제 메뉴
                        case "h":
                            MenupastRecords = !MenupastRecords;
                            while (MenupastRecords) {
                                System.out.println("-----------------------------------------------------");
                                System.out.println("1. 마지막 연산결과 확인 | 2. 시도한 모든 연산결과 보기 | 3. 지정 연산결과 보기");
                                System.out.println("4. 마지막 연산식 확인 | 5. 시도한 모든 연산식 보기 | 6. 지정 연산식 보기");
                                System.out.println("7. 마지막 연산기록 삭제 | 8. 시도한 모든 연산기록 삭제 | 9. 지정 연산기록 삭제");
                                System.out.println("0. 나가기");
                                System.out.println("-----------------------------------------------------");
                                System.out.print("어떤 메뉴를 이용하시겠습니까? : ");
                                pastRecords = sc.nextLine();
                                System.out.println("-----------------------------------------------------");

                                // 숫자를 입력받아 정규식 검증 후 메뉴 실행
                                if (!pastRecords.matches("[0-9]+")) {
                                    System.out.println("0부터 9까지의 숫자만 입력이 가능합니다.");
                                } else {
                                    switch (pastRecords) {
                                        // MenuStart 로 이동
                                        case "0":
                                            MenupastRecords = !MenupastRecords;
                                            break;
                                        // 가장 마지막에 진행한 결과값만 출력
                                        case "1":
                                            System.out.println("가장 마지막으로 연산한 결과값은 : " + calc.getRecentResult());
                                            break;
                                        // 시도한 모든 연산의 결과값만 출력
                                        case "2":
                                            System.out.println("요청하신 지금까지의 결과값입니다.");
                                            calc.getAllResult();
                                            break;
                                        // 지정한 연산식의 결과값만 출력
                                        case "3":
                                            System.out.println("몇 번째로 계산한 결과가 궁금하신가요? (숫자로 입력)");
                                            pastRecords = sc.nextLine();
                                            System.out.println("요청주신 순번의 결과값은 :  " + calc.getResult(Integer.parseInt(pastRecords)) + " 입니다.");
                                            break;
                                        // 가장 마지막에 진행한 연산식 출력
                                        case "4":
                                            System.out.println("가장 마지막에 연산식은 :  " + calc.getRecentCulationProcess());
                                            break;
                                        // 시도한 모든 연산식 출력
                                        case "5":
                                            calc.getAllcalCulationProcess();
                                            break;
                                        // 지정한 연산식 출력
                                        case "6":
                                            System.out.println("몇 번째로 계산한 연산식이 궁금하신가요? (숫자로 입력)");
                                            pastRecords = sc.nextLine();
                                            System.out.println("요청주신 순번의 연산식은 : " + calc.getcalCulationProcess(Integer.parseInt(pastRecords)) + " 입니다.");
                                            break;
                                        // 가장 마지막에 연산기록 삭제
                                        case "7":
                                            calc.removeRecentResults();
                                            break;
                                        // 모든 연산기록 삭제
                                        case "8":
                                            System.out.println("모든 저장결과를 삭제합니다.");
                                            calc.removeAll();
                                            break;
                                        // 지정 연산기록 삭제
                                        case "9":
                                            System.out.println("몇 번째로 계산한 내역을 삭제하고 싶으신가요? (숫자로 입력)");
                                            pastRecords = sc.nextLine();
                                            calc.removeResults(Integer.parseInt(pastRecords));
                                            break;
                                    }
                                }
                            }
                        default:
                            System.out.println("y, h, e 로 만 입력해주세요.");
                            System.out.println("==================== \uD83D\uDEA8 다시 시작 합니다! ====================" + System.lineSeparator());
                    }
                }

                // 첫번째 피연산자 입력
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                operandFirst = sc.nextInt();

                // 두번째 피연산자 입력
                System.out.print("두 번째 숫자를 입력하세요 : ");
                operandSecond = sc.nextInt();
                sc.nextLine();

                // 음의 정수 입력 시 오류 메시지 출력 > 시작으로 돌아감
                if (calc.CheckNegativeInteger(operandFirst, operandSecond)) {
                    System.out.println("양의 정수만 입력해주세요.");
                    System.out.println("==================== \uD83D\uDEA8 다시 시작 합니다! ====================" + System.lineSeparator());
                    continue;
                }

                // 연산자 입력
                System.out.print("기호를 입력하세요 (+, -, *, /, %) : ");
                String operator = sc.nextLine();

                // Calculator 객체를 통한 calculate()으로 연산
                System.out.println(operandFirst + " " + operator + " " + operandSecond + " = " + calc.calculate(operandFirst, operandSecond, operator));

            // 예외 발생 조건에 따른 처리
            // 0으로 나눗셈 시도 시 예외 발생
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());

            // 숫자 실수 및 문자 입력시 예외 발생
            } catch (InputMismatchException e) {
                System.out.println("정수인 숫자를 입력해주세요.");
                sc.nextLine();

            // 지정 연산자 외 문자 입력 시 예외 발생
            } catch (OperatorException e) {
                System.out.println(e.getMessage());

            // 비어있는 List 삭제 요청시 예외 발생
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());

            // 정해진 길이를 벗어난 것을 요청할 시 예외 발생
            } catch (IndexOutOfBoundsException e) {
                System.out.println("정확하게 입력해주세요.");
            }
        }
    }
}