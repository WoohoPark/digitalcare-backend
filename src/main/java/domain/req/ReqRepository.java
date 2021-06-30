package domain.req;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReqRepository extends JpaRepository<Req, Integer> {

}