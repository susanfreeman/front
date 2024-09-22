package com.ruoyi.blacklist.service.impl;

import java.util.List;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import com.ruoyi.blacklist.domain.TblUserBlacklist;
import com.ruoyi.blacklist.mapper.TblUserBlacklistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.blacklist.service.ITblUserBlacklistService;
import com.ruoyi.common.core.text.Convert;

/**
 * 黑名单列Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-21
 */
@Service
public class TblUserBlacklistServiceImpl implements ITblUserBlacklistService 
{
    @Autowired
    private TblUserBlacklistMapper tblUserBlacklistMapper;

    /**
     * 查询黑名单列
     * 
     * @param id 黑名单列主键
     * @return 黑名单列
     */
    @Override
    public TblUserBlacklist selectTblUserBlacklistById(Long id)
    {
        return tblUserBlacklistMapper.selectTblUserBlacklistById(id);
    }

    /**
     * 查询黑名单列列表
     * 
     * @param tblUserBlacklist 黑名单列
     * @return 黑名单列
     */
    @Override
    public List<TblUserBlacklist> selectTblUserBlacklistList(TblUserBlacklist tblUserBlacklist)
    {
        return tblUserBlacklistMapper.selectTblUserBlacklistList(tblUserBlacklist);
    }

    /**
     * 新增黑名单列
     * 
     * @param tblUserBlacklist 黑名单列
     * @return 结果
     */
    @Override
    public int insertTblUserBlacklist(TblUserBlacklist tblUserBlacklist)
    {
        tblUserBlacklist.setId(IdUtil.getSnowflakeNextIdStr());
        tblUserBlacklist.setCreatedAt(DateTime.now());
        return tblUserBlacklistMapper.insertTblUserBlacklist(tblUserBlacklist);
    }

    /**
     * 修改黑名单列
     * 
     * @param tblUserBlacklist 黑名单列
     * @return 结果
     */
    @Override
    public int updateTblUserBlacklist(TblUserBlacklist tblUserBlacklist)
    {
        tblUserBlacklist.setUpdatedAt(DateTime.now());
        return tblUserBlacklistMapper.updateTblUserBlacklist(tblUserBlacklist);
    }

    /**
     * 批量删除黑名单列
     * 
     * @param ids 需要删除的黑名单列主键
     * @return 结果
     */
    @Override
    public int deleteTblUserBlacklistByIds(String ids)
    {
        return tblUserBlacklistMapper.deleteTblUserBlacklistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除黑名单列信息
     * 
     * @param id 黑名单列主键
     * @return 结果
     */
    @Override
    public int deleteTblUserBlacklistById(Long id)
    {
        return tblUserBlacklistMapper.deleteTblUserBlacklistById(id);
    }
}
