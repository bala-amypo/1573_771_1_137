@Entity
@Getter @Setter
public class RolePermission {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne private Role role;
@ManyToOne private Permission permission;
private Instant grantedAt;
@PrePersist void pre(){ grantedAt = Instant.now(); }
}