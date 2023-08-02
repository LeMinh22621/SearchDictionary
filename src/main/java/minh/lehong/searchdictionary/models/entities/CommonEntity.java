package minh.lehong.searchdictionary.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public abstract class CommonEntity {
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "updated_date")
    private Date updatedDate;
}
