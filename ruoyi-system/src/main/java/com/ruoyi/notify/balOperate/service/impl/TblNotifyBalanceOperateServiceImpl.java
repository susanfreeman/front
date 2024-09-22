package com.ruoyi.notify.balOperate.service.impl;

import java.util.List;

import com.ruoyi.notify.balOperate.domain.TblNotifyBalanceOperate;
import com.ruoyi.notify.balOperate.mapper.TblNotifyBalanceOperateMapper;
import com.ruoyi.notify.balOperate.service.ITblNotifyBalanceOperateService;
import com.ruoyi.notify.cardApply.domain.TblNotifyCardApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 资金变动通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class TblNotifyBalanceOperateServiceImpl implements ITblNotifyBalanceOperateService
{
    @Autowired
    private TblNotifyBalanceOperateMapper tblNotifyBalanceOperateMapper;

    /**
     * 查询资金变动通知
     * 
     * @param id 资金变动通知主键
     * @return 资金变动通知
     */
    @Override
    public TblNotifyBalanceOperate selectTblNotifyBalanceOperateById(Long id)
    {
        return tblNotifyBalanceOperateMapper.selectTblNotifyBalanceOperateById(id);
    }

    /**
     * 查询资金变动通知列表
     * 
     * @param tblNotifyBalanceOperate 资金变动通知
     * @return 资金变动通知
     */
    @Override
    public List<TblNotifyBalanceOperate> selectTblNotifyBalanceOperateList(TblNotifyBalanceOperate tblNotifyBalanceOperate)
    {
        return tblNotifyBalanceOperateMapper.selectTblNotifyBalanceOperateList(tblNotifyBalanceOperate);
    }

    /**
     * 新增资金变动通知
     * 
     * @param tblNotifyBalanceOperate 资金变动通知
     * @return 结果
     */
    @Override
    public int insertTblNotifyBalanceOperate(TblNotifyBalanceOperate tblNotifyBalanceOperate)
    {
        return tblNotifyBalanceOperateMapper.insertTblNotifyBalanceOperate(tblNotifyBalanceOperate);
    }

    /**
     * 修改资金变动通知
     * 
     * @param tblNotifyBalanceOperate 资金变动通知
     * @return 结果
     */
    @Override
    public int updateTblNotifyBalanceOperate(TblNotifyBalanceOperate tblNotifyBalanceOperate)
    {
        return tblNotifyBalanceOperateMapper.updateTblNotifyBalanceOperate(tblNotifyBalanceOperate);
    }

    /**
     * 批量删除资金变动通知
     * 
     * @param ids 需要删除的资金变动通知主键
     * @return 结果
     */
    @Override
    public int deleteTblNotifyBalanceOperateByIds(String ids)
    {
        return tblNotifyBalanceOperateMapper.deleteTblNotifyBalanceOperateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资金变动通知信息
     * 
     * @param id 资金变动通知主键
     * @return 结果
     */
    @Override
    public int deleteTblNotifyBalanceOperateById(Long id)
    {
        return tblNotifyBalanceOperateMapper.deleteTblNotifyBalanceOperateById(id);
    }

    @Override
    public TblNotifyBalanceOperate selectTblNotifyBalanceOperateByTranId(Long ttId) {
        return tblNotifyBalanceOperateMapper.selectTblNotifyBalanceOperateByTranId(ttId);
    }
}
