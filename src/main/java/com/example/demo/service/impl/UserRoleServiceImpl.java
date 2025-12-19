@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;

    public UserRoleServiceImpl(
            UserRoleRepository userRoleRepository,
            UserAccountRepository userAccountRepository,
            RoleRepository roleRepository
    ) {
        this.userRoleRepository = userRoleRepository;
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserRole assignRoleToUser(UserRole userRole) {

        Long userId = userRole.getUser().getId();
        Long roleId = userRole.getRole().getId();

        // ✅ Fetch managed entities
        UserAccount user = userAccountRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(
                        "User not found with id: " + userId));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NoSuchElementException(
                        "Role not found with id: " + roleId));

        // ✅ Prevent duplicate assignment
        userRoleRepository.findByUserIdAndRoleId(userId, roleId)
                .ifPresent(ur -> {
                    throw new IllegalStateException("Role already assigned to this user");
                });

        // ✅ Attach managed entities
        userRole.setUser(user);
        userRole.setRole(role);

        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("UserRole not found with id: " + id));
    }

    @Override
    public List<UserRole> getRolesByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public List<UserRole> getUsersByRoleId(Long roleId) {
        return userRoleRepository.findByRoleId(roleId);
    }

    @Override
    public void removeRoleFromUser(Long id) {
        if (!userRoleRepository.existsById(id)) {
            throw new NoSuchElementException("UserRole not found with id: " + id);
        }
        userRoleRepository.deleteById(id);
    }
}
