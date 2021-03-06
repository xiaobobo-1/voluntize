package cn.ncepu.voluntize.controller.department;

import cn.ncepu.voluntize.controller.BaseController;
import cn.ncepu.voluntize.entity.Activity;
import cn.ncepu.voluntize.entity.Record;
import cn.ncepu.voluntize.service.ActivityService;
import cn.ncepu.voluntize.service.ParticipateService;
import cn.ncepu.voluntize.vo.ActivityVo;
import cn.ncepu.voluntize.vo.responseVo.RecordVo;
import cn.ncepu.voluntize.vo.responseVo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController("/departmentQuery")
public class DepartmentQuery extends BaseController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ParticipateService participateService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/released", method = RequestMethod.POST)
    public List<ActivityVo> getActivity() {
        if ("Department".equals(session.getAttribute("UserCategory"))) {
            ArrayList<ActivityVo> activityVos = new ArrayList<>();
            for (Activity activity : activityService.findDepartment((String) session.getAttribute("UserId")))
                activityVos.add(new ActivityVo(activity));
            return activityVos;
        } else return null;
    }

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    public List<RecordVo> getRecords(String periodId) {
        ArrayList<RecordVo> recordVos = new ArrayList<>();
        for (Record record : participateService.getRecord(periodId)) recordVos.add(new RecordVo(record));
        return recordVos;
    }

    @RequestMapping(value = "/studentInfo", method = RequestMethod.POST)
    public StudentVo getStudent(String studentId) {
        return new StudentVo(participateService.studentInfo(studentId));
    }
}
