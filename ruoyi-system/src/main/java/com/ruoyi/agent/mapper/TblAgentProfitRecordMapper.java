package com.ruoyi.agent.mapper;

import com.ruoyi.agent.domain.TblAgentProfitRecord;

import java.util.List;

/**
 * 代理商分润Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-19
 */
public interface TblAgentProfitRecordMapper 
{
    /**
     * 查询代理商分润
     * 
     * @param id 代理商分润主键
     * @return 代理商分润
     */
    public TblAgentProfitRecord selectTblAgentProfitRecordById(Long id);

    /**
     * 查询代理商分润列表
     * 
     * @param tblAgentProfitRecord 代理商分润
     * @return 代理商分润集合
     */
    public List<TblAgentProfitRecord> selectTblAgentProfitRecordList(TblAgentProfitRecord tblAgentProfitRecord);

    /**
     * 新增代理商分润
     * 
     * @param tblAgentProfitRecord 代理商分润
     * @return 结果
     */
    public int insertTblAgentProfitRecord(TblAgentProfitRecord tblAgentProfitRecord);

    /**
     * 修改代理商分润
     * 
     * @param tblAgentProfitRecord 代理商分润
     * @return 结果
     */
    public int updateTblAgentProfitRecord(TblAgentProfitRecord tblAgentProfitRecord);

    /**
     * 删除代理商分润
     * 
     * @param id 代理商分润主键
     * @return 结果
     */
    public int deleteTblAgentProfitRecordById(Long id);

    /**
     * 批量删除代理商分润
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblAgentProfitRecordByIds(String[] ids);
}
