package dev.sternschnuppe.secondbasic.board;

public class BoardDto {
    private String title;

    public BoardDto() {
    }

    public BoardDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "title='" + title + '\'' +
                '}';
    }
}
