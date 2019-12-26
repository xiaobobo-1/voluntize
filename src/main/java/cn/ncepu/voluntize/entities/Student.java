package cn.ncepu.voluntize.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * <h2>学生实体类</h2>
 * 用于数据库关联查询，学生的部分数据从学校已有数据库导入
 *
 * @author Ge Hanchen
 * @since 0.0.1
 */
@Entity
@Data
public class Student {

    /**
     * 学号，唯一非空，外部导入，学生表主键
     */
    @Id
    private String studentNum;

    /**
     * 身份证号
     */
    private String idNum;

    /**
     * 密码，初始密码为身份证后六位
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 专业
     */
    private String major;

    /**
     * 年级
     */
    private String grade;

    /**
     * 该学生已报名，与ActivityPeriod是多对多关系
     */
    private ArrayList<ActivityPeriod> applied;

    /**
     * 志愿记录，和applied一样，与ActivityPeriod是多对多关系
     * 报名审核通过则计入志愿记录，但未必参加并录入时长
     */
    private ArrayList<ActivityPeriod> participated;

    /**
     * 头像
     */
    private Image profile;

    /**
     * 总时长
     */
    private int totalDuration;


}