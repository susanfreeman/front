package com.ruoyi.user.mapper;

import java.util.List;
import com.ruoyi.user.domain.TblUserOpenCard;

/**
 * 用户开卡信息Mapper接口
 *
 * @author ruoyi
 * @date 2024-07-22
 */
public interface TblUserOpenCardMapper
{
    /**
     * 查询用户开卡信息
     *
     * @param uocId 用户开卡信息主键
     * @return 用户开卡信息
     */
    public TblUserOpenCard selectTblUserOpenCardByUocId(Long uocId);

    /**
     * 查询用户开卡信息列表
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 用户开卡信息集合
     */
    public List<TblUserOpenCard> selectTblUserOpenCardList(TblUserOpenCard tblUserOpenCard);

    /**
     * 查询用户开卡信息列表
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 用户开卡信息集合
     */
    public List<TblUserOpenCard> selectTblUserOpenCardListGtTransTime(TblUserOpenCard tblUserOpenCard);

    /**
     * 新增用户开卡信息
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    public int insertTblUserOpenCard(TblUserOpenCard tblUserOpenCard);

    /**
     * 修改用户开卡信息
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    public int updateTblUserOpenCard(TblUserOpenCard tblUserOpenCard);

    /**
     * 批量修改卡状态
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    public int batchUpdateStatus(TblUserOpenCard tblUserOpenCard);

    /**
     * 按状态 修改用户开卡信息
     *
     * @param tblUserOpenCard 用户开卡信息
     * @return 结果
     */
    public int updateTblUserOpenCardByStatus(TblUserOpenCard tblUserOpenCard);

    /**
     * 删除用户开卡信息
     *
     * @param uocId 用户开卡信息主键
     * @return 结果
     */
    public int deleteTblUserOpenCardByUocId(Long uocId);

    /**
     * 批量删除用户开卡信息
     *
     * @param uocIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUserOpenCardByUocIds(String[] uocIds);

    public TblUserOpenCard selectTblUserOpenCardByCardNo(String cardNo);
    public TblUserOpenCard selectTblUserOpenCardByCardId(String cardId);
}
