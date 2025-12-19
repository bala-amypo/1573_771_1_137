@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole assignRoleToUser(UserRole userRole) {

        if (userRole.getUser() == null || userRole.getUser().getId() == null) {
            throw new IllegalArgumentException("User ID is required");
        }

        if (userRole.getRole() == null || userRole.getRole().getId() == null) {
            throw new IllegalArgumentException("Role ID is required");
        }

        Long userId = userRole.getUser().getId();
        Long roleId = userRole.getRole().getId();

        userRoleRepository.findByUserIdAndRoleId(userId, roleId)
                .ifPresent(ur -> {
                    throw new IllegalStateException("Role already assigned to this user");
                });

        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("UserRole not found with id: " + id));
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
            throw new RuntimeException("UserRole not found with id: " + id);
        }
        userRoleRepository.deleteById(id);
    }
}
