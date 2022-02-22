package dev.sternschnuppe.secondbasic.board;

public class PostDto {
    private String title;
    private String content;
    private String writer;
    private String pw;
    private BoardDto boardDto;

    public PostDto() {
    }

    public PostDto(String title, String content, String writer, String pw, BoardDto boardDto) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.pw = pw;
        this.boardDto = boardDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public BoardDto getBoardDto() {
        return boardDto;
    }

    public void setBoardDto(BoardDto boardDto) {
        this.boardDto = boardDto;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pw='" + pw + '\'' +
                ", boardDto=" + boardDto +
                '}';
    }
}
