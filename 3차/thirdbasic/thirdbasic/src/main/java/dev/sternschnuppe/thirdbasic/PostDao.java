package dev.sternschnuppe.thirdbasic;

import dev.sternschnuppe.thirdbasic.entity.PostEntity;
import dev.sternschnuppe.thirdbasic.entity.UserEntity;
import dev.sternschnuppe.thirdbasic.repository.PostRepository;
import dev.sternschnuppe.thirdbasic.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDao(
            @Autowired PostRepository postRepository,
            @Autowired UserRepository userRepository
    ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void createPost(PostDto dto){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        Optional<UserEntity> userEntity = this.userRepository.findById((long) dto.getUserId());
        postEntity.setUserEntity(userEntity.get());
        postEntity.setBoardEntity(null);
        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id){
        Optional<PostEntity> postEntity = this.postRepository.findById((long) id);
        if(postEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll(){
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDto dto){
        Optional<PostEntity> targetEntity = this.postRepository.findById(Long.valueOf(id));
        if (targetEntity.isEmpty()) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();

        postEntity.setTitle(
                dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle());
        postEntity.setContent(
                dto.getContent() == null ? postEntity.getContent() : dto.getContent());
        this.postRepository.save(postEntity);
    }

    public void deletePost(int id){
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }
}
