package com.ruoyi.coin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coin.mapper.TblRechargeTransMapper;
import com.ruoyi.coin.domain.TblRechargeTrans;
import com.ruoyi.coin.service.ITblRechargeTransService;
import com.ruoyi.common.core.text.Convert;

/**
 * 充值记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-01
 */
@Service
public class TblRechargeTransServiceImpl implements ITblRechargeTransService 
{
    @Autowired
    private TblRechargeTransMapper tblRechargeTransMapper;

    /**
     * 查询充值记录
     * 
     * @param rtId 充值记录主键
     * @return 充值记录
     */
    @Override
    public TblRechargeTrans selectTblRechargeTransByRtId(Long rtId)
    {
        return tblRechargeTransMapper.selectTblRechargeTransByRtId(rtId);
    }

    /**
     * 查询充值记录列表
     * 
     * @param tblRechargeTrans 充值记录
     * @return 充值记录
     */
    @Override
    public List<TblRechargeTrans> selectTblRechargeTransList(TblRechargeTrans tblRechargeTrans)
    {
        return tblRechargeTransMapper.selectTblRechargeTransList(tblRechargeTrans);
    }

    /**
     * 新增充值记录
     * 
     * @param tblRechargeTrans 充值记录
     * @return 结果
     */
    @Override
    public int insertTblRechargeTrans(TblRechargeTrans tblRechargeTrans)
    {
        return tblRechargeTransMapper.insertTblRechargeTrans(tblRechargeTrans);
    }

    /**
     * 修改充值记录
     * 
     * @param tblRechargeTrans 充值记录
     * @return 结果
     */
    @Override
    public int updateTblRechargeTrans(TblRechargeTrans tblRechargeTrans)
    {
        return tblRechargeTransMapper.updateTblRechargeTrans(tblRechargeTrans);
    }

    /**
     * 批量删除充值记录
     * 
     * @param rtIds 需要删除的充值记录主键
     * @return 结果
     */
    @Override
    public int deleteTblRechargeTransByRtIds(String rtIds)
    {
        return tblRechargeTransMapper.deleteTblRechargeTransByRtIds(Convert.toStrArray(rtIds));
    }

    /**
     * 删除充值记录信息
     * 
     * @param rtId 充值记录主键
     * @return 结果
     */
    @Override
    public int deleteTblRechargeTransByRtId(Long rtId)
    {
        return tblRechargeTransMapper.deleteTblRechargeTransByRtId(rtId);
    }
}
