package com.xc.crowdfunding.manager.dao;

import com.xc.crowdfunding.bean.ProjectType;
import java.util.List;

public interface ProjectTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectType record);

    ProjectType selectByPrimaryKey(Integer id);

    List<ProjectType> selectAll();

    int updateByPrimaryKey(ProjectType record);
}