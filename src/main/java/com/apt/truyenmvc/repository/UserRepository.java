package com.apt.truyenmvc.repository;

import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopConverter;
import com.apt.truyenmvc.utils.ConstansQueryUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Huy Thang
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUName(String username);

    public User findByUID(Long uID);

    public Page<User> findByUStatus(Integer status, Pageable pageable);

    @Query(value = ConstansQueryUtils.TOP_CONVERTER,
            countQuery = ConstansQueryUtils.COUNT_TOP_CONVERTER,
            nativeQuery = true)
    public Page<TopConverter> getTopConverter(@Param("chStatus") Integer chStatus,
                                              @Param("uStatus") Integer uStatus, Pageable pageable);

    public boolean existsUserByUEmail(String uEmail);

    public boolean existsUserByUName(String uName);

    public User findByUNameAndUEmail(String uName, String uEmail);
}
