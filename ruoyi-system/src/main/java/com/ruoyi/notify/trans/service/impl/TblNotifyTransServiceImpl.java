package com.ruoyi.notify.trans.service.impl;

import java.util.List;

import com.ruoyi.notify.trans.domain.TblNotifyTrans;
import com.ruoyi.notify.trans.mapper.TblNotifyTransMapper;
import com.ruoyi.notify.trans.service.ITblNotifyTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 交易通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
@Service
public class TblNotifyTransServiceImpl implements ITblNotifyTransService
{
    @Autowired
    private TblNotifyTransMapper tblNotifyTransMapper;

    /**
     * 查询交易通知
     * 
     * @param id 交易通知主键
     * @return 交易通知
     */
    @Override
    public TblNotifyTrans selectTblNotifyTransById(Long id)
    {
        return tblNotifyTransMapper.selectTblNotifyTransById(id);
    }

    /**
     * 查询交易通知列表
     * 
     * @param tblNotifyTrans 交易通知
     * @return 交易通知
     */
    @Override
    public List<TblNotifyTrans> selectTblNotifyTransList(TblNotifyTrans tblNotifyTrans)
    {
        return tblNotifyTransMapper.selectTblNotifyTransList(tblNotifyTrans);
    }

    /**
     * 新增交易通知
     * 
     * @param tblNotifyTrans 交易通知
     * @return 结果
     */
    @Override
    public int insertTblNotifyTrans(TblNotifyTrans tblNotifyTrans)
    {
        return tblNotifyTransMapper.insertTblNotifyTrans(tblNotifyTrans);
    }

    /**
     * 修改交易通知
     * 
     * @param tblNotifyTrans 交易通知
     * @return 结果
     */
    @Override
    public int updateTblNotifyTrans(TblNotifyTrans tblNotifyTrans)
    {
        return tblNotifyTransMapper.updateTblNotifyTrans(tblNotifyTrans);
    }

    /**
     * 批量删除交易通知
     * 
     * @param ids 需要删除的交易通知主键
     * @return 结果
     */
    @Override
    public int deleteTblNotifyTransByIds(String ids)
    {
        return tblNotifyTransMapper.deleteTblNotifyTransByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除交易通知信息
     * 
     * @param id 交易通知主键
     * @return 结果
     */
    @Override
    public int deleteTblNotifyTransById(Long id)
    {
        return tblNotifyTransMapper.deleteTblNotifyTransById(id);
    }

    @Override
    public TblNotifyTrans selectTblNotifyTransByTranId(Long ttId) {
        return tblNotifyTransMapper.selectTblNotifyTransByTranId(ttId);
    }
}
