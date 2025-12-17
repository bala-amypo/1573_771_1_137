@Entity
@Getter @Setter
public class Permission {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String permissionKey;
private String description;
private Boolean active = true;
}