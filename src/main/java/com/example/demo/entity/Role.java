@Entity
@Getter @Setter
public class Role {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String roleName;
private String description;
private Boolean active = true;
}