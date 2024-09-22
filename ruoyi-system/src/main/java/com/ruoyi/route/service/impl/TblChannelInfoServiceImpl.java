package com.ruoyi.route.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.route.mapper.TblChannelInfoMapper;
import com.ruoyi.route.domain.TblChannelInfo;
import com.ruoyi.route.service.ITblChannelInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 通道信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblChannelInfoServiceImpl implements ITblChannelInfoService 
{
    @Autowired
    private TblChannelInfoMapper tblChannelInfoMapper;

    /**
     * 查询通道信息
     * 
     * @param ciId 通道信息主键
     * @return 通道信息
     */
    @Override
    public TblChannelInfo selectTblChannelInfoByCiId(Long ciId)
    {
        return tblChannelInfoMapper.selectTblChannelInfoByCiId(ciId);
    }

    /**
     * 查询通道信息列表
     * 
     * @param tblChannelInfo 通道信息
     * @return 通道信息
     */
    @Override
    public List<TblChannelInfo> selectTblChannelInfoList(TblChannelInfo tblChannelInfo)
    {
        return tblChannelInfoMapper.selectTblChannelInfoList(tblChannelInfo);
    }

    /**
     * 新增通道信息
     * 
     * @param tblChannelInfo 通道信息
     * @return 结果
     */
    @Override
    public int insertTblChannelInfo(TblChannelInfo tblChannelInfo)
    {
        return tblChannelInfoMapper.insertTblChannelInfo(tblChannelInfo);
    }

    /**
     * 修改通道信息
     * 
     * @param tblChannelInfo 通道信息
     * @return 结果
     */
    @Override
    public int updateTblChannelInfo(TblChannelInfo tblChannelInfo)
    {
        return tblChannelInfoMapper.updateTblChannelInfo(tblChannelInfo);
    }

    /**
     * 批量删除通道信息
     * 
     * @param ciIds 需要删除的通道信息主键
     * @return 结果
     */
    @Override
    public int deleteTblChannelInfoByCiIds(String ciIds)
    {
        return tblChannelInfoMapper.deleteTblChannelInfoByCiIds(Convert.toStrArray(ciIds));
    }

    /**
     * 删除通道信息信息
     * 
     * @param ciId 通道信息主键
     * @return 结果
     */
    @Override
    public int deleteTblChannelInfoByCiId(Long ciId)
    {
        return tblChannelInfoMapper.deleteTblChannelInfoByCiId(ciId);
    }
}
