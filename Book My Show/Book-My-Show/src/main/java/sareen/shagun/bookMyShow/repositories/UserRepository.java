package sareen.shagun.bookMyShow.repositories;

import sareen.shagun.bookMyShow.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long userId);
}
