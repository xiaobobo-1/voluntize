package cn.ncepu.voluntize.repository;

import cn.ncepu.voluntize.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record,String> {

}
