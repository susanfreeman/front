package com.ruoyi.trans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.trans.mapper.TblTransMapper;
import com.ruoyi.trans.domain.TblTrans;
import com.ruoyi.trans.service.ITblTransService;
import com.ruoyi.common.core.text.Convert;

/**
 * 交易流水Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
@Service
public class TblTransServiceImpl implements ITblTransService 
{
    @Autowired
    private TblTransMapper tblTransMapper;

    /**
     * 查询交易流水
     * 
     * @param ttId 交易流水主键
     * @return 交易流水
     */
    @Override
    public TblTrans selectTblTransByTtId(Long ttId)
    {
        return tblTransMapper.selectTblTransByTtId(ttId);
    }

    /**
     * 查询交易流水列表
     * 
     * @param tblTrans 交易流水
     * @return 交易流水
     */
    @Override
    public List<TblTrans> selectTblTransList(TblTrans tblTrans)
    {
        return tblTransMapper.selectTblTransList(tblTrans);
    }

    /**
     * 新增交易流水
     * 
     * @param tblTrans 交易流水
     * @return 结果
     */
    @Override
    public int insertTblTrans(TblTrans tblTrans)
    {
        return tblTransMapper.insertTblTrans(tblTrans);
    }

    /**
     * 修改交易流水
     * 
     * @param tblTrans 交易流水
     * @return 结果
     */
    @Override
    public int updateTblTrans(TblTrans tblTrans)
    {
        return tblTransMapper.updateTblTrans(tblTrans);
    }

    /**
     * 批量删除交易流水
     * 
     * @param ttIds 需要删除的交易流水主键
     * @return 结果
     */
    @Override
    public int deleteTblTransByTtIds(String ttIds)
    {
        return tblTransMapper.deleteTblTransByTtIds(Convert.toStrArray(ttIds));
    }

    /**
     * 删除交易流水信息
     * 
     * @param ttId 交易流水主键
     * @return 结果
     */
    @Override
    public int deleteTblTransByTtId(Long ttId)
    {
        return tblTransMapper.deleteTblTransByTtId(ttId);
    }
}
