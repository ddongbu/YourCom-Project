package com.yourcom.project.project.controller;

import com.yourcom.project.project.entity.Board;
import com.yourcom.project.project.entity.MemberEntity;
import com.yourcom.project.project.repository.MemberRepository;
import com.yourcom.project.project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    //기본 홈페이지 요청 메서드

    @GetMapping("/board/write") //localhost:8080/board/write 로 접속하면 boardwrite를 열어라
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/boardwritepro")
    public String boardWritePro(HttpServletRequest request, Board board, Model model, MultipartFile file, Principal principal) throws Exception {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            boardService.write(board, file);
            model.addAttribute("message", "글 작성이 완료되었습니다.");
            model.addAttribute("searchUrl", "/board");
            return "message";
        } else if (session != null && session.getAttribute("loginName") != null) {

            boardService.write(board, file);
            model.addAttribute("message", "글 작성이 완료되었습니다.");
            model.addAttribute("searchUrl", "/board");
            return "message";
        } else {
            // User is not logged in, display login message
            model.addAttribute("message", "로그인을 해주세요");
            model.addAttribute("searchUrl", "/login");
            return "message";
        }
    }




    @GetMapping("/board")
    public String boardList(Model model, @PageableDefault(page = 0, size= 10 , sort = "id",direction = Sort.Direction.DESC ) Pageable pageable,
                           String seachKeyword ){

        Page<Board> list = null;

        if(seachKeyword == null) {
            list = boardService.boardlist(pageable);
        }else{
            list = boardService.boardSearchList(seachKeyword,pageable);
        }
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4 ,1);
        int endPage = Math.min(nowPage +5 , list.getTotalPages());

        model.addAttribute("list",list);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        //list라는 이름으로 보낼건데 거기에 boardlist메소드를 담아서 보낼거다.
        return "board";
    }
    //특정 게시글 불러오기
    @GetMapping("/board/view") //localhost:8080/board/view?id=1
    public String boardView(Model model,Integer id,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("board",boardService.boardView(id));
            return "boardview";
        } else if (session != null && session.getAttribute("loginName") != null) {
            model.addAttribute("board",boardService.boardView(id));
            return "boardview";
        } else {
            // User is not logged in, display login message
            model.addAttribute("message", "게시글을 볼 권한이 없습니다.");
            model.addAttribute("searchUrl", "/login");
            return "message";
        }
    }
    //특정 게시글 삭제
    @GetMapping("/board/delete")
    public String boardDelete(Integer id,Model model){

        boardService.boardDelete(id);
        model.addAttribute("message","글 삭제가 완료되었습니다.");
        model.addAttribute("searchUrl","/board");

        return "message";
    }

    //특정 게시글 추가
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                              Model model){

        model.addAttribute("board",boardService.boardView(id));

        return "boardmodify";
    }

    //특정 게시글 수정
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board,Model model,MultipartFile file,MemberEntity memberEntity) throws Exception{

        Board boardTemp = boardService.boardView(id);

        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());
        boardService.write(boardTemp,file);
        model.addAttribute("message","글 수정이 완료되었습니다.");
        model.addAttribute("searchUrl","/board");

        return "message";
    }



}