package app;

import java.util.Scanner;

public class Prompt {
  static Scanner scanner = new Scanner(System.in);

  static String inputString (String input) {
    System.out.print(input);
    return scanner.nextLine();
  }

  static int inputInt (String input) {
    return Integer.parseInt(inputString(input));
  }

  static void close() {
    scanner.close();
  }


  // Scanner-String으로 인한, int로 형변환 필요
  //  static int inputInt(St no) {
  //    Integer.parseInt(no);
  //    //    System.out.print("번호를 입력해봐");
  //  }
}
