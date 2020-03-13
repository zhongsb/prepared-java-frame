package com.prepared.service.modules.system.controller;


import com.prepared.service.common.utils.Result;
import com.prepared.service.common.utils.TokenClaims;
import com.prepared.service.modules.system.service.UserService;
import com.prepared.service.common.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录授权
 *
 * @author z
 * @date 2019/12/21
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/system")
@Api(tags = {"用户登录接口"})
public class UserLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation("登录")
    public Result login(@RequestParam(value = "userName", required = false) @ApiParam("用户名称") String userName,
                        @RequestParam(value = "password", required = false) @ApiParam("密码") String password){
        TokenClaims claims = null;
        // 用户名、密码验证
        if(userService.isValidPassword(userName, password)) {
            String userId = userService.getUserIdByUserName(userName);
            claims = new TokenClaims(userId, new Date());
            String token = jwtUtils.generateToken(claims);
            Map<String, Object> map = new HashMap<>();
            // 隐藏username
            map.put("token", token);
            map.put("expire", jwtUtils.getExpire());
            return Result.getSuccessResult(map);
        }
        return Result.getErrorResult("登录失败");
    }

}
