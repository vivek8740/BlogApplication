package com.springblog.payload;

import com.springblog.entity.Category;
import com.springblog.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date postDate;
    private User user;
    private Category category;
}

