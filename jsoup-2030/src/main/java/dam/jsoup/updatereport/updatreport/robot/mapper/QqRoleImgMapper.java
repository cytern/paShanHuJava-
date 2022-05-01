package dam.jsoup.updatereport.updatreport.robot.mapper;

import dam.jsoup.updatereport.updatreport.robot.dto.QqGroup;
import dam.jsoup.updatereport.updatreport.robot.dto.QqRoleImg;
import dam.jsoup.updatereport.updatreport.robot.dto.QqRotExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author 24771
* @description 针对表【qq_role_img】的数据库操作Mapper
* @createDate 2022-04-30 22:40:12
* @Entity dam.jsoup.updatereport.updatreport.robot.dto.QqRotExample.QqRoleImg
*/
@Repository
@Mapper
public interface QqRoleImgMapper {

    int deleteByPrimaryKey(Long id);

    int insert(QqRoleImg record);

    int insertSelective(QqRoleImg record);

    QqRoleImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QqRoleImg record);

    int updateByPrimaryKey(QqRoleImg record);

    QqGroup getGroupRole(String groupId);

    List<QqRoleImg> getAllRoleImage(String roleName);

}
