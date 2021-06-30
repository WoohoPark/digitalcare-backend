package domain.review;

import domain.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    /*
    리뷰 등록
     */
    @PostMapping("/insert")
    public Integer reviewInsert(@RequestBody ReviewVO vo) throws Exception {
        return reviewService.save(vo);
    }

    /*
    리뷰 목록
     */
    @GetMapping("/list")
    public List<ReviewVO> reviewList(int teamId) throws Exception {
        return reviewService.getList(teamId);
    }

}
