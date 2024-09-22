package com.ruoyi.route.service;

import java.util.List;
import com.ruoyi.route.domain.TblRouteInfo;

/**
 * 路由信息Service接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface ITblRouteInfoService 
{
    /**
     * 查询路由信息
     * 
     * @param riId 路由信息主键
     * @return 路由信息
     */
    public TblRouteInfo selectTblRouteInfoByRiId(Long riId);

    /**
     * 查询路由信息列表
     * 
     * @param tblRouteInfo 路由信息
     * @return 路由信息集合
     */
    public List<TblRouteInfo> selectTblRouteInfoList(TblRouteInfo tblRouteInfo);

    /**
     * 新增路由信息
     * 
     * @param tblRouteInfo 路由信息
     * @return 结果
     */
    public int insertTblRouteInfo(TblRouteInfo tblRouteInfo);

    /**
     * 修改路由信息
     * 
     * @param tblRouteInfo 路由信息
     * @return 结果
     */
    public int updateTblRouteInfo(TblRouteInfo tblRouteInfo);

    /**
     * 批量删除路由信息
     * 
     * @param riIds 需要删除的路由信息主键集合
     * @return 结果
     */
    public int deleteTblRouteInfoByRiIds(String riIds);

    /**
     * 删除路由信息信息
     * 
     * @param riId 路由信息主键
     * @return 结果
     */
    public int deleteTblRouteInfoByRiId(Long riId);
}
