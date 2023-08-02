package minh.lehong.searchdictionary.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "word")
public class WordEntity extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "term")
    private String term;
    @Column(name = "types")
    private String types;
    @Lob
    @Column(name = "meaning")
    private String meaning;
}
