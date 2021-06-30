package domain.board.service;

import domain.board.Board;
import domain.board.BoardRepository;
import domain.board.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Integer save(BoardVO boardVO) {
        return boardRepository.save(boardVO.toEntity()).getSeq();
    }

    @Transactional
    public BoardVO get(int seq) {
        System.out.println("seq"+seq);
        Board board = boardRepository.findById(seq).orElseThrow(IllegalArgumentException::new);
        BoardVO boardVO = new BoardVO(board);
        return boardVO;
    }

    @Transactional
    public List<BoardVO> getList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardVO> boardList = new ArrayList<>();

        for (Board board : boards) {
            BoardVO vo = new BoardVO(board);
            boardList.add(vo);
        }

        return boardList;
    }
}
