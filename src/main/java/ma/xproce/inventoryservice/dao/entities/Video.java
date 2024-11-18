package ma.xproce.inventoryservice.dao.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String description;
    private String datePublication;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Creator creator;

}
