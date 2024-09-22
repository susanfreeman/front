package com.ruoyi.blacklist.service;

import com.ruoyi.blacklist.domain.TblUserBlacklist;

import java.util.List;

/**
 * 黑名单列Service接口
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
public interface ITblUserBlacklistService 
{
    /**
     * 查询黑名单列
     * 
     * @param id 黑名单列主键
     * @return 黑名单列
     */
    public TblUserBlacklist selectTblUserBlacklistById(Long id);

    /**
     * 查询黑名单列列表
     * 
     * @param tblUserBlacklist 黑名单列
     * @return 黑名单列集合
     */
    public List<TblUserBlacklist> selectTblUserBlacklistList(TblUserBlacklist tblUserBlacklist);

    /**
     * 新增黑名单列
     * 
     * @param tblUserBlacklist 黑名单列
     * @return 结果
     */
    public int insertTblUserBlacklist(TblUserBlacklist tblUserBlacklist);

    /**
     * 修改黑名单列
     * 
     * @param tblUserBlacklist 黑名单列
     * @return 结果
     */
    public int updateTblUserBlacklist(TblUserBlacklist tblUserBlacklist);

    /**
     * 批量删除黑名单列
     * 
     * @param ids 需要删除的黑名单列主键集合
     * @return 结果
     */
    public int deleteTblUserBlacklistByIds(String ids);

    /**
     * 删除黑名单列信息
     * 
     * @param id 黑名单列主键
     * @return 结果
     */
    public int deleteTblUserBlacklistById(Long id);
}
