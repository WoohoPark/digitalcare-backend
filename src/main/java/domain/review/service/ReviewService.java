package domain.review.service;

import domain.review.Review;
import domain.review.ReviewRepository;
import domain.review.ReviewVO;
import domain.review.specification.ReviewSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional
    public Integer save(ReviewVO vo) {
        return reviewRepository.save(vo.toEntity()).getTeamId();
    }

    @Transactional
    public List<ReviewVO> getList(@RequestParam int teamId) {

        List<Review> reviews = reviewRepository.findAll(ReviewSpecification.equalTodoId(teamId));
        List<ReviewVO> reviewList = new ArrayList<>();

        for (Review review : reviews) {
            ReviewVO vo = new ReviewVO(review);
            reviewList.add(vo);
        }

        return reviewList;
    }

    @Transactional
    public ReviewVO getInfo(int reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(IllegalArgumentException::new);
        ReviewVO vo = new ReviewVO(review);
        return vo;
    }

}
