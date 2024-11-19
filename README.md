## Lv2. 클래스를 적용한 사칙연산 계산기
![클래스를 적용한 사칙연산 계산기 프로젝트 이미지](https://ifh.cc/g/V9lkH7.png)

## ❓ 클래스를 적용한 사칙연산 계산기?
>자바 문법의 실습과 객체 지향 개념의 적용
> <br>
> 
> 제공받은 구현 가이드라인 중 Lv2에 초점을 맞추어 구현하였습니다.<br>
> 이 프로젝트는 자바의 객체지향 원칙을 적용하여 클래스를 적용하고 연산을 수행하는 메소드를 작성해야했고<br>
> 이 과정에서 클래스와 객체의 개념을 이해하고 활용하는 방법을 익힐 수 있었습니다 😊

## 🙋‍♀️ 조금 더 구체적으로 가르쳐주세요!
1. 클래스 생성 및 클래스 분할
2. 클래스 분리 캡슐화
3. Getter & Setter 활용
4. 컬렉션으로 값을 넣고 제거하기

## 📌 목차

1. [❓ 클래스를 적용한 사칙연산 계산기?](#-클래스를-적용한-사칙연산-계산기)
2. [🙋‍♀️ 조금 더 구체적으로 가르쳐주세요!](#-조금-더-구체적으로-가르쳐주세요)
3. [📌 목차](#-목차)
    - [🗂️ Project info](#-Project-info)
    - [🚀 Stacks](#-Stacks)
    - [💻 Program operation screen](#-Program-operation-screen)
    - [☄️ Major functional code](#-Major-functional-code)
    - [📂 Architecture](#-Architecture)
    - [🛠️ Trouble shooting](#-Trouble-shooting)

## 🗂️ Project info

- 프로젝트 이름 : Project < calculatorLv2 >
- 개발기간 : 2024.11.18 - 2024.11.19

<br>

## 🚀 Stacks

### Environment
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![GitGub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)


### Skills
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

### OS
![Mac os](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=apple&logoColor=white)

### Workspace Specs
![MacBookPro M2](https://img.shields.io/badge/Apple-MacBook_Pro_M2_2022-999999?style=for-the-badge&logo=apple&logoColor=white)

### Blog
[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api/badge?name=kirby_y)](https://velog.io/@kirby_y)

<br>

## 💻 Program operation screen

<details>
   <summary>📍 사칙연산 동작 화면 보기</summary>

### 📍 사칙연산 동작 화면

![프로그램 동작화면](https://ifh.cc/g/M84QWy.png)

</details>

<details>
   <summary>📍 히스토리 동작 화면 보기</summary>

### 📍 연산결과 확인
![연산결과 확인 동작화면](https://ifh.cc/g/t6nJn6.png)

***

### 📍 연산식 확인
![연산식 확인 동작화면](https://ifh.cc/g/myTWZP.png)

***

### 📍 지정 연산기록 삭제 및 전체기록 확인
![지정 연산기록 삭제 및 전체기록 확인](https://ifh.cc/g/J5K1lm.png)

***

### 📍 마지막 연산기록 삭제 및 전체기록 확인
![마지막 연산기록 삭제 및 전체기록 확인](https://ifh.cc/g/BWkLnq.png)

***

### 📍 전체 연산기록 삭제 및 전체기록 확인
![전체 연산기록 삭제 및 전체기록 확인](https://ifh.cc/g/psn4Gb.png)

</details>

<details>
   <summary>📍 종료 동작 화면 보기</summary>

### 📍 종료 동작 화면

![종료 동작화면](https://ifh.cc/g/w4697w.png)

</details>

<br>

## ☄️ Major functional code

### 연산과정 및 결과 저장
```java
private ArrayList<Integer> saveOperandsFirst = new ArrayList<>();
private ArrayList<Integer> saveOperandsSecond = new ArrayList<>();
private ArrayList<String> operators = new ArrayList<>();
private ArrayList<Double> results = new ArrayList<>();
```
```java
private void saveCalculation(int operandFirst, int operandSecond, double result, String operator) {
   saveOperandsFirst.add(operandFirst);
   saveOperandsSecond.add(operandSecond);
   results.add(result);
   operators.add(operator);
}
```

### 연산 과정 및 결과 삭제
```java
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
```

<br>

## 📂 Architecture

```java
📂
├─ .idea
│  ├─ .gitignore
│  ├─ material_theme_project_new.xml
│  ├─ misc.xml
│  ├─ modules.xml
│  ├─ uiDesigner.xml
│  ├─ workspace.xml
│  └─ vcs.xml
│
├─ CalculatingMachineProject.iml
│
├─ calculatorLv2.iml
│
├─ caculcatorLv1
│  └─ Lv.1 클래스 없는 사칙연산 계산기
│    └─ Calculator.java
│
└─ caculcatorLv2
  └─ Lv.2 클래스 적용한 사칙연산 계산기
    ├─ Main.java : main 실행 클래스
    ├─ Calculator.java : 계산 클래스
    ├─ GuideProcessing.java : 프로그램 흐름 제어 클래스
    ├─ EmptyListException.java
    └─ OperatorInputException.java
```

<br>

## 🛠️ Trouble shooting

[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api?name=kirby_y&tag=onestepcalculator)](https://velog.io/@kirby_y)
[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api?name=kirby_y&tag=twostepcalculator)](https://velog.io/@kirby_y)
