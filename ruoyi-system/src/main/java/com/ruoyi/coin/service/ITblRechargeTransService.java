package com.ruoyi.coin.service;

import java.util.List;
import com.ruoyi.coin.domain.TblRechargeTrans;

/**
 * 充值记录Service接口
 * 
 * @author ruoyi
 * @date 2024-08-01
 */
public interface ITblRechargeTransService 
{
    /**
     * 查询充值记录
     * 
     * @param rtId 充值记录主键
     * @return 充值记录
     */
    public TblRechargeTrans selectTblRechargeTransByRtId(Long rtId);

    /**
     * 查询充值记录列表
     * 
     * @param tblRechargeTrans 充值记录
     * @return 充值记录集合
     */
    public List<TblRechargeTrans> selectTblRechargeTransList(TblRechargeTrans tblRechargeTrans);

    /**
     * 新增充值记录
     * 
     * @param tblRechargeTrans 充值记录
     * @return 结果
     */
    public int insertTblRechargeTrans(TblRechargeTrans tblRechargeTrans);

    /**
     * 修改充值记录
     * 
     * @param tblRechargeTrans 充值记录
     * @return 结果
     */
    public int updateTblRechargeTrans(TblRechargeTrans tblRechargeTrans);

    /**
     * 批量删除充值记录
     * 
     * @param rtIds 需要删除的充值记录主键集合
     * @return 结果
     */
    public int deleteTblRechargeTransByRtIds(String rtIds);

    /**
     * 删除充值记录信息
     * 
     * @param rtId 充值记录主键
     * @return 结果
     */
    public int deleteTblRechargeTransByRtId(Long rtId);
}
