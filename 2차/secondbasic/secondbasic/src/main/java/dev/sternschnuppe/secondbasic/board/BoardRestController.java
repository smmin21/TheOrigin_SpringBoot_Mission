package dev.sternschnuppe.secondbasic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// @RequestMapping("/board")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final List<BoardDto> boardList;
    private final List<PostDto> postList;

    public BoardRestController(){
        this.boardList = new ArrayList<>();
        this.postList = new ArrayList<>();

    }

    // http://localhost:8080/post
    // POST / post
    // REQUEST_BODY

    // for expressing the status code more accurately,
    // add @ResponseStatus(HttpStatus.CREATED) under the Mapping annotation
    @PostMapping("/board")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatBoard(@RequestBody BoardDto boardDto){
        logger.info(boardDto.toString());
        this.boardList.add(boardDto);
    }

    // http://localhost:8080/post
    // GET / post

    @GetMapping("/board")
    public List<BoardDto> readBoardAll(){
        logger.info("in read board all");
        return this.boardList;
    }

    // GET /post/0/
    // GET /post?id=0

    @GetMapping("/board/{id}")
    public BoardDto readBoard(@PathVariable("id") int id){
        logger.info("in read board");
        return this.boardList.get(id);
    }

    // PUT /post/0/

    @PutMapping("/board/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto
    ){
        BoardDto targetPost = this.boardList.get(id);
        if (boardDto.getTitle() != null) {
            targetPost.setTitle(boardDto.getTitle());
        }
        this.boardList.set(id, targetPost);
    }

    // DELETE /post/0/

    @DeleteMapping("/board/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBoard(@PathVariable("id") int id){
        this.boardList.remove(id);
    }

    ///////////////////////////////////
    // Post
    ///////////////////////////////////
    @PostMapping("/board/{id}/post/")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatPost(
            @RequestBody PostDto postDto,
            @PathVariable("id") int id
    ){
        BoardDto targetBoard = this.boardList.get(id);
        postDto.setBoardDto(targetBoard);
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    @GetMapping("/board/post/{id}")
    public PostDto readPost(
            @PathVariable("id") int id
    ){
        logger.info("in read post");
        return this.postList.get(id);
    }

    @PutMapping("/board/post/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        PostDto targetPost = this.postList.get(id);
        if (postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targetPost);
    }

    @DeleteMapping("/board/post/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id,
            @RequestParam(name = "pw", defaultValue = "") String pw
    ){
        PostDto targetPost = this.postList.get(id);
        if (targetPost.getPw() != pw) {
            throw new RuntimeException("wrong pw!");
        }
        this.postList.remove(id);
    }
}
