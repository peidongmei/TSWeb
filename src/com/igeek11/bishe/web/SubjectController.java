package com.igeek11.bishe.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igeek11.bishe.bean.Subject;
import com.igeek11.bishe.biz.ISubjectBiz;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
private ISubjectBiz  subjectBiz;
	@RequestMapping(value="/subjectDisplayList")
	public String subjectDisplay(Subject subject, HttpServletRequest req) {
		String resp = null;
		List<Subject> subjects = subjectBiz.subjectDisplayList(subject);
		req.setAttribute("subject", subjects);
		resp = "/smallJsp/subjectDisplayList.jsp";
		return resp;
	}
}
