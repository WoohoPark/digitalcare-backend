package domain.board;

import domain.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/insert")
    public Integer boardInsert(@RequestBody BoardVO boardVO) {
        return boardService.save(boardVO);
    }

    @GetMapping("/get")
    public BoardVO boardGet(int seq) {
        return boardService.get(seq);
    }

    @GetMapping("/list")
    public List<BoardVO> boardList() {
        return boardService.getList();
    }
}
