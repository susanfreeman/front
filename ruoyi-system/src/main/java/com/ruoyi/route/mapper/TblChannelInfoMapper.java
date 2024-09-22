package com.ruoyi.route.mapper;

import java.util.List;
import com.ruoyi.route.domain.TblChannelInfo;

/**
 * 通道信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface TblChannelInfoMapper 
{
    /**
     * 查询通道信息
     * 
     * @param ciId 通道信息主键
     * @return 通道信息
     */
    public TblChannelInfo selectTblChannelInfoByCiId(Long ciId);

    /**
     * 查询通道信息列表
     * 
     * @param tblChannelInfo 通道信息
     * @return 通道信息集合
     */
    public List<TblChannelInfo> selectTblChannelInfoList(TblChannelInfo tblChannelInfo);

    /**
     * 新增通道信息
     * 
     * @param tblChannelInfo 通道信息
     * @return 结果
     */
    public int insertTblChannelInfo(TblChannelInfo tblChannelInfo);

    /**
     * 修改通道信息
     * 
     * @param tblChannelInfo 通道信息
     * @return 结果
     */
    public int updateTblChannelInfo(TblChannelInfo tblChannelInfo);

    /**
     * 删除通道信息
     * 
     * @param ciId 通道信息主键
     * @return 结果
     */
    public int deleteTblChannelInfoByCiId(Long ciId);

    /**
     * 批量删除通道信息
     * 
     * @param ciIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblChannelInfoByCiIds(String[] ciIds);
}
