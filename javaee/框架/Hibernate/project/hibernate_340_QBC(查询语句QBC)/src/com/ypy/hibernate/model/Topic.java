package com.ypy.hibernate.model;
import java.util.ArrayList;
/**
 * 每个版块下的主题类
 */
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(//可以在test中调用这里的查询语句。
		{
			@NamedQuery(name="topic.selectCertainTopic",query="from Topic t where t.id = :id")
		}
)
public class Topic {
	private int id;
	private String title;
	private Category category;
	private Date createDate;
	private List<Msg> msgs = new ArrayList<Msg>();
	@OneToMany(mappedBy="topic")
	public List<Msg> getMsgs() {
		
		return msgs;
	}
	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
