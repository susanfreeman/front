package com.ruoyi.notify.cardApply.service;

import com.ruoyi.notify.cardApply.domain.TblNotifyCardApply;
import com.ruoyi.notify.trans.domain.TblNotifyTrans;

import java.util.List;

/**
 * 卡操作通知Service接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface ITblNotifyCardApplyService 
{
    /**
     * 查询卡操作通知
     * 
     * @param id 卡操作通知主键
     * @return 卡操作通知
     */
    public TblNotifyCardApply selectTblNotifyCardApplyById(Long id);

    /**
     * 查询卡操作通知列表
     * 
     * @param tblNotifyCardApply 卡操作通知
     * @return 卡操作通知集合
     */
    public List<TblNotifyCardApply> selectTblNotifyCardApplyList(TblNotifyCardApply tblNotifyCardApply);

    /**
     * 新增卡操作通知
     * 
     * @param tblNotifyCardApply 卡操作通知
     * @return 结果
     */
    public int insertTblNotifyCardApply(TblNotifyCardApply tblNotifyCardApply);

    /**
     * 修改卡操作通知
     * 
     * @param tblNotifyCardApply 卡操作通知
     * @return 结果
     */
    public int updateTblNotifyCardApply(TblNotifyCardApply tblNotifyCardApply);

    /**
     * 批量删除卡操作通知
     * 
     * @param ids 需要删除的卡操作通知主键集合
     * @return 结果
     */
    public int deleteTblNotifyCardApplyByIds(String ids);

    /**
     * 删除卡操作通知信息
     * 
     * @param id 卡操作通知主键
     * @return 结果
     */
    public int deleteTblNotifyCardApplyById(Long id);

    TblNotifyCardApply selectTblNotifyTransByTranId(Long ttId);
}
