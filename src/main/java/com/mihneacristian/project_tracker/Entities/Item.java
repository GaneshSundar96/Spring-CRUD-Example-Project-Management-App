package com.mihneacristian.project_tracker.Entities;

import com.mihneacristian.project_tracker.DTO.ItemDTO;
import com.mihneacristian.project_tracker.DTO.ProjectDTO;
import org.hibernate.Hibernate;
import org.springframework.data.geo.Polygon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    Integer itemId;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    Status statusOfItem;

    @ManyToOne
    @JoinColumn(name = "type_Id")
    Type typeOfItem;

    @OneToMany(mappedBy = "itemIdForThisComment", cascade = CascadeType.ALL)
    List<Comment> comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    TeamMembers teamMemberOfItem;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatusOfItem() {
        return statusOfItem;
    }

    public void setStatusOfItem(Status statusOfItem) {
        this.statusOfItem = statusOfItem;
    }

    public Type getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(Type typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public TeamMembers getTeamMemberOfItem() {
        return teamMemberOfItem;
    }

    public void setTeamMemberOfItem(TeamMembers teamMemberOfItem) {
        this.teamMemberOfItem = teamMemberOfItem;
    }

    public Item() {
    }

    public Item(ItemDTO itemDTO) {

        this.title = itemDTO.title;
        this.description = itemDTO.description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", statusId=" + statusOfItem +
                ", typeId=" + typeOfItem +
                '}';
    }
}
