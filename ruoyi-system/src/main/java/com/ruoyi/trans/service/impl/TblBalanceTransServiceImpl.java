package com.ruoyi.trans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.trans.mapper.TblBalanceTransMapper;
import com.ruoyi.trans.domain.TblBalanceTrans;
import com.ruoyi.trans.service.ITblBalanceTransService;
import com.ruoyi.common.core.text.Convert;

/**
 * 余额变动Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblBalanceTransServiceImpl implements ITblBalanceTransService 
{
    @Autowired
    private TblBalanceTransMapper tblBalanceTransMapper;

    /**
     * 查询余额变动
     * 
     * @param btId 余额变动主键
     * @return 余额变动
     */
    @Override
    public TblBalanceTrans selectTblBalanceTransByBtId(Long btId)
    {
        return tblBalanceTransMapper.selectTblBalanceTransByBtId(btId);
    }

    /**
     * 查询余额变动列表
     * 
     * @param tblBalanceTrans 余额变动
     * @return 余额变动
     */
    @Override
    public List<TblBalanceTrans> selectTblBalanceTransList(TblBalanceTrans tblBalanceTrans)
    {
        return tblBalanceTransMapper.selectTblBalanceTransList(tblBalanceTrans);
    }

    /**
     * 新增余额变动
     * 
     * @param tblBalanceTrans 余额变动
     * @return 结果
     */
    @Override
    public int insertTblBalanceTrans(TblBalanceTrans tblBalanceTrans)
    {
        return tblBalanceTransMapper.insertTblBalanceTrans(tblBalanceTrans);
    }

    /**
     * 修改余额变动
     * 
     * @param tblBalanceTrans 余额变动
     * @return 结果
     */
    @Override
    public int updateTblBalanceTrans(TblBalanceTrans tblBalanceTrans)
    {
        return tblBalanceTransMapper.updateTblBalanceTrans(tblBalanceTrans);
    }

    /**
     * 批量删除余额变动
     * 
     * @param btIds 需要删除的余额变动主键
     * @return 结果
     */
    @Override
    public int deleteTblBalanceTransByBtIds(String btIds)
    {
        return tblBalanceTransMapper.deleteTblBalanceTransByBtIds(Convert.toStrArray(btIds));
    }

    /**
     * 删除余额变动信息
     * 
     * @param btId 余额变动主键
     * @return 结果
     */
    @Override
    public int deleteTblBalanceTransByBtId(Long btId)
    {
        return tblBalanceTransMapper.deleteTblBalanceTransByBtId(btId);
    }

    @Override
    public int insertTblBalanceTransByUserBalance(TblBalanceTrans tblBalanceTrans) {
        return tblBalanceTransMapper.insertTblBalanceTransByUserBalance(tblBalanceTrans);
    }
}
