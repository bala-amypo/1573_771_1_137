@Entity
@Getter @Setter
public class UserAccount {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true, nullable = false)
private String email;
private String password;
private String fullName;
private Boolean active = true;
private Instant createdAt;
private Instant updatedAt;
@PrePersist void pre(){ createdAt = updatedAt = Instant.now(); }
@PreUpdate void upd(){ updatedAt = Instant.now(); }
}