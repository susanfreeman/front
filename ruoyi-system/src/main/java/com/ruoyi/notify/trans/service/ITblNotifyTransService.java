package com.ruoyi.notify.trans.service;

import com.ruoyi.notify.trans.domain.TblNotifyTrans;

import java.util.List;

/**
 * 交易通知Service接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface ITblNotifyTransService 
{
    /**
     * 查询交易通知
     * 
     * @param id 交易通知主键
     * @return 交易通知
     */
    public TblNotifyTrans selectTblNotifyTransById(Long id);

    /**
     * 查询交易通知列表
     * 
     * @param tblNotifyTrans 交易通知
     * @return 交易通知集合
     */
    public List<TblNotifyTrans> selectTblNotifyTransList(TblNotifyTrans tblNotifyTrans);

    /**
     * 新增交易通知
     * 
     * @param tblNotifyTrans 交易通知
     * @return 结果
     */
    public int insertTblNotifyTrans(TblNotifyTrans tblNotifyTrans);

    /**
     * 修改交易通知
     * 
     * @param tblNotifyTrans 交易通知
     * @return 结果
     */
    public int updateTblNotifyTrans(TblNotifyTrans tblNotifyTrans);

    /**
     * 批量删除交易通知
     * 
     * @param ids 需要删除的交易通知主键集合
     * @return 结果
     */
    public int deleteTblNotifyTransByIds(String ids);

    /**
     * 删除交易通知信息
     * 
     * @param id 交易通知主键
     * @return 结果
     */
    public int deleteTblNotifyTransById(Long id);

    TblNotifyTrans selectTblNotifyTransByTranId(Long ttId);
}
