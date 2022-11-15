/**
 * 
 */
package com.springblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author KKVIVEK
 *
 */

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@NotEmpty
	private String postTitle;

	@NotEmpty
	private String content;

	@NotEmpty
	private String imageName;

	private Date postDate;

	@ManyToOne
	@JoinColumn(name="category_Id")
	@JsonIgnore
	private Category category;

	@ManyToOne
	@JsonIgnore
	private User user;

}
