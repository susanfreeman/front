package com.ruoyi.route.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.route.mapper.TblRouteInfoMapper;
import com.ruoyi.route.domain.TblRouteInfo;
import com.ruoyi.route.service.ITblRouteInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 路由信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblRouteInfoServiceImpl implements ITblRouteInfoService 
{
    @Autowired
    private TblRouteInfoMapper tblRouteInfoMapper;

    /**
     * 查询路由信息
     * 
     * @param riId 路由信息主键
     * @return 路由信息
     */
    @Override
    public TblRouteInfo selectTblRouteInfoByRiId(Long riId)
    {
        return tblRouteInfoMapper.selectTblRouteInfoByRiId(riId);
    }

    /**
     * 查询路由信息列表
     * 
     * @param tblRouteInfo 路由信息
     * @return 路由信息
     */
    @Override
    public List<TblRouteInfo> selectTblRouteInfoList(TblRouteInfo tblRouteInfo)
    {
        return tblRouteInfoMapper.selectTblRouteInfoList(tblRouteInfo);
    }

    /**
     * 新增路由信息
     * 
     * @param tblRouteInfo 路由信息
     * @return 结果
     */
    @Override
    public int insertTblRouteInfo(TblRouteInfo tblRouteInfo)
    {
        return tblRouteInfoMapper.insertTblRouteInfo(tblRouteInfo);
    }

    /**
     * 修改路由信息
     * 
     * @param tblRouteInfo 路由信息
     * @return 结果
     */
    @Override
    public int updateTblRouteInfo(TblRouteInfo tblRouteInfo)
    {
        return tblRouteInfoMapper.updateTblRouteInfo(tblRouteInfo);
    }

    /**
     * 批量删除路由信息
     * 
     * @param riIds 需要删除的路由信息主键
     * @return 结果
     */
    @Override
    public int deleteTblRouteInfoByRiIds(String riIds)
    {
        return tblRouteInfoMapper.deleteTblRouteInfoByRiIds(Convert.toStrArray(riIds));
    }

    /**
     * 删除路由信息信息
     * 
     * @param riId 路由信息主键
     * @return 结果
     */
    @Override
    public int deleteTblRouteInfoByRiId(Long riId)
    {
        return tblRouteInfoMapper.deleteTblRouteInfoByRiId(riId);
    }
}
