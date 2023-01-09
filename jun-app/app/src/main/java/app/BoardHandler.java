package app;

import java.sql.Date;

public class BoardHandler {

  static final int SIZE = 100;

  int count = 0;
  Board[] boards = new Board[SIZE];

  //
  void input() {
    Board board = new Board();
    System.out.println("");
    System.out.println("[입력]");
    board.no = Prompt.inputInt("번호? ");
    board.subject = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.password = Prompt.inputString("암호? ");
    board.writedDate = new Date(System.currentTimeMillis()).toString();
    System.out.println("");

    this.boards[count++] = board;
  }

  // 게시글 목록 출력
  void printlist() {
    System.out.println("");
    System.out.println("[목록]");
    System.out.println("번호\t제목\t작성일\t\t조회수");

    for(int i = 0; i < this.count; i++) {
      Board board = this.boards[i];
      System.out.printf(
          "%d\t%s\t%s\t%d\n", board.no, board.subject, board.writedDate, board.views);
    }
  }

  // 조회 기능 : 번호검색
  Board findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    }
    return null;
  }

  int indexOf(Board board) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].no == board.no) {
        return i;
      }
    }
    return -1;
  }

  void viewBoard() {
    System.out.println("");
    System.out.println("[조회]");
    int boardNo = Prompt.inputInt("게시글 번호를 입력하세요> ");
    Board board = this.findByNo(boardNo);

    if (board == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.subject);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성일: %s\n", board.writedDate);
    System.out.printf("조회수: %d\n", board.views);
  }

  void modifyBoard() {
    System.out.println("");
    System.out.println("[변경]");
    int boardNo = Prompt.inputInt("게시글 번호를 입력하세요> ");
    Board before = this.findByNo(boardNo);

    if (before == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Board board = new Board();
    board.no = before.no;
    board.writedDate = before.writedDate;
    board.subject = Prompt.inputString(String.format("제목(%s)? ", before.subject));
    board.content = Prompt.inputString(String.format("내용(%s)? ", before.content));
    String str = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (str.equalsIgnoreCase("Y")) {
      this.boards[this.indexOf(before)] = board;
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }

  }

  void deleteBoard() {
    System.out.println("");
    System.out.println("[삭제]");
    int boardNo = Prompt.inputInt("삭제할 게시글 번호> ");
    Board board = this.findByNo(boardNo);

    if (board == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String str = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!str.equalsIgnoreCase("Y")) {
      System.out.println("삭제 취소했습니다.");
      return;
    }

    for (int i = this.indexOf(board) + 1; i < this.count; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--count] = null; // 레퍼런스 카운트를 줄인다.

    System.out.println("삭제했습니다.");
  }
}
