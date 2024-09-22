package com.ruoyi.risk.mapper;

import com.ruoyi.risk.domain.TblOperatorCard;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-16
 */
public interface TblOperatorCardMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param ID 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblOperatorCard selectTblOperatorCardByID(Long ID);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblOperatorCard 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblOperatorCard> selectTblOperatorCardList(TblOperatorCard tblOperatorCard);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblOperatorCard 【请填写功能名称】
     * @return 结果
     */
    public int insertTblOperatorCard(TblOperatorCard tblOperatorCard);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblOperatorCard 【请填写功能名称】
     * @return 结果
     */
    public int updateTblOperatorCard(TblOperatorCard tblOperatorCard);

    /**
     * 删除【请填写功能名称】
     * 
     * @param ID 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblOperatorCardByID(Long ID);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblOperatorCardByIDs(String[] IDs);
}
