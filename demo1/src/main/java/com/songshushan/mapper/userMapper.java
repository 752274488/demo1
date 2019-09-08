package com.songshushan.mapper;

import com.songshushan.domain.UserVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface userMapper {
    @Select("SELECT * FROM tab_user")
    public  List<UserVO> getAll() ;
}
