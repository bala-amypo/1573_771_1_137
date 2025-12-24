@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String fullName;
    private boolean active = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ===== TEST NEEDS THIS =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public String getFullName() { return fullName; }

    // ===== TEST NEEDS THIS =====
    public boolean isActive() { return active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // ===== TEST CALLS THIS DIRECTLY =====
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // ===== TEST CALLS THIS DIRECTLY =====
    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
