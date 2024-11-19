package calculatorLv2;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Calculator {
    private double result = 0;

    // 연산과정 및 결과 저장 List 생성
    private ArrayList<Integer> saveOperandsFirst = new ArrayList<>();
    private ArrayList<Integer> saveOperandsSecond = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private ArrayList<Double> results = new ArrayList<>();

    // 연산 과정 출력 변수
    private String calculationProcess = "";

    // 사용자가 입력한 기호에 따른 case(operator) 실행
    public double calculate(int operandFirst, int operandSecond, String operator) throws InputMismatchException, ArithmeticException, OperatorException {
        switch (operator) {
            // 덧셈
            case "+":
                result = operandFirst + operandSecond;
                saveCalculation(operandFirst, operandSecond, result, operator);
                break;
            // 뺄셈
            case "-":
                result = operandFirst - operandSecond;
                saveCalculation(operandFirst, operandSecond, result, operator);
                break;
            // 곱셈
            case "*":
                result = operandFirst * operandSecond;
                saveCalculation(operandFirst, operandSecond, result, operator);
                break;
            // 나눗셈
            case "/":
                if (operandSecond == 0) {
                    throw new ArithmeticException("0으로는 나눌 수 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
                }
                result = operandFirst / operandSecond;
                saveCalculation(operandFirst, operandSecond, result, operator);
                break;
            // 나머지
            case "%":
                result = operandFirst % operandSecond;
                saveCalculation(operandFirst, operandSecond, result, operator);
                break;

            // 지정 연산자 외 문자 입력 시 오류 메세지 출력
            default:
                throw new OperatorException("+, -, *, /, % 연산자만 입력해주세요" + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        }
        return result;
    }

    // 연산 과정 및 결과 저장
    private void saveCalculation(int operandFirst, int operandSecond, double result, String operator) {
        saveOperandsFirst.add(operandFirst);
        saveOperandsSecond.add(operandSecond);
        results.add(result);
        operators.add(operator);
    }

    // 빈 List 요청 확인
    private boolean CheckEmptyList() {
        if (saveOperandsFirst.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // 요청 index 가 size 를 넘지 않았는지 확인
    private boolean CheckListSize(int index) {
        if (saveOperandsFirst.size() < index) {
            return true;
        } else {
            return false;
        }
    }

    // 음의 정수 입력값 확인
    public boolean CheckNegativeInteger(int operandFirst, int operandSecond) {
        if (operandFirst < 0 || operandSecond < 0) {
            return true;
        } else {
            return false;
        }
    }

    // 지정된 연산 결과 출력
    public double getResult(int index) throws IndexOutOfBoundsException, EmptyListException {
        // List 비어있을 경우 예외 발생
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 연산결과가 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
            // size 초과하는 인덱스를 입력시 예외 발생
        } else if (CheckListSize(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            return results.get(index - 1);
        }
    }

    // 저장된 모든 연산결과 출력
    public void getAllResult() throws EmptyListException {
        // List 비어있을 경우 예외 발생
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(i + 1 + "번째 결과값 : " + results.get(i));
            }
        }
    }

    // 지정된 연산식 출력
    public String getcalCulationProcess(int index) throws IndexOutOfBoundsException, EmptyListException {
        // List 비어있을 경우 예외 발생
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 연산식이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
            // size 초과하는 인덱스 입력시 예외 발생
        } else if (CheckListSize(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            calculationProcess = saveOperandsFirst.get(index - 1).toString() + " " + operators.get(index - 1) + " " + saveOperandsSecond.get(index - 1).toString()
                    + " = " + results.get(index - 1).toString();
            return calculationProcess;
        }
    }

    // 저장된 모든 연산식 출력
    public void getAllcalCulationProcess() throws EmptyListException {
        // List 비어있을 경우 예외 발생
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 연산식이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else {
            for (int i = 0; i < saveOperandsFirst.size(); i++) {
                System.out.println(i + 1 + "번째 연산 과정 : " + saveOperandsFirst.get(i).toString() + " " + operators.get(i) + " " + saveOperandsSecond.get(i).toString()
                        + " = " + results.get(i).toString());
            }
        }
    }

    // 가장 최근 연산 결과 반환
    public double getRecentResult() throws EmptyListException {
        // List 비어있을 경우 예외 발생
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else {
            return results.get(results.size() - 1);
        }
    }

    // 가장 최근 연산 과정 반환
    public String getRecentCulationProcess() throws EmptyListException {
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else {
            calculationProcess = saveOperandsFirst.get(saveOperandsFirst.size() - 1).toString() + " " + operators.get(operators.size() - 1) + " " + saveOperandsSecond.get(saveOperandsSecond.size() - 1).toString()
                    + " = " + results.get(results.size() - 1).toString();
            return calculationProcess;
        }
    }

    // 가장 최근에 저장된 값 삭제
    public void removeRecentResults() throws EmptyListException {
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else {
            System.out.println("가장 마지막에 연산한 " + saveOperandsFirst.get(saveOperandsFirst.size() - 1) + operators.get(operators.size() - 1)
                    + saveOperandsSecond.get(saveOperandsSecond.size() - 1) + " = " + results.get(results.size() - 1) + " 가 삭제되었습니다.");
            saveOperandsFirst.remove(saveOperandsFirst.size() - 1);
            saveOperandsSecond.remove(saveOperandsSecond.size() - 1);
            results.remove(results.size() - 1);
            operators.remove(operators.size() - 1);
        }

    }

    // 지정된 연산 결과 및 과정 삭제
    public void removeResults(int index) throws IndexOutOfBoundsException, EmptyListException {
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 연산식과 결과값이 없습니다." + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else if (CheckListSize(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            System.out.println(index + "번째 연산식인 " + saveOperandsFirst.get(index - 1) + operators.get(index - 1)
                    + saveOperandsSecond.get(index - 1) + " = " + results.get(index - 1) + " 가 삭제되었습니다.");
            saveOperandsFirst.remove(index - 1);
            saveOperandsSecond.remove(index - 1);
            results.remove(index - 1);
            operators.remove(index - 1);
        }
    }

    // 모든 저장 결과 삭제
    public void removeAll() throws EmptyListException {
        if (CheckEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다!" + System.lineSeparator() + "==================== \uD83D\uDEA8 다시 시작 합니다! ====================");
        } else {
            saveOperandsFirst.clear();
            saveOperandsSecond.clear();
            operators.clear();
            results.clear();
        }
    }
}