package com.ruoyi.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.user.mapper.TblUserChannelMappingMapper;
import com.ruoyi.user.domain.TblUserChannelMapping;
import com.ruoyi.user.service.ITblUserChannelMappingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户通道映射Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
@Service
public class TblUserChannelMappingServiceImpl implements ITblUserChannelMappingService 
{
    @Autowired
    private TblUserChannelMappingMapper tblUserChannelMappingMapper;

    /**
     * 查询用户通道映射
     * 
     * @param ucmId 用户通道映射主键
     * @return 用户通道映射
     */
    @Override
    public TblUserChannelMapping selectTblUserChannelMappingByUcmId(Long ucmId)
    {
        return tblUserChannelMappingMapper.selectTblUserChannelMappingByUcmId(ucmId);
    }

    /**
     * 查询用户通道映射列表
     * 
     * @param tblUserChannelMapping 用户通道映射
     * @return 用户通道映射
     */
    @Override
    public List<TblUserChannelMapping> selectTblUserChannelMappingList(TblUserChannelMapping tblUserChannelMapping)
    {
        return tblUserChannelMappingMapper.selectTblUserChannelMappingList(tblUserChannelMapping);
    }

    /**
     * 新增用户通道映射
     * 
     * @param tblUserChannelMapping 用户通道映射
     * @return 结果
     */
    @Override
    public int insertTblUserChannelMapping(TblUserChannelMapping tblUserChannelMapping)
    {
        return tblUserChannelMappingMapper.insertTblUserChannelMapping(tblUserChannelMapping);
    }

    /**
     * 修改用户通道映射
     * 
     * @param tblUserChannelMapping 用户通道映射
     * @return 结果
     */
    @Override
    public int updateTblUserChannelMapping(TblUserChannelMapping tblUserChannelMapping)
    {
        return tblUserChannelMappingMapper.updateTblUserChannelMapping(tblUserChannelMapping);
    }

    /**
     * 批量删除用户通道映射
     * 
     * @param ucmIds 需要删除的用户通道映射主键
     * @return 结果
     */
    @Override
    public int deleteTblUserChannelMappingByUcmIds(String ucmIds)
    {
        return tblUserChannelMappingMapper.deleteTblUserChannelMappingByUcmIds(Convert.toStrArray(ucmIds));
    }

    /**
     * 删除用户通道映射信息
     * 
     * @param ucmId 用户通道映射主键
     * @return 结果
     */
    @Override
    public int deleteTblUserChannelMappingByUcmId(Long ucmId)
    {
        return tblUserChannelMappingMapper.deleteTblUserChannelMappingByUcmId(ucmId);
    }
}
