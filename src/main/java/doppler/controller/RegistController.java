package doppler.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import doppler.domain.User;
import doppler.service.UserService;
import doppler.util.DateUtil;

@Controller
public class RegistController {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String registForm() {

		return "registPage";
	}

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public String registUser(User user) {
		user.setRegistTime(DateUtil.getInstance().getDate());
		userService.save(user);
		return "loginPage";
	}

	@RequestMapping(value = "/checkUniqueLoginName", method = { RequestMethod.GET })
	void checkUniqueLoginName(@RequestParam("loginName") String loginName_arg, HttpServletResponse response) {
		String loginName = userService.getLoginName(loginName_arg);
		if (loginName != null) {
			renderData("1", response);
		} else {
			renderData("0", response);
		}
	}

	public void renderData(String result, HttpServletResponse response) {
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(result);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

	}

}
