package com.springblog.repositories;

import com.springblog.entity.Category;
import com.springblog.entity.Post;
import com.springblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
