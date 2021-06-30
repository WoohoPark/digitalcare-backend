package domain.member;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Modifying
    @Query(value = "UPDATE TB_MEMBER m SET m.memberYn = :memberYn WHERE teamId = :teamId AND userId = :userId", nativeQuery = true)
    void updateMemberYn(@Param("memberYn") Integer memberYn, @Param("teamId") Integer teamId, @Param("userId") Integer userId);

    @Modifying
    @Query(value = "UPDATE TB_MEMBER m SET m.leaderYn = :leaderYn WHERE teamId = :teamId AND userId = :userId", nativeQuery = true)
    void updateLeaderYn(@Param("leaderYn") Integer leaderYn, @Param("teamId") Integer teamId, @Param("userId") Integer userId);

    @Modifying
    @Query(value = "UPDATE TB_MEMBER m SET m.subLeaderYn = :subLeaderYn WHERE teamId = :teamId AND userId = :userId", nativeQuery = true)
    void updateSubLeaderYn(@Param("subLeaderYn") Integer subLeaderYn, @Param("teamId") Integer teamId, @Param("userId") Integer userId);


}