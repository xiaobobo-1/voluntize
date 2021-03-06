package cn.ncepu.voluntize.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * <h2>志愿岗位实体类</h2>
 * 认为岗位的地点是固定的
 *
 * @author Ge Hanchen
 * @since 0.0.1
 */
@Data
@Entity
@Table(name = "activity_station")
@ToString(exclude = {"parentActivity", "periods"})
@JsonIgnoreProperties({"parentActivity", "periods"})
public class ActivityStation {
    /**
     * 唯一标识id，类型String，主键生成策略：uuid2
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "station_name")
    private String name;

    @Basic
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Basic
    @Column(name="linkman",columnDefinition = "varchar(255) comment '联系人，每个地点的联系人不一定一样'")
    private String linkman;

    @Basic
    @Column(name="phone_num",columnDefinition = "varchar(255) comment '联系人电话'")
    private String phoneNum;

    /**
     * 所属志愿活动
     */
    @ManyToOne(targetEntity = Activity.class)
    @JoinColumn(name = "parent_activity", referencedColumnName = "id")
    private Activity parentActivity;

    /**
     * 划分为多个时间段
     */
    @OneToMany(targetEntity = ActivityPeriod.class, mappedBy = "parent")
    private List<ActivityPeriod> periods;
}
