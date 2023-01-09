package app;

public class App {

  public static void main(String[] args) {


    boardMenu();
  }

  private static void boardMenu() {

    BoardHandler boardHandler = new BoardHandler();

    while(true) {
      System.out.println("[게시글 관리]");
      System.out.println("1.입력");
      System.out.println("2.목록");
      System.out.println("3.조회");
      System.out.println("4.변경");
      System.out.println("5.삭제");
      int menuNo = Prompt.inputInt("입력해봐> ");

      if(menuNo == 1) {
        boardHandler.input();

      } else if(menuNo == 2) {
        boardHandler.printlist();
        System.out.println("");
      } else if(menuNo == 3) {
        boardHandler.viewBoard();
        System.out.println("");
      } else if(menuNo == 4) {
        boardHandler.modifyBoard();
        System.out.println("");
      } else if(menuNo == 5) {
        boardHandler.deleteBoard();
        System.out.println("");
      } else {
        System.out.println("올바른 번호를 입력하세요");
      }
    }
  }





}
