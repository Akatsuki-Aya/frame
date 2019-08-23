package cn.aya.controller;

import cn.aya.domain.Account;
import cn.aya.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层: 查询所有的账户信息...");
        // 调用service 方法
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list", accounts);
        return "list";
    }

    /**
     * 保存
     *
     * @param account
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account,HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层: 保存账户");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
