package com.ruoyi.notify.balOperate.mapper;

import com.ruoyi.notify.balOperate.domain.TblNotifyBalanceOperate;
import com.ruoyi.notify.cardApply.domain.TblNotifyCardApply;

import java.util.List;

/**
 * 资金变动通知Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public interface TblNotifyBalanceOperateMapper 
{
    /**
     * 查询资金变动通知
     * 
     * @param id 资金变动通知主键
     * @return 资金变动通知
     */
    public TblNotifyBalanceOperate selectTblNotifyBalanceOperateById(Long id);

    /**
     * 查询资金变动通知列表
     * 
     * @param tblNotifyBalanceOperate 资金变动通知
     * @return 资金变动通知集合
     */
    public List<TblNotifyBalanceOperate> selectTblNotifyBalanceOperateList(TblNotifyBalanceOperate tblNotifyBalanceOperate);

    /**
     * 新增资金变动通知
     * 
     * @param tblNotifyBalanceOperate 资金变动通知
     * @return 结果
     */
    public int insertTblNotifyBalanceOperate(TblNotifyBalanceOperate tblNotifyBalanceOperate);

    /**
     * 修改资金变动通知
     * 
     * @param tblNotifyBalanceOperate 资金变动通知
     * @return 结果
     */
    public int updateTblNotifyBalanceOperate(TblNotifyBalanceOperate tblNotifyBalanceOperate);

    /**
     * 删除资金变动通知
     * 
     * @param id 资金变动通知主键
     * @return 结果
     */
    public int deleteTblNotifyBalanceOperateById(Long id);

    /**
     * 批量删除资金变动通知
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblNotifyBalanceOperateByIds(String[] ids);

    TblNotifyBalanceOperate selectTblNotifyBalanceOperateByTranId(Long ttId);
}
