@Override
public String login(AuthRequestDto request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );

    UserDetails userDetails =
            userDetailsService.loadUserByUsername(request.getUsername());

    return jwtUtil.generateToken(userDetails);
}
