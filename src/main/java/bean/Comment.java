package bean;

import java.util.Date;

public class Comment {

    private Integer id;
    private String text;
    private Date createdAt;
    private User author;
    private Post post;

    public Comment() {
        // Default constructor
    }

    // Constructor
    public Comment(Integer id, String text, Date createdAt, User author, Post post) {
        this.id = id;
        this.text = text;
        this.createdAt = new Date();
        this.author = author;
        this.post = post;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

    

}
