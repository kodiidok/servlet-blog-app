package bean;

import java.util.Date;
import java.util.List;

public class Post {

    private Integer id;
    private String title;
    private String content;
    private Date createdAt;
    private User author;
    private List<Comment> comments;
    private List<Tag> tags;

    public Post() {
        // Default constructor
    }

    public Post(Integer id, String title, String content, Date createdAt, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.author = author;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}



}

