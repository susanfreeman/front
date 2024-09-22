package com.ruoyi.user.service;

import java.util.List;
import com.ruoyi.user.domain.TblUserChannelMapping;

/**
 * 用户通道映射Service接口
 * 
 * @author ruoyi
 * @date 2024-07-21
 */
public interface ITblUserChannelMappingService 
{
    /**
     * 查询用户通道映射
     * 
     * @param ucmId 用户通道映射主键
     * @return 用户通道映射
     */
    public TblUserChannelMapping selectTblUserChannelMappingByUcmId(Long ucmId);

    /**
     * 查询用户通道映射列表
     * 
     * @param tblUserChannelMapping 用户通道映射
     * @return 用户通道映射集合
     */
    public List<TblUserChannelMapping> selectTblUserChannelMappingList(TblUserChannelMapping tblUserChannelMapping);

    /**
     * 新增用户通道映射
     * 
     * @param tblUserChannelMapping 用户通道映射
     * @return 结果
     */
    public int insertTblUserChannelMapping(TblUserChannelMapping tblUserChannelMapping);

    /**
     * 修改用户通道映射
     * 
     * @param tblUserChannelMapping 用户通道映射
     * @return 结果
     */
    public int updateTblUserChannelMapping(TblUserChannelMapping tblUserChannelMapping);

    /**
     * 批量删除用户通道映射
     * 
     * @param ucmIds 需要删除的用户通道映射主键集合
     * @return 结果
     */
    public int deleteTblUserChannelMappingByUcmIds(String ucmIds);

    /**
     * 删除用户通道映射信息
     * 
     * @param ucmId 用户通道映射主键
     * @return 结果
     */
    public int deleteTblUserChannelMappingByUcmId(Long ucmId);
}
