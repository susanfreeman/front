package com.ruoyi.agent.service.impl;

import java.util.List;

import com.ruoyi.agent.domain.TblAgentProfitRecord;
import com.ruoyi.agent.mapper.TblAgentProfitRecordMapper;
import com.ruoyi.agent.service.ITblAgentProfitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 代理商分润Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-19
 */
@Service
public class TblAgentProfitRecordServiceImpl implements ITblAgentProfitRecordService
{
    @Autowired
    private TblAgentProfitRecordMapper tblAgentProfitRecordMapper;

    /**
     * 查询代理商分润
     * 
     * @param id 代理商分润主键
     * @return 代理商分润
     */
    @Override
    public TblAgentProfitRecord selectTblAgentProfitRecordById(Long id)
    {
        return tblAgentProfitRecordMapper.selectTblAgentProfitRecordById(id);
    }

    /**
     * 查询代理商分润列表
     * 
     * @param tblAgentProfitRecord 代理商分润
     * @return 代理商分润
     */
    @Override
    public List<TblAgentProfitRecord> selectTblAgentProfitRecordList(TblAgentProfitRecord tblAgentProfitRecord)
    {
        return tblAgentProfitRecordMapper.selectTblAgentProfitRecordList(tblAgentProfitRecord);
    }

    /**
     * 新增代理商分润
     * 
     * @param tblAgentProfitRecord 代理商分润
     * @return 结果
     */
    @Override
    public int insertTblAgentProfitRecord(TblAgentProfitRecord tblAgentProfitRecord)
    {
        return tblAgentProfitRecordMapper.insertTblAgentProfitRecord(tblAgentProfitRecord);
    }

    /**
     * 修改代理商分润
     * 
     * @param tblAgentProfitRecord 代理商分润
     * @return 结果
     */
    @Override
    public int updateTblAgentProfitRecord(TblAgentProfitRecord tblAgentProfitRecord)
    {
        return tblAgentProfitRecordMapper.updateTblAgentProfitRecord(tblAgentProfitRecord);
    }

    /**
     * 批量删除代理商分润
     * 
     * @param ids 需要删除的代理商分润主键
     * @return 结果
     */
    @Override
    public int deleteTblAgentProfitRecordByIds(String ids)
    {
        return tblAgentProfitRecordMapper.deleteTblAgentProfitRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代理商分润信息
     * 
     * @param id 代理商分润主键
     * @return 结果
     */
    @Override
    public int deleteTblAgentProfitRecordById(Long id)
    {
        return tblAgentProfitRecordMapper.deleteTblAgentProfitRecordById(id);
    }
}
