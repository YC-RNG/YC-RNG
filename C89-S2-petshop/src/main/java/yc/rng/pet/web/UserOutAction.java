package yc.rng.pet.web;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yc.rng.pet.bean.Result;

@RestController
public class UserOutAction {

	@RequestMapping("out")
	public Result logout(HttpSession session) throws IOException {
		Object loginedUser = session.getAttribute("loginedUser");
		if(loginedUser == null) {
			return new Result(0,"你还未登录");
		}
		session.removeAttribute("loginedUser");
		return new Result(1,"成功退出");
	}
}
