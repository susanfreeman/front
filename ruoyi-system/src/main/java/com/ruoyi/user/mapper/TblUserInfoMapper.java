package com.ruoyi.user.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.ruoyi.user.domain.TblUserInfo;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-20
 */
public interface TblUserInfoMapper 
{
    /**
     * 查询用户信息
     * 
     * @param uiId 用户信息主键
     * @return 用户信息
     */
    public TblUserInfo selectTblUserInfoByUiId(Long uiId);

    /**
     * 查询用户信息列表
     * 
     * @param tblUserInfo 用户信息
     * @return 用户信息集合
     */
    public List<TblUserInfo> selectTblUserInfoList(TblUserInfo tblUserInfo);

    /**
     * 查询用户信息列表
     *
     * @param tblUserInfo 用户信息
     * @return 用户信息集合
     */
    public List<TblUserInfo> selectTblUserInfoListByCoinIsnotNull(TblUserInfo tblUserInfo);

    /**
     * 新增用户信息
     * 
     * @param tblUserInfo 用户信息
     * @return 结果
     */
    public int insertTblUserInfo(TblUserInfo tblUserInfo);

    /**
     * 修改用户信息
     * 
     * @param tblUserInfo 用户信息
     * @return 结果
     */
    public int updateTblUserInfo(TblUserInfo tblUserInfo);

    /**
     * 删除用户信息
     * 
     * @param uiId 用户信息主键
     * @return 结果
     */
    public int deleteTblUserInfoByUiId(Long uiId);

    /**
     * 批量删除用户信息
     * 
     * @param uiIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUserInfoByUiIds(String[] uiIds);

    public int updateTblUserInfoBalance(TblUserInfo tblUserInfo);

    TblUserInfo selectTblUserInfoByInviteUri(String inviteUri);

    TblUserInfo selectTblUserInfoByCarNo(String carNo);

    int updateTblUserInfoBalanceExchange(Map map);
}
