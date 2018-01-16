package com.bonc.test.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.bonc.test.domain.UserModel;

@Mapper
public interface UserMapper {
	List<UserModel> query();
	int deleteById(int userid);
	int updateById(UserModel user);
	int add(UserModel user);
	List<UserModel> queryById(int userid);
}
