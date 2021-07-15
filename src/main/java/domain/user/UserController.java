package domain.user;

import domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping( "/hello")
    public void hello() throws Exception{
        System.out.println("##############push start################");
        System.out.println("##############push close################");
    }

    @PostMapping("/join")
    public void userInsert(@RequestBody UserVO boardVO) throws Exception{
        //return boardService.save(boardVO);
    }

    @PostMapping("/out")
    public void userDelete(@RequestBody UserVO boardVO) throws Exception{
        //return boardService.save(boardVO);

    }

    @PostMapping("/update")
    public void userUpdate(@RequestBody UserVO boardVO) throws Exception{
        //return boardService.save(boardVO);
    }

    @PostMapping("/info")
    public void userInfo(@RequestBody UserVO boardVO) throws Exception{
        //return boardService.save(boardVO);
    }

}
