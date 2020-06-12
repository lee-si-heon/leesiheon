package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.MemberDAO;
import com.example.vo.MemberVO;

@Controller
@RequestMapping(value="member")
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO = null; //MemberDAO mDAO = new MemberDAO()
	
	@RequestMapping(value = "/memberlist")
	public String memberlist(Model model) {
		List<MemberVO> list = mDAO.selectMemberList();
		/*
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getUserid());
		}
		for(MemberVO tmp : list) {
			System.out.println(tmp.getUserid());
		}
		*/
		model.addAttribute("name", "가나다");
		model.addAttribute("list", list); // hashmap<key, value> C -> V로 값전달
		return "memberlist";
	}
	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		//httpSession.setAttribute("SESSION_ID", null);
		httpSession.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginpost(@ModelAttribute MemberVO obj,
			HttpSession httpSession) {
		//DAO로 전달
		MemberVO obj1 = mDAO.selectMemberLogin(obj);
		if (obj1 != null) { //로그인 성공
			httpSession.setAttribute("SESSION_ID", obj.getUserid());
			return "redirect:/";
		}
		//로그인 실패/member/login Get방식으로 전송
		return "redirect:/member/login";
	}
		
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join"; // join.jsp를 표시하시오.
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinpost(@ModelAttribute MemberVO obj) {
		System.out.println(obj.toString());
		int ret = mDAO.insertMember(obj);
			
		if(ret > 0) {
			return "redirect";
		}
	
		
	
	//로그인 실패/member/login Get방식으로 전송
			return "redirect:/member/login";

	}
}