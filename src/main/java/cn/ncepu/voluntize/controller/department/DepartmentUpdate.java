package cn.ncepu.voluntize.controller.department;

import cn.ncepu.voluntize.controller.BaseController;
import cn.ncepu.voluntize.service.PasswordService;
import cn.ncepu.voluntize.service.UpdateUserService;
import cn.ncepu.voluntize.vo.responseVo.HttpResult;
import cn.ncepu.voluntize.vo.requestVo.DepartmentUpdateVo;
import cn.ncepu.voluntize.vo.requestVo.StudentUpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("departmentUpdate")
public class DepartmentUpdate extends BaseController {
    @Autowired
    UpdateUserService updateUserService;

    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult updateDepartment(DepartmentUpdateVo departmentUpdateVo){
        if(updateUserService.updateDepartment(departmentUpdateVo)) return new HttpResult("updateResult:success");
        else return new HttpResult("updateResult:error");
    }
}
